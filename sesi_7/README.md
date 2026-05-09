# Tugas Sesi 7 PBO - Sistem Antrean Bengkel (Konsep OOP Lengkap, Generic & Collection)

Repositori ini berisi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) Sesi VII mengenai implementasi **Konsep OOP Lengkap beserta Generic & Collection** dalam bahasa pemrograman Java.

- **Nama** : Muhammad Alfarizzi Sutisna
- **NIM** : 20240040043
- **Mata Kuliah** : Pemrograman Berorientasi Objek
- **Dosen** : Yulhan Wahyudin, M.Kom

## 📝 Deskripsi Program
Program ini adalah aplikasi konsol berbasis Java untuk simulasi pencatatan antrean servis bengkel kendaraan. Program ini secara komprehensif mengimplementasikan seluruh konsep **Object-Oriented Programming (OOP)** yang ditugaskan pada sesi 7, yaitu:
- **Class & Object**
- **Encapsulation**
- **Inheritance & Polymorphism**
- **Package, Abstract Class, & Interface**
- **Generic Class & Collection (ArrayList)**

### 🗂️ Struktur Komponen Program (Package `sesi_7`)

1. `Perawatan` (Interface)
   - Mendefinisikan kontrak method `lakukanServis()` yang wajib diimplementasikan oleh kendaraan yang memerlukan servis khusus.

2. `Kendaraan` (Abstract Class)
   - Bertindak sebagai **Superclass** (Kelas Induk).
   - Menerapkan **Encapsulation** pada atribut `merk` dan `tipe`.
   - Memiliki abstract method `tampilkanInfo()`.

3. `Mobil` (Class)
   - Bertindak sebagai **Subclass** yang mewarisi (*extends*) `Kendaraan` dan mengimplementasikan (*implements*) `Perawatan`.
   - Menerapkan **Polimorfisme** dengan melakukan *override* pada method `tampilkanInfo()` dan `lakukanServis()`.

4. `AntreanBengkel<T>` (Generic Class)
   - Kelas **Generic** dengan *Bounded Type Parameter* (`<T extends Kendaraan>`) untuk memastikan hanya objek kendaraan yang bisa masuk antrean.
   - Memanfaatkan **Collection** (`ArrayList` via interface `List`) untuk menampung data secara dinamis.

5. `SistemBengkel` (Main Class)
   - Kelas utama tempat instansiasi objek dan eksekusi program.
   - Melakukan perulangan data antrean dan menampilkan status servis menggunakan validasi *casting* antarmuka.

## ✨ Fitur & Implementasi Konsep

| Konsep OOP | Implementasi pada Kode |
|------------|------------------------|
| **Package** | `package sesi_7;` pada baris pertama kode. |
| **Interface** | `interface Perawatan { void lakukanServis(); }` |
| **Abstract Class** | `abstract class Kendaraan { ... }` |
| **Encapsulation** | Penggunaan `private` pada atribut dengan metode pengakses Getter (`getMerk()`, `getTipe()`). |
| **Inheritance** | `class Mobil extends Kendaraan` |
| **Polymorphism** | Penulisan ulang (`@Override`) metode `tampilkanInfo()` pada kelas anak. |
| **Generic** | `class AntreanBengkel<T extends Kendaraan>` untuk tipe data penampung yang aman dan terikat. |
| **Collection** | Penggunaan `List<T> daftarAntrean = new ArrayList<>();` |

## 🚀 Cara Menjalankan Program

Karena program ini menggunakan *package* `sesi_7`, pastikan Anda berada di direktori yang sejajar dengan folder `sesi_7` saat melakukan kompilasi.

```bash
# Compile file java
javac sesi_7/SistemBengkel.java

# Jalankan program
java sesi_7.SistemBengkel