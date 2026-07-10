package app.gui;

import app.koneksi.KoneksiDB;
import java.awt.GridLayout;
import java.sql.*;
import javax.swing.*;

public class LoginForm extends JFrame{
    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginForm() {
        setTitle("Form Login");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        add(new JLabel("Username:")); txtUser = new JTextField(); add(txtUser);
        add(new JLabel("Password:")); txtPass = new JPasswordField(); add(txtPass);

        JButton btnLogin = new JButton("Login");
        add(new JLabel("")); add(btnLogin);

        btnLogin.addActionListener(e -> {
            try {
                Connection conn = KoneksiDB.getKoneksi();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, txtUser.getText());
                ps.setString(2, new String(txtPass.getPassword()));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Berhasil!");
                    try {
                        new MenuUtama().setVisible(true);
                        this.dispose(); // Menutup form login setelah berhasil login
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuka menu utama: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                    // Lanjutkan ke form utama atau dashboard
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password salah!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
    
}
