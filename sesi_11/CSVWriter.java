package sesi_11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Tambah Data Siswa Baru ===");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Umur: ");
        String umur = scanner.nextLine();
        
        System.out.print("Masukkan Prodi: ");
        String prodi = scanner.nextLine();

        // Gabungkan input menjadi format CSV dengan pemisah titik koma
        String dataBaru = nim + ";" + nama + ";" + umur + ";" + prodi;

        // Mode true untuk mengaktifkan append (menambah ke baris bawahnya)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            bw.write(dataBaru);
            bw.newLine(); // Pindah ke baris baru agar data selanjutnya tidak menempel
            System.out.println("Data baru berhasil disimpan ke " + csvFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file.");
            e.printStackTrace();
        } finally {
            scanner.close(); 
        }
    }
}