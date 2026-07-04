package sesi_13;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TokoRetail {

    private static final Scanner input = new Scanner(System.in);
    private static final List<Barang> daftarBarang = new ArrayList<>();

    public static void main(String[] args) {
        initDataAwal();
        while (true) {
            tampilkanMenu();
            System.out.print("Pilihan : ");
            String pilihan = input.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tampilSemuaData();
                    break;
                case "2":
                    tambahData();
                    break;
                case "3":
                    cariData();
                    break;
                case "4":
                    ubahData();
                    break;
                case "5":
                    hapusData();
                    break;
                case "0":
                    System.out.println("Keluar dari program. Terima kasih.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private static void initDataAwal() {
        daftarBarang.add(new Barang("B001", "Roti Tawar", 10000, 100));
        daftarBarang.add(new Barang("B002", "Malkist", 2000, 100));
        daftarBarang.add(new Barang("B003", "Kopi Kapal Api", 3000, 100));
    }

    private static void tampilkanMenu() {
        System.out.println("\nMENU TOKO RETAIL");
        System.out.println("1. Tampil Semua Data");
        System.out.println("2. Tambah Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Ubah Data");
        System.out.println("5. Hapus Data");
        System.out.println("0. Keluar");
    }

    private static void tampilSemuaData() {
        System.out.println("\nDAFTAR BARANG TOKO RETAIL");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-3s | %-6s | %-20s | %-8s | %-5s\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("-------------------------------------------------------------");

        int nomor = 1;
        for (Barang barang : daftarBarang) {
            System.out.printf("%-3d | %-6s | %-20s | %-8d | %-5d\n",
                    nomor,
                    barang.getKode(),
                    barang.getNama(),
                    barang.getHarga(),
                    barang.getStok());
            nomor++;
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total: " + daftarBarang.size() + " barang");
    }

    private static void tambahData() {
        System.out.println("\nTAMBAH DATA BARANG");
        System.out.print("Kode Barang : ");
        String kode = input.nextLine().trim();
        if (kode.isEmpty()) {
            System.out.println("Kode barang tidak boleh kosong.");
            return;
        }

        if (cariBarangByKode(kode).isPresent()) {
            System.out.println("Kode barang sudah ada. Gunakan kode lain.");
            return;
        }

        System.out.print("Nama Barang : ");
        String nama = input.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama barang tidak boleh kosong.");
            return;
        }

        int harga = bacaInteger("Harga Barang : ");
        int stok = bacaInteger("Stok Barang : ");
        daftarBarang.add(new Barang(kode, nama, harga, stok));
        System.out.println("Data berhasil ditambahkan.");
    }

    private static void cariData() {
        System.out.println("\nCARI DATA BARANG");
        System.out.print("Masukkan kode atau nama barang: ");
        String keyword = input.nextLine().trim().toLowerCase();

        List<Barang> hasil = new ArrayList<>();
        for (Barang barang : daftarBarang) {
            if (barang.getKode().toLowerCase().contains(keyword)
                    || barang.getNama().toLowerCase().contains(keyword)) {
                hasil.add(barang);
            }
        }

        if (hasil.isEmpty()) {
            System.out.println("Barang tidak ditemukan.");
            return;
        }

        System.out.println("\nHASIL PENCARIAN");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-3s | %-6s | %-20s | %-8s | %-5s\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("-------------------------------------------------------------");

        int nomor = 1;
        for (Barang barang : hasil) {
            System.out.printf("%-3d | %-6s | %-20s | %-8d | %-5d\n",
                    nomor,
                    barang.getKode(),
                    barang.getNama(),
                    barang.getHarga(),
                    barang.getStok());
            nomor++;
        }
    }

    private static void ubahData() {
        System.out.println("\nUBAH DATA BARANG");
        System.out.print("Masukkan kode barang yang akan diubah: ");
        String kode = input.nextLine().trim();

        Optional<Barang> barangOpt = cariBarangByKode(kode);
        if (barangOpt.isEmpty()) {
            System.out.println("Barang dengan kode tersebut tidak ditemukan.");
            return;
        }

        Barang barang = barangOpt.get();
        System.out.println("Nama lama: " + barang.getNama());
        System.out.print("Nama baru (kosong untuk tidak berubah): ");
        String namaBaru = input.nextLine().trim();
        if (!namaBaru.isEmpty()) {
            barang.setNama(namaBaru);
        }

        System.out.println("Harga lama: " + barang.getHarga());
        String hargaBaruText = bacaTeks("Harga baru (kosong untuk tidak berubah): ");
        if (!hargaBaruText.isEmpty()) {
            barang.setHarga(parseInteger(hargaBaruText, barang.getHarga()));
        }

        System.out.println("Stok lama: " + barang.getStok());
        String stokBaruText = bacaTeks("Stok baru (kosong untuk tidak berubah): ");
        if (!stokBaruText.isEmpty()) {
            barang.setStok(parseInteger(stokBaruText, barang.getStok()));
        }

        System.out.println("Data berhasil diperbarui.");
    }

    private static void hapusData() {
        System.out.println("\nHAPUS DATA BARANG");
        System.out.print("Masukkan kode barang yang akan dihapus: ");
        String kode = input.nextLine().trim();

        Optional<Barang> barangOpt = cariBarangByKode(kode);
        if (barangOpt.isEmpty()) {
            System.out.println("Barang dengan kode tersebut tidak ditemukan.");
            return;
        }

        daftarBarang.remove(barangOpt.get());
        System.out.println("Data berhasil dihapus.");
    }

    private static Optional<Barang> cariBarangByKode(String kode) {
        return daftarBarang.stream()
                .filter(barang -> barang.getKode().equalsIgnoreCase(kode))
                .findFirst();
    }

    private static int bacaInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan ulangi.");
            }
        }
    }

    private static String bacaTeks(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    private static int parseInteger(String text, int defaultValue) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid, nilai lama tetap digunakan.");
            return defaultValue;
        }
    }

    private static class Barang {
        private final String kode;
        private String nama;
        private int harga;
        private int stok;

        public Barang(String kode, String nama, int harga, int stok) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
            this.stok = stok;
        }

        public String getKode() {
            return kode;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public int getHarga() {
            return harga;
        }

        public void setHarga(int harga) {
            this.harga = harga;
        }

        public int getStok() {
            return stok;
        }

        public void setStok(int stok) {
            this.stok = stok;
        }
    }
}
