# Tugas Sesi 4 PBO - Sistem Transaksi Perbankan (Overloading & Overriding)

Repositori ini berisi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) Sesi IV mengenai implementasi **Method Overloading dan Method Overriding** dalam bahasa pemrograman Java.

- **Nama**  : Muhammad Alfarizzi Sutisna
- **NIM**   : 20240040043
- **Mata Kuliah** : Pemrograman Berorientasi Objek
- **Dosen** : Yulhan Wahyudin, M.Kom

## 📝 Deskripsi Program
Program ini adalah aplikasi konsol berbasis Java untuk simulasi transaksi perbankan. Program mengimplementasikan konsep **Object-Oriented Programming (OOP)** dengan fokus pada:
- **Method Overloading**: Beberapa method dengan nama sama tapi parameter berbeda
- **Method Overriding**: Method subclass yang menimpa method parent class

Program memungkinkan pengguna untuk melakukan transfer uang dengan berbagai opsi, menghitung biaya transfer otomatis, dan menampilkan informasi suku bunga sesuai jenis bank.

### 🗂️ Struktur File (Class)

1. `Bank.java` - Bertindak sebagai **Superclass** (Kelas Induk) yang berisi:
   - Method `transferUang()` dengan **3 versi overloading** (2, 3, dan 4 parameter)
   - Method `sukuBunga()` yang mencetak suku bunga standar 3%
   - Method `hitungBiayaTransfer()` untuk kalkulasi biaya transfer

2. `BankBNI.java` - Bertindak sebagai **Subclass** yang mewarisi (*extends*) kelas `Bank`. Kelas ini melakukan **overriding** pada:
   - `sukuBunga()` → Mengubah suku bunga menjadi 4%
   - `transferUang(int, String, String)` → Override dengan logika khusus BNI
   - `transferUang(int, String)` → Override untuk transfer sesama BNI

3. `BankBCA.java` - Bertindak sebagai **Subclass** yang mewarisi (*extends*) kelas `Bank`. Kelas ini melakukan **overriding** pada:
   - `sukuBunga()` → Mengubah suku bunga menjadi 4.5%
   - `transferUang(int, String, String)` → Override dengan logika khusus BCA
   - `transferUang(int, String)` → Override untuk transfer sesama BCA

4. `Main.java` - Bertindak sebagai kelas utama dengan menu interaktif menggunakan `Scanner`, menyediakan pilihan bank, jenis transfer, dan validasi input.

## ✨ Fitur Utama

### 🔁 Method Overloading (Compile-time Polymorphism)
| Method | Parameter | Fungsi |
|--------|-----------|--------|
| `transferUang(int, String)` | jumlah, rekeningTujuan | Transfer sesama bank |
| `transferUang(int, String, String)` | jumlah, rekeningTujuan, bankTujuan | Transfer antar bank |
| `transferUang(int, String, String, String)` | jumlah, rekeningTujuan, bankTujuan, berita | Transfer dengan keterangan |

### 🔄 Method Overriding (Runtime Polymorphism)
| Class | Method Override | Perilaku |
|-------|---------------|----------|
| `BankBNI` | `sukuBunga()` | Suku bunga 4% per tahun |
| `BankBNI` | `transferUang(int, String)` | Transfer sesama BNI (GRATIS) |
| `BankBCA` | `sukuBunga()` | Suku bunga 4.5% per tahun |
| `BankBCA` | `transferUang(int, String)` | Transfer sesama BCA (GRATIS) |

### 💰 Perhitungan Biaya Transfer (Bonus Challenge)
- **Sesama Bank**: Rp 0 (Gratis)
- **Antar Bank**: Rp 6.500

### 🖥️ Menu Interaktif
- Pilih Bank (BNI / BCA / Bank Umum)
- Transfer Sesama Bank
- Transfer Antar Bank (dengan biaya)
- Transfer dengan Berita/Keterangan
- Cek Informasi Suku Bunga
- Konfirmasi sebelum eksekusi transfer

## 🚀 Cara Menjalankan Program

```bash
# Compile semua file
javac Main.java Bank.java BankBNI.java BankBCA.java

# Jalankan program
java Main