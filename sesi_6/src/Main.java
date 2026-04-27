import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Laptop laptopPilihan = null;

        System.out.println("=== PILIH MERK LAPTOP ===");
        System.out.println("1. Lenovo");
        System.out.println("2. Toshiba");
        System.out.println("3. MacBook");
        System.out.print("Masukkan pilihan (1/2/3): ");
        String pilihMerk = scanner.nextLine();

        // Menentukan objek laptop berdasarkan pilihan user
        if (pilihMerk.equals("1")) {
            laptopPilihan = new Lenovo();
            System.out.println("Lenovo terpilih!");
        } else if (pilihMerk.equals("2")) {
            laptopPilihan = new Toshiba();
            System.out.println("Toshiba terpilih!");
        } else if (pilihMerk.equals("3")) {
            laptopPilihan = new MacBook();
            System.out.println("MacBook terpilih!");
        } else {
            System.out.println("Pilihan tidak valid! Memilih Lenovo sebagai default.");
            laptopPilihan = new Lenovo();
        }

        // Memasukkan laptop yang dipilih ke user
        LaptopUser andri = new LaptopUser(laptopPilihan);

        System.out.println("\n=== APLIKASI KONTROL LAPTOP ===");
        System.out.println("Ketik 'ON' untuk menyalakan laptop");
        System.out.println("Ketik 'OFF' untuk mematikan laptop");
        System.out.println("Ketik 'UP' untuk menambah volume");
        System.out.println("Ketik 'DOWN' untuk mengurangi volume");
        System.out.println("Ketik 'EXIT' untuk keluar dari program");

        // Perulangan menu kontrol
        while (true) {
            System.out.print("\nMasukkan perintah: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("ON")) {
                andri.turnOnLaptop();
            } else if (input.equals("OFF")) {
                andri.turnOffLaptop();
            } else if (input.equals("UP")) {
                andri.makeLaptopLouder();
            } else if (input.equals("DOWN")) {
                andri.makeLaptopSilence();
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai. Menutup aplikasi...");
                break;
            } else {
                System.out.println("Perintah tidak dikenali! Silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
}