package sesi_7;

import java.util.ArrayList;
import java.util.ArrayDeque;

public class ContohCollection {
    public static void main(String[] args) {
        System.out.println("Contoh ArrayList");
        ArrayList<String> daftarNama = new ArrayList<>();
        daftarNama.add("Ikbal");
        daftarNama.add("Riki");
        daftarNama.add("Bayu");

        System.out.println("Isi ArrayList: " + daftarNama);
        System.out.println("Elemen indeks 1: " + daftarNama.get(1));

        System.out.println("\nContoh ArrayDeque");
        ArrayDeque<Integer> antreanAngka = new ArrayDeque<>();
        antreanAngka.addLast(10);
        antreanAngka.addLast(20);
        antreanAngka.addFirst(5);

        System.out.println("Isi ArrayDeque: " + antreanAngka);
        System.out.println(("Hapus elemen pertama: " + antreanAngka.pollFirst()));
        System.out.println("Isi ArrayDeque setelah penghapusan: " + antreanAngka);
        
    }
    
}
