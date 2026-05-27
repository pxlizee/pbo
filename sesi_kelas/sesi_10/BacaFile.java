package sesi_kelas.sesi_10;
import java.io.*;
import java.util.Scanner;
public class BacaFile {
    public static void main(String[] args) {
        try {
            File f = new File("contoh.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                System.out.println(data);
        }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");
            // e.printStackTrace();
        }
    }
}
