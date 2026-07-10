package app.gui;

import app.koneksi.KoneksiDB;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormPelanggan extends JFrame {
    private JTextField txtId, txtNama, txtTelp, txtAlamat, txtCari;
    private JTable tabel;
    private DefaultTableModel model;

    public FormPelanggan() {
        setTitle("CRUD & Cari Pelanggan");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JPanel pInput = new JPanel(new GridLayout(5, 2, 5, 5));
        pInput.add(new JLabel(" ID Pelanggan:")); txtId = new JTextField(); txtId.setEditable(false); pInput.add(txtId);
        pInput.add(new JLabel(" Nama Pelanggan:")); txtNama = new JTextField(); pInput.add(txtNama);
        pInput.add(new JLabel(" No Telp:")); txtTelp = new JTextField(); pInput.add(txtTelp);
        pInput.add(new JLabel(" Alamat:")); txtAlamat = new JTextField(); pInput.add(txtAlamat);
        pInput.add(new JLabel(" Ketik Nama untuk Cari:")); txtCari = new JTextField(); pInput.add(txtCari);
        add(pInput, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID", "Nama Pelanggan", "No Telp", "Alamat"}, 0);
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
                txtTelp.setText(model.getValueAt(r,2).toString());
                txtAlamat.setText(model.getValueAt(r,3).toString());
            }
        });

        btnAdd.addActionListener(e -> {
            try {
                PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("INSERT INTO pelanggan(nama_pelanggan,no_telepon,alamat) VALUES(?,?,?)");
                ps.setString(1, txtNama.getText()); ps.setString(2, txtTelp.getText()); ps.setString(3, txtAlamat.getText());
                ps.executeUpdate(); refreshData(""); clear();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });

        btnUp.addActionListener(e -> {
            try {
                PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("UPDATE pelanggan SET nama_pelanggan=?, no_telepon=?, alamat=? WHERE id_pelanggan=?");
                ps.setString(1, txtNama.getText()); ps.setString(2, txtTelp.getText()); ps.setString(3, txtAlamat.getText()); ps.setInt(4, Integer.parseInt(txtId.getText()));
                ps.executeUpdate(); refreshData(""); clear();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });

        btnDel.addActionListener(e -> {
            try {
                PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("DELETE FROM pelanggan WHERE id_pelanggan=?");
                ps.setInt(1, Integer.parseInt(txtId.getText()));
                ps.executeUpdate(); refreshData(""); clear();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });
    }

    private void refreshData(String key) {
        model.setRowCount(0);
        try {
            PreparedStatement ps = KoneksiDB.getKoneksi().prepareStatement("SELECT * FROM pelanggan WHERE nama_pelanggan LIKE ?");
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) { model.addRow(new Object[]{rs.getInt("id_pelanggan"), rs.getString("nama_pelanggan"), rs.getString("no_telepon"), rs.getString("alamat")}); }
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
    }
    private void clear() { txtId.setText(""); txtNama.setText(""); txtTelp.setText(""); txtAlamat.setText(""); }
}