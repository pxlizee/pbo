public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan 1 & 2: Urutan modifier diubah menjadi public void dan penambahan keyword "this." untuk merujuk ke atribut class (mencegah variable shadowing).
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // Perbaikan 3: Menambahkan keyword "return" karena ini adalah method non-void.
    public String getJenisHP() {
        return jenis_hp;
    }

    // Perbaikan 4: Tipe data kembalian disesuaikan dengan atribut (int) dan menambahkan keyword "return".
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // Perbaikan 5: Urutan main method diperbaiki menjadi "public static void main".
    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        
        // Perbaikan 6: Memasukkan argumen nilai (literal) secara langsung saat memanggil method setter.
        hp.setDataHP("Android - Smartphone", 2023);
        
        // Perbaikan 7: Membungkus pemanggilan method getter dengan System.out.println agar hasilnya tercetak di layar.
        System.out.println("Jenis HP : " + hp.getJenisHP());
        System.out.println("Tahun    : " + hp.getTahunPembuatan());
    }
}