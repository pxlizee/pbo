# Tugas Sesi 3 PBO - Program Entri Nilai Mahasiswa (Inheritance)

Repositori ini berisi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) Sesi III mengenai implementasi **Inheritance/Pewarisan** dalam bahasa pemrograman Java.

- **Nama**  : Muhammad Alfarizzi Sutisna
- **NIM**   : 20240040043
- **Mata Kuliah** : Pemrograman Berorientasi Objek
- **Dosen** : Yulhan Wahyudin, M.Kom

## 📝 Deskripsi Program
Program ini adalah aplikasi konsol berbasis Java untuk mengentri data nilai pemrograman Java mahasiswa. Program mengimplementasikan konsep **Object-Oriented Programming (OOP)** dengan membagi struktur kode menjadi beberapa *class* terpisah untuk mendemonstrasikan fungsi pewarisan (*Inheritance*). Program akan secara otomatis menentukan grade, status kelulusan, dan mencetak rekapitulasi statistik kelas.

### 🗂️ Struktur File (*Class*)
1. `Mahasiswa.java` - Bertindak sebagai **Superclass** (Kelas Induk) yang menyimpan atribut dasar mahasiswa yaitu `nim` dan `nama`.
2. `Penilaian.java` - Bertindak sebagai **Subclass** (Kelas Anak) yang mewarisi (*extends*) kelas `Mahasiswa`. Kelas ini menambahkan atribut `nilai`, `grade`, dan `statusLulus`, beserta logika percabangannya.
3. `Main.java` - Bertindak sebagai kelas utama untuk menjalankan *looping* input dari *user*, menyimpan data ke dalam `List`, dan mencetak *output* serta perhitungan rata-rata.

## ✨ Fitur Utama
- **Input Dinamis**: Menggunakan `Scanner` untuk menginput banyak data mahasiswa tanpa batasan (*looping*).
- **Validasi Nilai**: Mencegah input nilai di luar rentang 0-100 dengan memberikan notifikasi *"Input nilai anda salah"*.
- **Penentuan Grade Otomatis**:
  - `80 - 100` : Grade A (Lulus)
  - `70 - 79`  : Grade B (Lulus)
  - `60 - 69`  : Grade C (Lulus)
  - `50 - 59`  : Grade D (Tidak Lulus)
  - `< 50`     : Grade E (Tidak Lulus)
- **Rekapitulasi Statistik**: Menampilkan total mahasiswa, daftar nama mahasiswa yang lulus/tidak lulus, rincian peraih masing-masing grade, dan perhitungan rata-rata nilai kelas dengan rumusnya.
