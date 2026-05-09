package sesi_7;

import java.util.ArrayList;
import java.util.List; 

// 1. INTERFACE
interface Perawatan {
    void lakukanServis();
}

// 2. ABSTRACT CLASS
abstract class Kendaraan {
    private String merk;
    private String tipe;

    public Kendaraan(String merk, String tipe) {
        this.merk = merk;
        this.tipe = tipe;
    }

    public String getMerk() { return merk; }
    public String getTipe() { return tipe; }

    abstract void tampilkanInfo();
}

// 3. SUBCLASS (INHERITANCE & POLYMORPHISM)
class Mobil extends Kendaraan implements Perawatan {
    private String jenisBahanBakar;

    public Mobil(String merk, String tipe, String jenisBahanBakar) {
        super(merk, tipe);
        this.jenisBahanBakar = jenisBahanBakar;
    }

    @Override 
    public void tampilkanInfo() {
    
        System.out.printf("Detail Mobil : %s %s (Bahan Bakar: %s)\n", getMerk(), getTipe(), jenisBahanBakar);
    }

    @Override
    public void lakukanServis() {
        System.out.println("Status       : Servis sedang berlangsung...");
    }
}

// 4. GENERIC CLASS DENGAN BOUNDED TYPE PARAMETER
class AntreanBengkel<T extends Kendaraan> {
    
    
    private List<T> daftarAntrean = new ArrayList<>();

    public void tambahAntrean(T kendaraan) {
        daftarAntrean.add(kendaraan);
    }

    public List<T> getDaftarAntrean() {
        return daftarAntrean;
    }
}

// MAIN CLASS
public class SistemBengkel {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("       SISTEM ANTREAN BENGKEL MOBIL      ");
        System.out.println("=========================================\n");

        AntreanBengkel<Mobil> antreanMobil = new AntreanBengkel<>();

        // Instansiasi langsung di dalam parameter (lebih ringkas dan hemat memori)
        antreanMobil.tambahAntrean(new Mobil("Toyota", "Avanza", "Bensin"));
        antreanMobil.tambahAntrean(new Mobil("Honda", "Civic", "Bensin"));
        antreanMobil.tambahAntrean(new Mobil("BYD", "Song", "Listrik"));

        // Looping untuk menampilkan output dengan nomor urut
        int nomorAntrean = 1;
        for (Kendaraan k : antreanMobil.getDaftarAntrean()) {
            System.out.println("Antrean ke-" + nomorAntrean);
            k.tampilkanInfo();
            
            if (k instanceof Perawatan) {
                ((Perawatan) k).lakukanServis();
            }
            System.out.println("-----------------------------------------");
            nomorAntrean++;
        }
    }
}