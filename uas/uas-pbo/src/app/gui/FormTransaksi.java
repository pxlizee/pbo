package app.gui;

import app.koneksi.KoneksiDB;
import java.awt.GridLayout;
import java.sql.*;
import javax.swing.*;

public class FormTransaksi extends JFrame {
    private JTextField txtPelanggan, txtBarang, txtQty;

    public FormTransaksi() {
        setTitle("Form Transaksi Kasir");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("  ID Pelanggan:")); txtPelanggan = new JTextField("1"); add(txtPelanggan);
        add(new JLabel("  ID Barang:")); txtBarang = new JTextField(); add(txtBarang);
        add(new JLabel("  QTY (Jumlah):")); txtQty = new JTextField(); add(txtQty);

        JButton btnOrder = new JButton("Bayar / Checkout"); add(new JLabel("")); add(btnOrder);

        btnOrder.addActionListener(e -> {
            try {
                Connection conn = KoneksiDB.getKoneksi();
                
                // Panggil Stored Procedure
                CallableStatement cs = conn.prepareCall("{call sp_buat_transaksi(?, ?)}");
                cs.setInt(1, Integer.parseInt(txtPelanggan.getText()));
                cs.registerOutParameter(2, Types.INTEGER);
                cs.execute();
                int idNota = cs.getInt(2);

                PreparedStatement psB = conn.prepareStatement("SELECT harga FROM barang WHERE id_barang=?");
                psB.setInt(1, Integer.parseInt(txtBarang.getText()));
                ResultSet rsB = psB.executeQuery();
                
                if (rsB.next()) {
                    int harga = rsB.getInt("harga");
                    int qty = Integer.parseInt(txtQty.getText());
                    int subtotal = harga * qty;

                    PreparedStatement psD = conn.prepareStatement("INSERT INTO detail_transaksi(id_transaksi,id_barang,qty,subtotal) VALUES(?,?,?,?)");
                    psD.setInt(1, idNota); psD.setInt(2, Integer.parseInt(txtBarang.getText())); psD.setInt(3, qty); psD.setInt(4, subtotal);
                    psD.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Berhasil! Nota ID: " + idNota + "\nStok terpotong otomatis lewat Trigger Database.");
                    this.dispose();
                }
            } catch (SQLException ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
        });
    }
}