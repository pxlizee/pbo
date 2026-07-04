# Aplikasi Biodata Mahasiswa

## Deskripsi
Aplikasi Biodata Mahasiswa adalah program Java berbasis GUI menggunakan Swing. Program ini memungkinkan pengguna untuk memasukkan dan menampilkan data biodata mahasiswa dengan antarmuka yang user-friendly.

## Fitur Utama
1. **Input Data**: Form untuk memasukkan data mahasiswa:
   - NIM (Nomor Induk Mahasiswa)
   - Nama
   - Program Studi

2. **Tombol Aksi**:
   - **Tampilkan**: Menampilkan data yang telah diinput dalam format output yang rapi
   - **Reset**: Menghapus semua input dan output

3. **Output**: Menampilkan data yang telah diinput dalam format terstruktur

## Struktur Program

### Komponen GUI
- **Input Panel**: Panel untuk memasukkan data mahasiswa
- **Button Panel**: Panel berisi tombol Tampilkan dan Reset
- **Output Panel**: Panel untuk menampilkan output data yang telah diproses

### Method Utama
- `tampilkanData()`: Memproses dan menampilkan data input ke area output
- `resetData()`: Membersihkan semua field input dan output
- `main()`: Method utama untuk menjalankan aplikasi

## Cara Menggunakan
1. **Jalankan Program**:
   ```
   javac AplikasiBiodataMahasiswa.java
   java AplikasiBiodataMahasiswa
   ```

2. **Input Data**:
   - Masukkan NIM di field NIM
   - Masukkan nama di field Nama
   - Masukkan program studi di field Program Studi

3. **Tampilkan Data**:
   - Klik tombol "Tampilkan" untuk menampilkan data
   - Data akan ditampilkan di area output dengan format yang rapi

4. **Reset**:
   - Klik tombol "Reset" untuk menghapus semua data input dan output

## Validasi
Program ini dilengkapi dengan validasi:
- Semua field wajib diisi sebelum menampilkan data
- Jika ada field yang kosong, akan muncul pesan peringatan

## Teknologi yang Digunakan
- **Bahasa**: Java
- **Framework GUI**: Swing
- **JDK**: Java 8 atau lebih tinggi

## Screenshot
Program ini memiliki antarmuka yang terdiri dari:
- Title Bar: "Aplikasi Biodata Mahasiswa"
- Input Section: Form untuk input data
- Button Section: Tombol Tampilkan dan Reset
- Output Section: Area untuk menampilkan hasil input

## Catatan
- Semua field input harus diisi untuk menampilkan data
- Data tidak disimpan dalam basis data (hanya ditampilkan di output area)
- Output akan di-overwrite ketika tombol Tampilkan diklik lagi dengan data baru
