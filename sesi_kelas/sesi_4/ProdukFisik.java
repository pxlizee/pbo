package sesi_4;
class ProdukFisik extends Produk {
    protected double beratkg;

    public ProdukFisik(String nama, int harga, double berat) {
        super(nama, harga);
        this.beratkg = berat;
    }

    @Override
    public String tampilInfo() {
        return "[FISIK] " + nama + " - Harga: " + harga + ", Berat: " + beratkg + " kg";
    }
}