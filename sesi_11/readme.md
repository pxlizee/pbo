# Sistem Manajemen Data Siswa (CSV Java) - Sesi 11

Proyek ini adalah program berbasis Java untuk mengelola data siswa yang disimpan di dalam file format CSV (`students.csv`). Proyek ini mencakup fitur membaca data, menghitung jumlah baris, menambahkan data secara dinamis menggunakan input terminal, hingga menduplikasi (backup) file CSV.

---

## 📁 Struktur File Proyek

```text
pbo/
└── sesi_11/
    ├── CSVReader.java       # Membaca data & menghitung total baris (aman dari baris kosong)
    ├── CSVWriter.java       # Menambahkan data siswa baru via input Scanner (Terminal)
    ├── CSVCopy.java         # Menyalin (copy/backup) isi file CSV ke file baru
    └── students.csv         # File database utama tempat menyimpan data siswa