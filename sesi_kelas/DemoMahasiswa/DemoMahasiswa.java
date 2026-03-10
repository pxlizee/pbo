package DemoMahasiswa;
class Mahasiswa {
    // ===== Atribut (Properties) =====
    //'private' artinya hanya bisa di akses di dalam class ini saja
    private String nama;
    private int umur;

    // ===== Constructor =====
    // Constructor akan otomatis dipanggil saat object baru di buat dengan "new"
    // Parameter di dalam constructor bisa di gunakan untuk mengisi nilai awal atribut
    Mahasiswa(String nama, int umur) {
        // Kata kunci "this" digunakan untuk  membedakan
        // antara atribut class (this.nama) dengan parameter constructor (nama)
        this.nama = nama; 
        this.umur = umur; 
    }

    // ===== Getter =====
    // Getter dipakai untuk "membaca"/ mengambil nilai atribut
    public String getNama() {
        return this.nama; // "this.nama" merujuk pada atribut nama di dalam class ini
    }

    public int getUmur() {
        return this.umur; // "this.umur" merujuk pada atribut umur di dalam class ini
    }

    // ===== Setter =====
    // Setter dipakai untuk "mengubah"/ mengisi nilai atribut dari luar class
    public void setNama(String nama) {
        // Gunakan "this" agar jelas bahwa yang di kiri adalah atribut
        // dan yang di kanan adalah parameter
        this.nama = nama;
    }

    public void setUmur(int umur) {
        // bisa tambahkan logika sederhana misalnya validasi
        if (umur > 0) {
            this.umur = umur;
        }
    }

    // method tambahan untuk menampilkan info mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Umur: " + this.umur + " tahun");
    }
}

// Class utama yang memiliki method main (titik awal program java)

public class DemoMahasiswa {
    public static void main(String[] args) {
        // ====== Membuat Object Mahasiswa ======
        //Memanggil constructor: Mahasiswa(String nama, int umur)
        Mahasiswa mhs1 = new Mahasiswa("Budi", 20);
        Mahasiswa mhs2 = new Mahasiswa("Siti", 19);

        //====== Menggunakan Getter untuk membaca nilai ======
        System.out.println("Data awal:");
        System.out.println("Mahasiswa 1:" + mhs1.getNama() + ", Umur: " + mhs1.getUmur() + " tahun");
        System.out.println("Mahasiswa 2:" + mhs2.getNama() + ", Umur: " + mhs2.getUmur() + " tahun");

        //====== Menggunakan Setter untuk mengubah nilai ======
        mhs1.setNama("Ikbal henzem");
        mhs1.setUmur(21);

        mhs2.setNama("Riki Ganteng");
        mhs2.setUmur(20);

        //====== Menampilkan info mahasiswa setelah diubah ======
        System.out.println("\n Data setelah diubah:(menggunakan setter)");
        mhs1.tampilkanInfo();
        mhs2.tampilkanInfo();   
    }
}
