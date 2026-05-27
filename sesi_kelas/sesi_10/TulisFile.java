package sesi_kelas.sesi_10;

import java.io.*;

public class TulisFile {
    public static void main(String[] args) {
        try {
            FileWriter f = new FileWriter("contoh.txt");
            f.write("ikbal hensem,riki ganz");
            f.close();
            System.out.println("Berhasil menulis ke file");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file.");
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
}
}