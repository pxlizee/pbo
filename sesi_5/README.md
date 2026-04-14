# Tugas Sesi 5 PBO - Sistem Manajemen Akademik (Inheritance & Polymorphism)

Repositori ini berisi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) Sesi V mengenai implementasi **Inheritance (Pewarisan), Encapsulation (Pengkapsulan), dan Method Overriding** dalam bahasa pemrograman Java.

- **Nama** : [Isi Nama Lengkapmu]
- **NIM** : [Isi NIM Kamu]
- **Prodi** : Teknik Informatika
- **Kampus**: Universitas Nusaputra
- **Dosen** : Yulhan Wahyudin, M.Kom

## 📝 Deskripsi Program
Program ini adalah aplikasi konsol berbasis Java untuk mensimulasikan manajemen data akademik sederhana. Program ini menerapkan struktur hierarki antara individu di lingkungan kampus menggunakan prinsip **Object-Oriented Programming (OOP)** dengan fokus pada:
- **Inheritance**: Mewariskan atribut dan method dari kelas induk ke kelas turunan.
- **Method Overriding**: Mengubah perilaku method `toString()` di setiap subclass.
- **Encapsulation**: Mengamankan data dengan modifier `private` dan `final`.
- **Best Practices**: Penggunaan *try-with-resources* untuk penanganan input.

## 🗂️ Struktur File (Class)

1. `Person.java` - Bertindak sebagai **Superclass** (Kelas Induk) yang menyimpan data umum:
   - Atribut: `name` (final) dan `address`.
   - Method: Getter untuk nama/alamat, Setter untuk alamat, dan `toString()`.

2. `Student.java` - Bertindak sebagai **Subclass** yang mewarisi kelas `Person`:
   - Mengelola array `courses` dan `grades` (maksimal 30 data).
   - Method: `addCourseGrade()`, `printGrades()`, dan `getAverageGrade()`.
   - **Overriding**: `toString()` ditambahkan awalan "Student:".

3. `Teacher.java` - Bertindak sebagai **Subclass** yang mewarisi kelas `Person`:
   - Mengelola array `courses` yang diampu (maksimal 10 data).
   - Method: `addCourse()` (dengan validasi duplikat) dan `removeCourse()`.
   - **Overriding**: `toString()` ditambahkan awalan "Teacher:".

4. `Main.java` - Kelas utama yang menjalankan simulasi interaktif menggunakan `Scanner`, memproses input data mahasiswa, dosen, hingga manipulasi mata kuliah.

## ✨ Fitur Utama

### 🧬 Konsep OOP yang Diterapkan
| Konsep | Implementasi | Fungsi |
|--------|-----------|--------|
| **Inheritance** | `extends Person` | `Student` dan `Teacher` mendapatkan atribut `name` & `address` secara otomatis. |
| **Overriding** | `toString()` | Setiap class memberikan representasi teks yang berbeda sesuai identitasnya. |
| **Encapsulation** | `private final` | Melindungi referensi array agar tidak dapat diganti secara tidak sengaja. |

### 🛠️ Logika Bisnis
- **Validasi Mata Kuliah (Teacher)**: Method `addCourse` akan mengembalikan nilai `false` jika mata kuliah sudah terdaftar (mencegah duplikasi).
- **Penghapusan Dinamis (Teacher)**: Method `removeCourse` mampu menghapus mata kuliah dan menggeser posisi array agar tetap rapi.
- **Kalkulasi Nilai (Student)**: Menghitung rata-rata nilai (*GPA*) secara otomatis berdasarkan jumlah kursus yang diambil.

## 🚀 Cara Menjalankan Program

```bash
# Compile semua file (Person, Student, Teacher, Main)
javac *.java

# Jalankan program utama
java Main