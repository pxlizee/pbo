package sesi_4;

import java.util.Scanner;

public class Bank {
    protected String namaBank;
    protected static final double BIAYA_TRANSFER_SESAMA = 0;
    protected static final double BIAYA_TRANSFER_BEDA_BANK = 6500;
    
    public Bank() {
        this.namaBank = "Bank Umum";
    }
    
    public void transferUang(int jumlah, String rekeningTujuan) {
        double biaya = hitungBiayaTransfer(namaBank);
        double total = jumlah + biaya;
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           TRANSFER SESAMA BANK                         ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank Asal     : " + String.format("%-36s", namaBank) + "║");
        System.out.println("║ Rekening Tujuan: " + String.format("%-35s", rekeningTujuan) + "║");
        System.out.println("║ Jumlah        : Rp " + String.format("%-33s", String.format("%,d", jumlah)) + "║");
        System.out.println("║ Biaya Transfer: Rp " + String.format("%-33s", String.format("%,.0f", biaya)) + "║");
        System.out.println("║ Total         : Rp " + String.format("%-33s", String.format("%,.0f", total)) + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ Transfer berhasil!\n");
    }
    
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        double biaya = hitungBiayaTransfer(bankTujuan);
        double total = jumlah + biaya;
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           TRANSFER ANTAR BANK                          ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank Asal     : " + String.format("%-36s", namaBank) + "║");
        System.out.println("║ Bank Tujuan   : " + String.format("%-36s", bankTujuan) + "║");
        System.out.println("║ Rekening Tujuan: " + String.format("%-35s", rekeningTujuan) + "║");
        System.out.println("║ Jumlah        : Rp " + String.format("%-33s", String.format("%,d", jumlah)) + "║");
        System.out.println("║ Biaya Transfer: Rp " + String.format("%-33s", String.format("%,.0f", biaya)) + "║");
        System.out.println("║ Total         : Rp " + String.format("%-33s", String.format("%,.0f", total)) + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ Transfer berhasil!\n");
    }
    
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        double biaya = hitungBiayaTransfer(bankTujuan);
        double total = jumlah + biaya;
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           TRANSFER DENGAN BERITA                       ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank Asal     : " + String.format("%-36s", namaBank) + "║");
        System.out.println("║ Bank Tujuan   : " + String.format("%-36s", bankTujuan) + "║");
        System.out.println("║ Rekening Tujuan: " + String.format("%-35s", rekeningTujuan) + "║");
        System.out.println("║ Jumlah        : Rp " + String.format("%-33s", String.format("%,d", jumlah)) + "║");
        System.out.println("║ Berita        : " + String.format("%-36s", berita) + "║");
        System.out.println("║ Biaya Transfer: Rp " + String.format("%-33s", String.format("%,.0f", biaya)) + "║");
        System.out.println("║ Total         : Rp " + String.format("%-33s", String.format("%,.0f", total)) + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ Transfer berhasil!\n");
    }
    
    protected double hitungBiayaTransfer(String bankTujuan) {
        if (bankTujuan.equalsIgnoreCase(namaBank)) {
            return BIAYA_TRANSFER_SESAMA;
        } else {
            return BIAYA_TRANSFER_BEDA_BANK;
        }
    }
    
    public void sukuBunga() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              INFORMASI SUKU BUNGA                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank          : " + String.format("%-36s", namaBank) + "║");
        System.out.println("║ Suku Bunga    : " + String.format("%-36s", "3% per tahun") + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
    }
    
    public String getNamaBank() {
        return namaBank;
    }
}