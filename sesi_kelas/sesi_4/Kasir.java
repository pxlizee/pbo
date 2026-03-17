package sesi_4;

class Kasir {
    public int hitungBayar(int harga, int qty) {
        return harga * qty;
    }

    public int hitungBayar(int harga, int qty, int diskonPersen) {
        int total = harga * qty;
        return (int) (total - (total * (diskonPersen / 100.0)));
    }
    }
