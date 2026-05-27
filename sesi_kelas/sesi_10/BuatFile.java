package sesi_kelas.sesi_10;

import java.io.*;

public class BuatFile {
    public static void main(String[] args) {
        try {
            File f = new File("contoh.txt");
            if (f.createNewFile()) {
                System.out.println("File berhasil dibuat" + f.getName());
            } else {
                System.out.println("File sudah ada" + f.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            // e.printStackTrace();
        }
    }
} 