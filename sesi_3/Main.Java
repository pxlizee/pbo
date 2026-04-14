package sesi_3;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Penilaian> daftarPenilaian = new ArrayList<>();
        
        System.out.println("=== Program Entri Nilai Mahasiswa ===");
        
        // Loop untuk input data
        while (true) {
            System.out.print("\nMasukkan NIM   : ");
            String nim = scanner.nextLine();
            
            System.out.print("Masukkan Nama  : ");
            String nama = scanner.nextLine();
            
            System.out.print("Masukkan Nilai : ");
            double nilai = Double.parseDouble(scanner.nextLine());
            
            // Validasi nilai 0-100
            if (nilai < 0 || nilai > 100) {
                System.out.println("Notifikasi: Input nilai anda salah");
            } else {
                Penilaian mhs = new Penilaian(nim, nama, nilai);
                daftarPenilaian.add(mhs);
                System.out.println("Data berhasil disimpan.");
            }
            
            System.out.print("\nInput data lagi? (y/n): ");
            String lanjut = scanner.nextLine();
            if (lanjut.equalsIgnoreCase("n")) {
                break;
            }
        }

        //--- Proses Output dan Statistik ---
        if (daftarPenilaian.isEmpty()) {
            System.out.println("Tidak ada data yang diinput.");
            return;
        }

        System.out.println("\n=== HASIL OUTPUT ===\n");
        
        double totalNilai = 0;
        List<String> lulus = new ArrayList<>();
        List<String> tidakLulus = new ArrayList<>();
        List<String> gradeA = new ArrayList<>();
        List<String> gradeB = new ArrayList<>();
        List<String> gradeC = new ArrayList<>();
        List<String> gradeD = new ArrayList<>();
        List<String> gradeE = new ArrayList<>();
        List<String> rincianNilai = new ArrayList<>();

        // Menampilkan data per mahasiswa dan mengumpulkan statistik
        for (Penilaian p : daftarPenilaian) {
            System.out.println("NIM   : " + p.getNim());
            System.out.println("Nama  : " + p.getNama());
            System.out.println("Nilai : " + (p.getNilai() % 1 == 0 ? (int)p.getNilai() : p.getNilai()));
            System.out.println("Grade : " + p.getGrade());
            System.out.println("===\n");

            totalNilai += p.getNilai();
            rincianNilai.add(String.valueOf(p.getNilai() % 1 == 0 ? (int)p.getNilai() : p.getNilai()));

            if (p.isLulus()) lulus.add(p.getNama());
            else tidakLulus.add(p.getNama());

            switch (p.getGrade()) {
                case "A": gradeA.add(p.getNama()); break;
                case "B": gradeB.add(p.getNama()); break;
                case "C": gradeC.add(p.getNama()); break;
                case "D": gradeD.add(p.getNama()); break;
                case "E": gradeE.add(p.getNama()); break;
            }
        }

        // Menampilkan Summary / Statistik
        int jumlahMhs = daftarPenilaian.size();
        System.out.println("Jumlah Mahasiswa: " + jumlahMhs + "\n");
        
        cetakStatistik("Jumlah Mahasiswa yg Lulus", lulus);
        cetakStatistik("Jumlah Mahasiswa yg Tidak Lulus", tidakLulus);
        cetakStatistik("Jumlah Mahasiswa dengan Nilai A", gradeA);
        cetakStatistik("Jumlah Mahasiswa dengan Nilai B", gradeB);
        cetakStatistik("Jumlah Mahasiswa dengan Nilai C", gradeC);
        cetakStatistik("Jumlah Mahasiswa dengan Nilai D", gradeD);
        cetakStatistik("Jumlah Mahasiswa dengan Nilai E", gradeE);

        // Menghitung dan menampilkan rata-rata
        double rataRata = totalNilai / jumlahMhs;
        String stringRumus = String.join(" + ", rincianNilai);
        System.out.printf("Rata-rata nilai mahasiswa adalah: %s / %d = %.2f\n", stringRumus, jumlahMhs, rataRata);
        
        scanner.close();
    }
    
    // Method bantuan untuk mencetak format summary list nama
    private static void cetakStatistik(String label, List<String> daftarNama) {
        if (!daftarNama.isEmpty()) {
            System.out.println(label + ": " + daftarNama.size() + " yaitu " + String.join(", ", daftarNama));
        }
    }
}