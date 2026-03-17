package sesi_4;

public class DemoPolimorfisme {
    public static void main(String[] args) {
        System.out.println("=== DEMO OVERRIDING ===");
        System.out.println("Memanggil tampilInfo() dari masing masing objek:\n");

        Produk p1 = new Produk("Kaos polos", 50000);
        ProdukFisik pf1 = new ProdukFisik("Sepatu Lari", 250000, 1.5);
        ProdukDigital pd1 = new ProdukDigital("Microsoft 365", 50000, "1 tahun");

        System.out.println(p1.tampilInfo());
        System.out.println(pf1.tampilInfo());
        System.out.println(pd1.tampilInfo());

        System.out.println("\n=== DEMO OVERLOADING ===");
        System.out.println("Memanggil hitungBayar() dengan argumen berbeda:\n");

        Kasir kasir = new Kasir();
        int total1 = kasir.hitungBayar(50000, 2);
        int total2 = kasir.hitungBayar(50000, 2, 15);

        System.out.println("Total tanpa diskon: " + total1);
        System.out.println("Total dengan diskon 15%: " + total2);
    }
    
}
