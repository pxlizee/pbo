package app.model;

public class Pelanggan extends Person {
    private String noTelp;
    private String alamat;

    public Pelanggan(String nama, int id, String noTelp, String alamat) {
        super(nama, id);
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    @Override
    public void tampilkanPeran() {
        System.out.println("Pelanggan: " + nama + ", ID: " + id + ", No Telp: " + noTelp + ", Alamat: " + alamat);
    }
    public String getNoTelp() {
        return noTelp;
    }
    public String getAlamat() {
        return alamat;
    }
    
}
