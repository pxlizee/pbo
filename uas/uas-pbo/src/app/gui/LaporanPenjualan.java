package app.gui;

import app.koneksi.KoneksiDB;
import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanPenjualan extends JFrame {
    public LaporanPenjualan() {
        setTitle("Laporan Penjualan (Membaca MySQL View)");
        setSize(650, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Nota", "Waktu", "Pelanggan", "Barang", "QTY", "subtotal", "Subtotal"}, 0);
        JTable tabel = new JTable(model);
        add(new JScrollPane(tabel), BorderLayout.CENTER);

        try {
            // Membaca dari VIEW v_laporan_penjualan
            ResultSet rs = KoneksiDB.getKoneksi().createStatement().executeQuery("SELECT * FROM v_laporan_penjualan");
            while(rs.next()) {
                model.addRow(new Object[]{rs.getInt("id_transaksi"), rs.getTimestamp("tgl_transaksi"), rs.getString("nama_pelanggan"), rs.getString("nama_barang"), rs.getInt("qty"), rs.getInt("subtotal"), rs.getInt("subtotal")});
            }
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
    }
}