# Tugas Sesi 14 PBO - Sistem Manajemen Barang (JDBC & Database Objects)

Aplikasi ini adalah program console Java yang mendemonstrasikan integrasi antara bahasa pemrograman Java dengan database relasional MySQL menggunakan JDBC (Java Database Connectivity). 

Aplikasi ini secara khusus mempraktikkan konsep database tingkat lanjut (Database Objects) seperti:
- **Stored Procedure** untuk menambahkan data.
- **Stored Function** untuk melakukan kalkulasi matematis di sisi database.
- **Database View** untuk memproyeksikan data yang sudah dihitung.
- **Database Trigger** untuk melakukan pencatatan log aktivitas secara otomatis.

---

## 🛠️ Persyaratan Sistem
Sebelum menjalankan program ini, pastikan Anda telah memasang:
1. **Java Development Kit (JDK)** versi 17 atau yang lebih baru.
2. **MySQL Server** (bisa melalui XAMPP, Laragon, Docker, atau instalasi mandiri).
3. **JDBC Driver** (`mysqlconnector.jar`) yang sudah diletakkan di dalam folder `lib/`.

---

## 💾 Pengaturan Database
1. Aktifkan MySQL server Anda.
2. Buat database baru bernama `toko_retail` atau jalankan seluruh skrip SQL yang ada pada berkas [toko_retail.sql](./toko_retail.sql):
   ```bash
   mysql -u root -p < toko_retail.sql
   ```
3. Skrip tersebut akan otomatis membuat:
   - Tabel `tbl_barang` dan `log_barang`.
   - Stored Procedure `tambah_barang`.
   - Stored Function `total_asset`.
   - Database View `v_barang`.
   - Triggers `trg_after_insert_barang`, `trg_after_update_barang`, dan `trg_after_delete_barang`.
   - Data barang sampel (seed data) awal.

---

## 🚀 Cara Menjalankan Aplikasi
1. Buka Terminal/Command Prompt Anda.
2. Masuk ke direktori folder ini:
   ```bash
   cd sesi_14
   ```
3. Kompilasi program Java dengan menyertakan classpath driver JDBC:
   ```bash
   javac -cp ".;lib/mysqlconnector.jar" SistemStokBarang.java
   # Untuk sistem macOS/Linux, gunakan pemisah titik dua (:) sebagai pengganti titik koma (;):
   javac -cp ".:lib/mysqlconnector.jar" SistemStokBarang.java
   ```
4. Jalankan aplikasi:
   ```bash
   java -cp ".;lib/mysqlconnector.jar" SistemStokBarang
   # Untuk macOS/Linux:
   java -cp ".:lib/mysqlconnector.jar" SistemStokBarang
   ```

---

## 📋 Fitur Utama Aplikasi
1. **Tambah Barang (Procedure)**: Menambahkan barang baru dengan memanggil Stored Procedure `tambah_barang` di MySQL.
2. **Tampilkan Semua Barang (Select)**: Membaca daftar barang secara langsung dari tabel `tbl_barang`.
3. **Cari Barang**: Menemukan nama barang menggunakan query `LIKE` terparameter.
4. **Update Barang**: Mengubah nama, harga, dan stok barang berdasarkan kode barang.
5. **Hapus Barang**: Menghapus data barang berdasarkan kode barang.
6. **Tampilkan Semua Barang (View)**: Menampilkan nama barang dan total nilai aset barang (`harga * stok`) dengan membaca Database View `v_barang`.
7. **Hitung Total Aset (Function)**: Menghitung akumulasi nilai seluruh aset toko dengan memanggil Stored Function `total_asset()`.
8. **Lihat Log Trigger (tbl_log)**: Membaca riwayat aksi penambahan, perubahan, dan penghapusan data barang yang dicatat otomatis oleh database trigger ke dalam tabel `log_barang`.
