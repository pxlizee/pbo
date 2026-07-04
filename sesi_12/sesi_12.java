package sesi_12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sesi_12 extends JFrame {
    private JTextField nimField;
    private JTextField namaField;
    private JTextField programStudiField;
    private JTextArea outputArea;
    private JButton tampilkanButton;
    private JButton resetButton;

    public sesi_12() {
        // Frame setup
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Input Data section
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Data"));

        // NIM
        JPanel nimPanel = new JPanel();
        nimPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel nimLabel = new JLabel("NIM");
        nimLabel.setPreferredSize(new Dimension(100, 25));
        nimField = new JTextField(20);
        nimPanel.add(nimLabel);
        nimPanel.add(nimField);

        // Nama
        JPanel namaPanel = new JPanel();
        namaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setPreferredSize(new Dimension(100, 25));
        namaField = new JTextField(20);
        namaPanel.add(namaLabel);
        namaPanel.add(namaField);

        // Program Studi
        JPanel programPanel = new JPanel();
        programPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel programLabel = new JLabel("Program Studi");
        programLabel.setPreferredSize(new Dimension(100, 25));
        programStudiField = new JTextField(20);
        programPanel.add(programLabel);
        programPanel.add(programStudiField);

        inputPanel.add(nimPanel);
        inputPanel.add(namaPanel);
        inputPanel.add(programPanel);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tampilkanButton = new JButton("Tampilkan");
        resetButton = new JButton("Reset");
        
        tampilkanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tampilkanData();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetData();
            }
        });

        buttonPanel.add(tampilkanButton);
        buttonPanel.add(resetButton);

        // Output section
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));
        
        outputArea = new JTextArea(12, 40);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add all components to main panel
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(outputPanel);

        add(mainPanel);
        setVisible(true);
    }

    private void tampilkanData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String programStudi = programStudiField.getText();

        if (nim.isEmpty() || nama.isEmpty() || programStudi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder output = new StringBuilder();
        output.append("========== BIODATA MAHASISWA ==========\n\n");
        output.append("NIM            : ").append(nim).append("\n");
        output.append("Nama           : ").append(nama).append("\n");
        output.append("Program Studi  : ").append(programStudi).append("\n");

        outputArea.setText(output.toString());
    }

    private void resetData() {
        nimField.setText("");
        namaField.setText("");
        programStudiField.setText("");
        outputArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new sesi_12();
            }
        });
    }
}
