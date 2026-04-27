# Tugas Sesi 6 PBO - Simulasi Kontrol Laptop (Package, Abstract & Interface)

Repositori ini berisi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) Sesi VI mengenai implementasi **Package, Abstract Class, dan Interface** dalam bahasa pemrograman Java.

- **Nama** : Muhammad Alfarizzi Sutisna
- **NIM** : 20240040043
- **Prodi** : Teknik Informatika
- **Kampus**: Universitas Nusaputra
- **Dosen** : Yulhan Wahyudin, M.Kom

## 📝 Deskripsi Program
Program ini adalah aplikasi konsol interaktif berbasis Java untuk mensimulasikan penggunaan berbagai merk laptop oleh seorang user. Program ini berfokus pada penerapan antarmuka (*Interface*) sebagai *blueprint* dan pemanfaatannya pada berbagai objek nyata (*Polymorphism*). Fokus utama pembelajaran kali ini meliputi:
- **Interface**: Pembuatan kerangka kerja dasar untuk objek laptop (ON, OFF, Volume UP/DOWN).
- **Polymorphism**: Satu *interface* dapat diimplementasikan dengan cara yang berbeda oleh class yang berbeda (Lenovo, MacBook, Toshiba).
- **Dependency Injection**: Memasukkan objek `Laptop` ke dalam class `LaptopUser` agar saling terhubung tanpa terikat kuat (*loosely coupled*).
- **Interactive Menu**: Penggunaan `Scanner` untuk memproses input dan mengontrol program secara dinamis.

## 🗂️ Struktur File (Class)

1. `Laptop.java` - Bertindak sebagai **Interface** (*Blueprint*):
   - Konstanta: `MAX_VOL = 100` dan `MIN_VOL = 0`.
   - Method kosong (*abstract*): `powerOn()`, `powerOff()`, `volumeUp()`, dan `volumeDown()`.

2. `Lenovo.java`, `MacBook.java`, `Toshiba.java` - Bertindak sebagai **Implementation Class**:
   - Mengimplementasikan antarmuka `Laptop` (`implements Laptop`).
   - Atribut: `volume` dan `is_power_on`.
   - **Overriding**: Menulis ulang logika dari method *interface* sesuai karakteristik masing-masing merk (misal: memberikan *output* cetakan merk yang berbeda saat dinyalakan).

3. `LaptopUser.java` - Bertindak sebagai **Pengguna (User)**:
   - Atribut: Objek `laptop` bertipe *Interface* `Laptop`.
   - Method: Menjalankan fungsi laptop seperti `turnOnLaptop()`, `turnOffLaptop()`, `makeLaptopLouder()`, dan `makeLaptopSilence()`.

4. `Main.java` - Kelas utama yang mengeksekusi program:
   - Menggunakan `Scanner` untuk membuat perulangan menu interaktif.
   - User dapat memilih merk laptop di awal dan memberikan perintah (`ON`, `OFF`, `UP`, `DOWN`) untuk mengontrol laptop secara real-time.

## ✨ Fitur Utama

### 🧬 Konsep OOP yang Diterapkan
| Konsep | Implementasi | Fungsi |
|--------|-----------|--------|
| **Interface** | `implements Laptop` | Mewajibkan class turunan untuk mendefinisikan metode operasional laptop. |
| **Polymorphism** | `Laptop macbook = new MacBook()` | Objek user bisa menggunakan laptop merk apa saja asalkan laptop tersebut mengimplementasikan interface `Laptop`. |
| **Encapsulation** | `private int volume` | Melindungi data level volume agar tidak bisa diubah langsung dari luar class, melainkan harus melalui method `volumeUp` / `volumeDown`. |

### 🛠️ Logika Bisnis
- **Validasi Daya**: Perintah tambah/kurang volume tidak akan merespons atau menampilkan peringatan jika status laptop masih dalam keadaan mati (`is_power_on = false`).
- **Limitasi Volume**: Terdapat batas maksimal volume (100) dan minimal volume (0) yang ditahan oleh sistem agar tidak melebihi kapasitas logika.
- **Menu Dinamis**: Loop `while(true)` menjaga program tetap berjalan untuk menerima perintah hingga pengguna mengetikkan `EXIT`.

## 🚀 Cara Menjalankan Program

```bash
# Compile semua file Java di dalam direktori
javac *.java

# Jalankan program utama
java Main