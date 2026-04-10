package sesi_4;

public class BankBNI extends Bank {
    
    public BankBNI() {
        super();
        this.namaBank = "BNI";
    }
    
    @Override
    public void sukuBunga() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              INFORMASI SUKU BUNGA                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank          : " + String.format("%-36s", "BNI") + "║");
        System.out.println("║ Suku Bunga    : " + String.format("%-36s", "4% per tahun") + "║");
        System.out.println("║ Keterangan    : " + String.format("%-36s", "Tabungan BNI") + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
    }
    
   
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        double biaya;
        String keterangan;
        
        // Cek apakah transfer sesama BNI atau beda bank
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            biaya = BIAYA_TRANSFER_SESAMA;
            keterangan = "Transfer Sesama BNI - GRATIS";
        } else {
            biaya = BIAYA_TRANSFER_BEDA_BANK;
            keterangan = "Transfer ke " + bankTujuan + " - Biaya Rp 6.500";
        }
        
        double total = jumlah + biaya;
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           TRANSFER " + (bankTujuan.equalsIgnoreCase("BNI") ? "SESAMA BNI" : "ANTAR BANK") + "                          ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank Asal     : " + String.format("%-36s", namaBank) + "║");
        System.out.println("║ Bank Tujuan   : " + String.format("%-36s", bankTujuan) + "║");
        System.out.println("║ Rekening Tujuan: " + String.format("%-35s", rekeningTujuan) + "║");
        System.out.println("║ Jumlah        : Rp " + String.format("%-33s", String.format("%,d", jumlah)) + "║");
        System.out.println("║ Biaya Transfer: Rp " + String.format("%-33s", String.format("%,.0f", biaya)) + "║");
        System.out.println("║ Total         : Rp " + String.format("%-33s", String.format("%,.0f", total)) + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ " + keterangan);
        System.out.println("✓ Transfer berhasil!\n");
    }
    
    @Override
    public void transferUang(int jumlah, String rekeningTujuan) {
        // Transfer tanpa parameter bank = asumsikan sesama BNI
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           TRANSFER SESAMA BNI                          ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Bank Asal     : BNI                                    ║");
        System.out.println("║ Bank Tujuan   : BNI (Sesama)                           ║");
        System.out.println("║ Rekening Tujuan: " + String.format("%-35s", rekeningTujuan) + "║");
        System.out.println("║ Jumlah        : Rp " + String.format("%-33s", String.format("%,d", jumlah)) + "║");
        System.out.println("║ Biaya Transfer: Rp 0 (GRATIS)                          ║");
        System.out.println("║ Total         : Rp " + String.format("%-33s", String.format("%,d", jumlah)) + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ Transfer sesama BNI berhasil - GRATIS biaya admin!\n");
    }
    
    // Override method dengan 4 parameter juga untuk konsistensi
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        double biaya;
        
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            biaya = BIAYA_TRANSFER_SESAMA;
        } else {
            biaya = BIAYA_TRANSFER_BEDA_BANK;
        }
        
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
}