package sesi_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String fileAsal = "students.csv";
        String fileTujuan = "students_backup.csv";
        String line;

        System.out.println("Memulai proses penyalinan file...");

        // Membuka file asal untuk dibaca dan membuat file tujuan untuk ditulis
        try (BufferedReader br = new BufferedReader(new FileReader(fileAsal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTujuan))) {

            while ((line = br.readLine()) != null) {
                bw.write(line);   // Tulis baris yang dibaca ke file tujuan
                bw.newLine();     // Berikan enter/pindah baris baru di file tujuan
            }

            System.out.println("Penyalinan selesai! File berhasil dicopy ke: " + fileTujuan);

        } catch (IOException e) {
            System.out.println("Gagal melakukan penyalinan file.");
            e.printStackTrace();
        }
    }
}