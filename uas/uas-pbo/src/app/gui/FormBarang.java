package app.gui;

import app.koneksi.KoneksiDB;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormBarang extends JFrame {
    private JTextField txtId, txtNama, txtHarga, txtStok, txtCari;
    private JTable tabel;
    private DefaultTableModel model;

    public FormBarang() {
        setTitle("CRUD & Cari Barang");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JPanel pInput = new JPanel(new GridLayout(5, 2, 5, 5));
        pInput.add(new JLabel(" ID (Auto):")); txtId = new JTextField(); txtId.setEditable(false); pInput.add(txtId);
        pInput.add(new JLabel(" Nama Barang:")); txtNama = new JTextField(); pInput.add(txtNama);
        pInput.add(new JLabel(" Harga:")); txtHarga = new JTextField(); pInput.add(txtHarga);
        pInput.add(new JLabel(" Stok:")); txtStok = new JTextField(); pInput.add(txtStok);
        pInput.add(new JLabel(" Ketik Nama untuk Cari:")); txtCari = new JTextField(); pInput.add(txtCari);
        add(pInput, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID", "Nama Barang", "Harga", "Stok"}, 0);
        tabel = new JTable(model);
        add(new JScrollPane(tabel), BorderLayout.CENTER);

        JPanel pAksi = new JPanel();
        JButton btnAdd = new JButton("Simpan");
        JButton btnUp = new JButton("Edit");
        JButton btnDel = new JButton("Hapus");
        pAksi.add(btnAdd); pAksi.add(btnUp); pAksi.add(btnDel);
        add(pAksi, BorderLayout.SOUTH);

        refreshData("");

        txtCari.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { refreshData(txtCari.getText()); }
        });

        tabel.getSelectionModel().addListSelectionListener(e -> {
            if (tabel.getSelectedRow() != -1) {
                int r = tabel.getSelectedRow();
                txtId.setText(model.getValueAt(r,0).toString());
                txtNama.setText(model.getValueAt(r,1).toString());
                txtHarga.setText(model.getValueAt(r,2).toString());
                txtStok.setText(model.getValueAt(r,3).toString());
            }
        });

        btnAdd.addActionListener(e -> {
            try {
                PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("INSERT INTO barang(nama_barang,harga,stok) VALUES(?,?,?)");
                ps.setString(1, txtNama.getText()); ps.setInt(2, Integer.parseInt(txtHarga.getText())); ps.setInt(3, Integer.parseInt(txtStok.getText()));
                ps.executeUpdate(); refreshData(""); clear();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });

        btnUp.addActionListener(e -> {
            try {
                PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("UPDATE barang SET nama_barang=?, harga=?, stok=? WHERE id_barang=?");
                ps.setString(1, txtNama.getText()); ps.setInt(2, Integer.parseInt(txtHarga.getText())); ps.setInt(3, Integer.parseInt(txtStok.getText())); ps.setInt(4, Integer.parseInt(txtId.getText()));
                ps.executeUpdate(); refreshData(""); clear();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });

        btnDel.addActionListener(e -> {
            try {
                PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("DELETE FROM barang WHERE id_barang=?");
                ps.setInt(1, Integer.parseInt(txtId.getText()));
                ps.executeUpdate(); refreshData(""); clear();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });
    }

    private void refreshData(String key) {
        model.setRowCount(0);
        try {
            PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("SELECT * FROM barang WHERE nama_barang LIKE ?");
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) { model.addRow(new Object[]{rs.getInt("id_barang"), rs.getString("nama_barang"), rs.getInt("harga"), rs.getInt("stok")}); }
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
    }
    private void clear() { txtId.setText(""); txtNama.setText(""); txtHarga.setText(""); txtStok.setText(""); }
}