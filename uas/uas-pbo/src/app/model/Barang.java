package app.model;

public class Barang {
    private int idBarang;
    private String namaBarang;
    private int harga;
    private int stok;

    public Barang(int idBarang, String namaBarang, int harga, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }
    public int getIdBarang() {
        return idBarang;
    }
    public String getNamaBarang() {
        return namaBarang;
    }
    public int getHarga() {
        return harga;
    }
    public int getStok() {
        return stok;
    }
}
