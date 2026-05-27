package sesi_kelas.sesi_10;

import java.io.*;

public class InfoFile {
    public static void main(String[] args) {
        File f = new File("contoh.txt");
        if (f.exists()) {
            System.out.println("Nama file: " + f.getName());
            System.out.println("Ukuran file: " + f.length() + " bytes");
            System.out.println("Path file: " + f.getAbsolutePath());
            System.out.println("Baca file: " + f.canRead());
            System.out.println("Tulis file: " + f.canWrite());
            System.out.println("Eksekusi file: " + f.canExecute());
        } else {
            System.out.println("File tidak ditemukan.");
        }
    }
    
}
