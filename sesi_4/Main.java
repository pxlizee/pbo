package sesi_4;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Bank bankAktif = null;
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            tampilkanMenuUtama();
            int pilihan = inputAngka("Pilih menu: ");
            
            switch (pilihan) {
                case 1:
                    pilihBank();
                    break;
                case 2:
                    if (cekBank()) menuTransfer();
                    break;
                case 3:
                    if (cekBank()) bankAktif.sukuBunga();
                    break;
                case 4:
                    running = false;
                    System.out.println("\n✓ Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("\n✗ Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
    
    static void tampilkanMenuUtama() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                              ║");
        System.out.println("║          SISTEM TRANSAKSI PERBANKAN INTERAKTIF               ║");
        System.out.println("║                                                              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Bank Aktif: " + String.format("%-46s", (bankAktif != null ? bankAktif.getNamaBank() : "Belum dipilih")) + "║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                              ║");
        System.out.println("║   1. Pilih Bank Anda (BNI / BCA / Bank Umum)                 ║");
        System.out.println("║   2. Menu Transfer Uang                                      ║");
        System.out.println("║   3. Cek Suku Bunga                                          ║");
        System.out.println("║   4. Keluar                                                  ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
    
    static void pilihBank() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    PILIH BANK ANDA                           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║   1. BNI (Suku Bunga 4%)                                     ║");
        System.out.println("║   2. BCA (Suku Bunga 4.5%)                                   ║");
        System.out.println("║   3. Bank Umum (Suku Bunga 3%)                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        int pilihan = inputAngka("Pilih bank (1-3): ");
        
        switch (pilihan) {
            case 1:
                bankAktif = new BankBNI();
                System.out.println("\n✓ Anda memilih BNI");
                break;
            case 2:
                bankAktif = new BankBCA();
                System.out.println("\n✓ Anda memilih BCA");
                break;
            case 3:
                bankAktif = new Bank();
                System.out.println("\n✓ Anda memilih Bank Umum");
                break;
            default:
                System.out.println("\n✗ Pilihan tidak valid!");
        }
    }
    
    static void menuTransfer() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    MENU TRANSFER                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║   1. Transfer Sesama Bank (Tanpa Biaya)                      ║");
        System.out.println("║   2. Transfer ke Bank Lain (Biaya Rp 6.500)                  ║");
        System.out.println("║   3. Transfer dengan Berita Transfer                         ║");
        System.out.println("║   4. Kembali ke Menu Utama                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        int pilihan = inputAngka("Pilih jenis transfer (1-4): ");
        
        switch (pilihan) {
            case 1:
                transferSesamaBank();
                break;
            case 2:
                transferAntarBank();
                break;
            case 3:
                transferDenganBerita();
                break;
            case 4:
                return;
            default:
                System.out.println("\n✗ Pilihan tidak valid!");
        }
    }
    
    static void transferSesamaBank() {
        System.out.println("\n────────── TRANSFER SESAMA BANK ──────────");
        System.out.println("Biaya Transfer: GRATIS");
        
        String rekening = inputTeks("Masukkan Nomor Rekening Tujuan: ");
        int jumlah = inputAngka("Masukkan Jumlah Transfer: Rp ");
        
        if (konfirmasi("Yakin ingin transfer Rp " + String.format("%,d", jumlah) + " ke rekening " + rekening + "?")) {
            bankAktif.transferUang(jumlah, rekening);
        } else {
            System.out.println("✓ Transfer dibatalkan.");
        }
    }
    
    static void transferAntarBank() {
        System.out.println("\n────────── TRANSFER ANTAR BANK ──────────");
        System.out.println("Biaya Transfer: Rp 6.500");
        
        String rekening = inputTeks("Masukkan Nomor Rekening Tujuan: ");
        String bankTujuan = inputTeks("Masukkan Nama Bank Tujuan (contoh: Mandiri, BRI, BNI, BCA): ");
        int jumlah = inputAngka("Masukkan Jumlah Transfer: Rp ");
        
        if (konfirmasi("Yakin ingin transfer Rp " + String.format("%,d", jumlah) + " ke " + bankTujuan + " - " + rekening + "?")) {
            bankAktif.transferUang(jumlah, rekening, bankTujuan);
        } else {
            System.out.println("✓ Transfer dibatalkan.");
        }
    }
    
    static void transferDenganBerita() {
        System.out.println("\n────────── TRANSFER DENGAN BERITA ──────────");
        
        String rekening = inputTeks("Masukkan Nomor Rekening Tujuan: ");
        String bankTujuan = inputTeks("Masukkan Nama Bank Tujuan: ");
        int jumlah = inputAngka("Masukkan Jumlah Transfer: Rp ");
        String berita = inputTeks("Masukkan Berita/Keterangan (contoh: Uang Kuliah, Bayar Kos, dll): ");
        
        System.out.println("\n────────── RINCIAN TRANSFER ──────────");
        System.out.println("Bank Tujuan    : " + bankTujuan);
        System.out.println("No. Rekening   : " + rekening);
        System.out.println("Jumlah         : Rp " + String.format("%,d", jumlah));
        System.out.println("Berita         : " + berita);
        
        if (konfirmasi("Lanjutkan transfer?")) {
            bankAktif.transferUang(jumlah, rekening, bankTujuan, berita);
        } else {
            System.out.println("✓ Transfer dibatalkan.");
        }
    }
    
    // Helper methods
    static String inputTeks(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine().trim();
    }
    
    static int inputAngka(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = Integer.parseInt(scanner.nextLine());
                if (angka < 0) {
                    System.out.println("✗ Nilai tidak boleh negatif!");
                    continue;
                }
                return angka;
            } catch (NumberFormatException e) {
                System.out.println("✗ Masukkan angka yang valid!");
            }
        }
    }
    
    static boolean konfirmasi(String pesan) {
        System.out.print(pesan + " (y/n): ");
        String jawaban = scanner.nextLine().trim().toLowerCase();
        return jawaban.equals("y") || jawaban.equals("ya");
    }
    
    static boolean cekBank() {
        if (bankAktif == null) {
            System.out.println("\n✗ Silakan pilih bank terlebih dahulu (Menu 1)!");
            return false;
        }
        return true;
    }
}