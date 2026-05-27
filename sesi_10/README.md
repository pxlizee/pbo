# Tugas Sesi 10 PBO - Praktikum Exception Handling (Refactoring & Analisis Kode)

Repositori ini berisi pemenuhan tugas mata kuliah Pemrograman Berorientasi Objek (PBO) Sesi X yang berfokus pada penerapan mekanisasi **Exception Handling** di bahasa pemrograman Java. Seluruh kode program dalam proyek ini merupakan hasil perbaikan total (*refactoring*) dari kode percobaan pada modul PDF yang awalnya mengalami galat sintaksis (*syntax error*) maupun kesalahan logika struktur.

## 👤 Identitas Mahasiswa
- **Nama** : Muhammad Alfarizzi Sutisna
- **NIM** : 20240040043
- **Mata Kuliah** : Pemrograman Berorientasi Objek
- **Dosen** : Yulhan Wahyudin, M.Kom

---

## 📝 Deskripsi Program
Program pada Sesi 10 ini bertujuan untuk memahami bagaimana Java mengelola kesalahan saat *runtime* (*runtime errors*) menggunakan mekanisme `try-catch-finally`, kata kunci `throw` dan `throws`, serta pemahaman hierarki eksepsi. 

Modul praktikum asli (`10. Praktikum Exception Handling.pdf`) memiliki banyak kecacatan penulisan kode—mulai dari penggunaan tanda kurung kelas yang keliru, penempatan blok `try-catch` yang terbalik, hingga kode mati (*unreachable code*). Seluruh berkas `.java` di dalam repositori ini telah diperbaiki agar dapat dikompilasi secara sempurna dan berjalan dengan logis.

### 🗂️ Struktur Komponen Program (Package `sesi_10`)

Daftar berkas Java yang telah diperbaiki dan diorganisasikan ke dalam *package* `sesi_10`:

1. **`Exception2.java`**
   - Menangani `ArrayIndexOutOfBoundsException` dalam perulangan `while`. Perintah cetak dimasukkan ke dalam blok `try` agar kesalahan indeks dapat ditangkap secara tepat dan memicu reset indeks.
2. **`Exception3.java`**
   - Implementasi penanganan *runtime error* tunggal menggunakan blok `try-catch` standar dengan menangkap superclass `Exception`.
3. **`CobaException3.java`**
   - Pengembangan penanganan pembagian nol (`ArithmeticException`) menggunakan struktur *multiple catch blocks* bertingkat.
4. **`CobaException4.java`**
   - Menangani multi-eksepsi sekaligus (`ArrayIndexOutOfBoundsException` dan `ArithmeticException`) dengan penangkap akhir berupa kelas tertinggi `Throwable`.
5. **`Exception5.java`**
   - Mendemonstrasikan pelacakan informasi *error* melalui metode bawaan `.getMessage()` serta mencetak rekam jejak tumpukan fungsi lewat `e.printStackTrace(System.out)`.
6. **`ThrowExample.java`**
   - Simulasi pelemparan objek eksepsi secara manual dan sengaja menggunakan kata kunci `throw` pada objek `NullPointerException`.
7. **`ThrowExample2.java`**
   - Analisis perbandingan *output* penanda kesalahan berbasis metode bawaan objek eksepsi (`.getMessage()`, `.toString()`, dan `.printStackTrace()`).
8. **`Test3.java` (Class Utama)**
   - Penerapan kata kunci `throws IOException` pada penanda metode (*method signature*) dan penggabungannya dengan blok pembersihan `finally` yang selalu dieksekusi.
9. **`Propagate.java`**
   - Program pembalik string (*string reversal*) yang memanfaatkan propagasi pengecualian berbasis `RuntimeException` jika parameter string yang dikirim kosong.
10. **`RandomAccesRevisi.java`**
    - Simulasi penulisan dan pembacaan berkas biner secara sekuensial menggunakan `RandomAccessFile`.

---

## ✨ Fitur & Implementasi Konsep Exception

| Konsep Java Exception | Implementasi Nyata pada Kode Proyek |
|-----------------------|-------------------------------------|
| **Try-Catch Block**   | Mengisolasi kode rawan *error* di dalam `try` dan menangkap objek kesalahannya di dalam `catch`. |
| **Multiple Catch**    | Menyusun beberapa blok `catch` secara hierarkis (dari spesifik ke umum) untuk mengantisipasi berbagai jenis kegagalan. |
| **Finally Block**     | Blok penutup yang menjamin pengeksekusian kode penting (seperti cetak laporan akhir) baik saat terjadi error maupun tidak. |
| **Explicit Throw**    | Menginterupsi alur program secara sengaja dengan melemparkan objek kesalahan berbasis kondisi logika tertentu (`throw new Exception()`). |
| **Throws Declaration**| Mendelegasikan tanggung jawab penanganan eksepsi kepada metode pemanggil di atasnya. |
| **Try-with-Resources**| Manajemen penutupan *stream* berkas secara otomatis guna menghindari kebocoran memori (*resource leak*). |

---

## 🔧 Analisis & Catatan Perbaikan (Refactoring Logs)

Dibandingkan dengan kode mentah yang ada pada PDF praktikum, berikut adalah poin-poin perbaikan krusial yang telah diterapkan:

* **Koreksi Sintaksis Dasar (Syntax Errors):** Mengubah seluruh kesalahan penulisan deklarasi kelas di PDF yang menggunakan tanda kurung biasa `( )` menjadi kurung kurawal `{ }` standar Java.
* **Reposisi Alur Try-Catch (Percobaan 2):** Pada PDF, perintah `System.out.println(greeting[i])` diletakkan di luar `try` sehingga program langsung *crash* sebelum sempat ditangkap. Kode ini telah diperbaiki dengan memasukkan perintah cetak ke dalam ruang lingkup `try`.
* **Pembersihan Kode Mati / Unreachable Code (Percobaan 6):** Di dalam file `ThrowExample.java`, baris cetak di bawah perintah `throw t;` dihapus total karena menyebabkan kegagalan kompilasi akibat instruksi yang mustahil dijangkau oleh mesin eksekusi.
* **Perbaikan Total Algoritma Loop (Percobaan 9):** Memperbaiki penulisan perulangan `for` pada metode `reverse` di kelas `Propagate.java` yang rusak parah di PDF menjadi struktur indeks *decrementing* yang valid: `for (int i=s.length()-1 ; i>=0 ; --i)`.
* **Modernisasi Manajemen Berkas (Percobaan 10):** Pada file `RandomAccesRevisi.java`, penutupan berkas manual `.close()` yang rentan bocor memori diganti dengan fitur **Try-with-Resources** (`try (RandomAccessFile books = ...)`) sehingga penutupan koneksi file dijamin aman secara otomatis oleh JVM.

---

## 🚀 Cara Menjalankan Program

Seluruh berkas kode berada di bawah kendali *package* `sesi_10`. Untuk mengompilasi dan menjalankannya, pastikan posisi direktori terminal Anda berada sejajar (di luar) folder `sesi_10`.

```bash
# Contoh melakukan kompilasi file Propagate.java
javac sesi_10/Propagate.java

# Jalankan program hasil kompilasi
java sesi_10.Propagate