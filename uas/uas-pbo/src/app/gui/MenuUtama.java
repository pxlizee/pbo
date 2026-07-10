package app.gui;

import java.awt.GridLayout;
import javax.swing.*;

public class MenuUtama extends JFrame {
    public MenuUtama() {
        setTitle("Menu Utama Aplikasi Penjualan");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        JButton b1 = new JButton("CRUD Data Barang");
        JButton b2 = new JButton("CRUD Data Pelanggan");
        JButton b3 = new JButton("Form Transaksi");
        JButton b4 = new JButton("Laporan (View)");
        JButton b5 = new JButton("Logout");

        add(b1); add(b2); add(b3); add(b4); add(b5);

        b1.addActionListener(e -> new FormBarang().setVisible(true));
        b2.addActionListener(e -> new FormPelanggan().setVisible(true));
        b3.addActionListener(e -> new FormTransaksi().setVisible(true));
        b4.addActionListener(e -> new LaporanPenjualan().setVisible(true));
        b5.addActionListener(e -> { this.dispose(); new LoginForm().setVisible(true); });
    }
}