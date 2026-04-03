package sesi_5;

class Tabungan {
    private double saldo;

    void tambah(double jumlah) {
        saldo += jumlah;
    }

    void ambil(double jumlah) {
        saldo -= jumlah;    
    }

    void infoSaldo() {
        System.out.println("Saldo saat ini: " + saldo);
    }
}

public class Contoh {
    public static void main(String[] args) {
        Tabungan sehan = new Tabungan();
        //sehan.saldo = 1000000; 
        sehan.tambah(500000); 
        sehan.ambil(200000);
        sehan.infoSaldo();
    }
}

