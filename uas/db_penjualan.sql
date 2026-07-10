-- ========================================================
-- DATABASE SETUP: db_penjualan (UAS PBO)
-- ========================================================
CREATE DATABASE IF NOT EXISTS db_penjualan;
USE db_penjualan;

-- 1. Tabel User (Autentikasi Login)
CREATE TABLE IF NOT EXISTS users (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

-- 2. Tabel Barang (CRUD Data Barang)
CREATE TABLE IF NOT EXISTS barang (
    id_barang INT AUTO_INCREMENT PRIMARY KEY,
    nama_barang VARCHAR(100) NOT NULL,
    harga INT NOT NULL,
    stok INT NOT NULL
);

-- 3. Tabel Pelanggan (CRUD Data Pelanggan)
CREATE TABLE IF NOT EXISTS pelanggan (
    id_pelanggan INT AUTO_INCREMENT PRIMARY KEY,
    nama_pelanggan VARCHAR(100) NOT NULL,
    no_telepon VARCHAR(20) NOT NULL,
    alamat TEXT NOT NULL
);

-- 4. Tabel Transaksi (Header Transaksi)
CREATE TABLE IF NOT EXISTS transaksi (
    id_transaksi INT AUTO_INCREMENT PRIMARY KEY,
    id_pelanggan INT NOT NULL,
    tgl_transaksi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan) ON DELETE CASCADE
);

-- 5. Tabel Detail Transaksi (Rincian Transaksi)
CREATE TABLE IF NOT EXISTS detail_transaksi (
    id_detail INT AUTO_INCREMENT PRIMARY KEY,
    id_transaksi INT NOT NULL,
    id_barang INT NOT NULL,
    qty INT NOT NULL,
    subtotal INT NOT NULL,
    FOREIGN KEY (id_transaksi) REFERENCES transaksi(id_transaksi) ON DELETE CASCADE,
    FOREIGN KEY (id_barang) REFERENCES barang(id_barang) ON DELETE CASCADE
);

-- ========================================================
-- STORED PROCEDURE, VIEW, DAN TRIGGER
-- ========================================================

-- 6. Stored Procedure: sp_buat_transaksi
-- Digunakan untuk mendaftarkan transaksi baru dan mengembalikan ID Nota (LAST_INSERT_ID)
DELIMITER $$
CREATE PROCEDURE IF NOT EXISTS sp_buat_transaksi(
    IN p_id_pelanggan INT,
    OUT p_id_transaksi INT
)
BEGIN
    INSERT INTO transaksi(id_pelanggan) VALUES(p_id_pelanggan);
    SET p_id_transaksi = LAST_INSERT_ID();
END $$
DELIMITER ;

-- 7. Database View: v_laporan_penjualan
-- Menggabungkan data transaksi untuk mempermudah pelaporan keuangan penjualan
CREATE OR REPLACE VIEW v_laporan_penjualan AS
SELECT 
    t.id_transaksi,
    t.tgl_transaksi,
    p.nama_pelanggan,
    b.nama_barang,
    d.qty,
    d.subtotal
FROM detail_transaksi d
JOIN transaksi t ON d.id_transaksi = t.id_transaksi
JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan
JOIN barang b ON d.id_barang = b.id_barang;

-- 8. Database Trigger: trg_kurangi_stok
-- Mengurangi stok barang secara otomatis di tabel 'barang' ketika ada transaksi baru di 'detail_transaksi'
DELIMITER $$
CREATE TRIGGER trg_kurangi_stok
AFTER INSERT ON detail_transaksi
FOR EACH ROW
BEGIN
    UPDATE barang 
    SET stok = stok - NEW.qty 
    WHERE id_barang = NEW.id_barang;
END $$
DELIMITER ;

-- ========================================================
-- DATA AWAL (SEED DATA)
-- ========================================================

-- Akun admin bawaan (Username: admin, Password: admin)
INSERT INTO users (username, password) VALUES 
('admin', 'admin')
ON DUPLICATE KEY UPDATE username=username;

-- Data Pelanggan Default (ID 1 penting untuk inisialisasi default Form Transaksi)
INSERT INTO pelanggan (id_pelanggan, nama_pelanggan, no_telepon, alamat) VALUES 
(1, 'Pelanggan Umum', '081234567890', 'Jl. Jenderal Sudirman No. 1, Jakarta')
ON DUPLICATE KEY UPDATE nama_pelanggan=nama_pelanggan;

INSERT INTO pelanggan (nama_pelanggan, no_telepon, alamat) VALUES 
('Budi Santoso', '085678901234', 'Jl. Dago No. 100, Bandung'),
('Siti Aminah', '087890123456', 'Jl. Malioboro No. 50, Yogyakarta')
ON DUPLICATE KEY UPDATE nama_pelanggan=nama_pelanggan;

-- Data Barang Awal
INSERT INTO barang (nama_barang, harga, stok) VALUES 
('Roti Tawar Serbaguna', 15000, 50),
('Biskuit Malkist Keju', 8000, 100),
('Kopi Kapal Api Renceng', 15000, 30),
('Susu UHT Cokelat 1L', 18000, 40),
('Sabun Mandi Cair 450ml', 25000, 25)
ON DUPLICATE KEY UPDATE nama_barang=nama_barang;
