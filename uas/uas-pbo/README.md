# Ujian Akhir Semester (UAS) PBO - Aplikasi Penjualan Desktop GUI

Aplikasi ini adalah sistem kasir dan penjualan ritel berbasis desktop yang dirancang menggunakan **Java Swing GUI** dan diintegrasikan dengan database **MySQL** melalui **JDBC**. 

Aplikasi ini mendemonstrasikan implementasi fitur CRUD (*Create, Read, Update, Delete*), pencarian interaktif, serta pemanfaatan objek database canggih seperti **Stored Procedure**, **Views**, dan **Triggers** di sisi MySQL untuk otomatisasi bisnis (seperti pemotongan stok otomatis saat transaksi checkout).

---

## 📋 Fitur Utama Aplikasi
1. **Form Login**: Autentikasi aman membaca data dari tabel `users`.
2. **Dashboard Menu Utama**: Panel navigasi utama aplikasi untuk mengakses modul lainnya.
3. **CRUD Data Barang & Pencarian**: Manajemen data inventaris barang toko beserta pencarian real-time berbasis ketukan tombol (*KeyReleased Event*).
4. **CRUD Data Pelanggan & Pencarian**: Manajemen biodata pelanggan lengkap dengan nomor telepon dan alamat.
5. **Form Transaksi Kasir**: Modul pemrosesan transaksi belanja yang memanggil Stored Procedure `sp_buat_transaksi` dan memanfaatkan database trigger untuk mengurangi stok barang secara otomatis.
6. **Laporan Penjualan (View)**: Menampilkan histori dan total penjualan secara tabular dengan membaca MySQL View `v_laporan_penjualan`.

---

## 🛠️ Persyaratan Sistem
- **Java Development Kit (JDK)** versi 8 atau versi terbaru.
- **MySQL Database Server** (XAMPP / Laragon / Docker).
- **Driver Connector JDBC MySQL** (`mysql-connector-j-9.7.0.jar` sudah disediakan di dalam folder `lib/`).

---

## 💾 Pengaturan Database
1. Pastikan server MySQL Anda berjalan di port default (`3306`).
2. Masuk ke MySQL dan jalankan berkas SQL database yang telah disediakan pada folder parent [db_penjualan.sql](../db_penjualan.sql) untuk membentuk skema database:
   ```bash
   mysql -u root -p < ../db_penjualan.sql
   ```
3. Konfigurasi kredensial koneksi database terdapat pada berkas [KoneksiDB.java](./src/app/koneksi/KoneksiDB.java). Nilai defaultnya adalah:
   - **Database URL**: `jdbc:mysql://localhost:3306/db_penjualan`
   - **Username**: `root`
   - **Password**: `root` *(Ubah variabel `password` di kelas ini jika password MySQL Anda kosong atau berbeda)*.

---

## 🚀 Cara Menjalankan Aplikasi

### Opsi A: Menjalankan via Visual Studio Code (Direkomendasikan)
1. Buka folder `uas-pbo` di VS Code.
2. Pastikan ekstensi **Extension Pack for Java** sudah terpasang.
3. Buka berkas [Main.java](./src/app/main/Main.java).
4. Klik tombol **Run** atau tekan `F5` untuk memulai aplikasi.
5. Gunakan akun berikut untuk masuk:
   - **Username**: `admin`
   - **Password**: `admin`

---

### Opsi B: Menjalankan via Terminal / Command Line
1. Buka terminal dan arahkan ke direktori `uas/uas-pbo`:
   ```bash
   cd uas/uas-pbo
   ```
2. Kompilasi semua berkas java ke folder `bin` dengan menyertakan classpath library MySQL Connector:
   ```bash
   javac -d bin -cp "lib/mysql-connector-j-9.7.0.jar" src/App.java src/app/koneksi/*.java src/app/model/*.java src/app/gui/*.java src/app/main/*.java
   ```
3. Jalankan aplikasi:
   ```bash
   java -cp "bin;lib/mysql-connector-j-9.7.0.jar" app.main.Main
   # Untuk macOS/Linux:
   java -cp "bin:lib/mysql-connector-j-9.7.0.jar" app.main.Main
   ```

---

## 📂 Struktur Direktori Proyek
- `lib/`: Berisi driver JDBC (`mysql-connector-j-9.7.0.jar`).
- `src/`: Berisi seluruh kode sumber Java:
  - `app/koneksi/KoneksiDB.java`: Kelas helper koneksi database MySQL.
  - `app/model/`: Representasi objek model data OOP (`Person`, `User`, `Pelanggan`, `Barang`).
  - `app/gui/`: Berkas rancangan form Swing GUI.
  - `app/main/Main.java`: Kelas titik masuk utama aplikasi untuk memanggil form Login.
- `bin/`: Folder output kompilasi biner (`.class`).
