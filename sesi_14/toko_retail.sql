-- ========================================================
-- DATABASE SETUP: toko_retail
-- ========================================================
CREATE DATABASE IF NOT EXISTS toko_retail;
USE toko_retail;

-- 1. Tabel Utama: tbl_barang
CREATE TABLE IF NOT EXISTS tbl_barang (
    kode_barang VARCHAR(10) PRIMARY KEY,
    nama_barang VARCHAR(100) NOT NULL,
    harga_barang INT NOT NULL,
    stok_barang INT NOT NULL
);

-- 2. Tabel Log: log_barang (untuk Trigger)
CREATE TABLE IF NOT EXISTS log_barang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aksi VARCHAR(20) NOT NULL,
    kode_barang VARCHAR(10) NOT NULL,
    nama_barang VARCHAR(100) NOT NULL,
    waktu TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Stored Procedure: tambah_barang
DELIMITER $$
CREATE PROCEDURE IF NOT EXISTS tambah_barang(
    IN p_kode VARCHAR(10),
    IN p_nama VARCHAR(100),
    IN p_harga INT,
    IN p_stok INT
)
BEGIN
    INSERT INTO tbl_barang (kode_barang, nama_barang, harga_barang, stok_barang)
    VALUES (p_kode, p_nama, p_harga, p_stok);
END $$
DELIMITER ;

-- 4. Stored Function: total_asset
DELIMITER $$
CREATE FUNCTION IF NOT EXISTS total_asset()
RETURNS BIGINT
DETERMINISTIC
BEGIN
    DECLARE total BIGINT;
    SELECT SUM(harga_barang * stok_barang) INTO total FROM tbl_barang;
    RETURN IFNULL(total, 0);
END $$
DELIMITER ;

-- 5. Database View: v_barang
CREATE OR REPLACE VIEW v_barang AS
SELECT 
    kode_barang,
    nama_barang,
    (harga_barang * stok_barang) AS total_nilai
FROM 
    tbl_barang;

-- 6. Database Triggers (Logging CRUD tbl_barang)
-- Trigger Setelah Insert
DELIMITER $$
CREATE TRIGGER trg_after_insert_barang
AFTER INSERT ON tbl_barang
FOR EACH ROW
BEGIN
    INSERT INTO log_barang (aksi, kode_barang, nama_barang, waktu)
    VALUES ('INSERT', NEW.kode_barang, NEW.nama_barang, NOW());
END $$
DELIMITER ;

-- Trigger Setelah Update
DELIMITER $$
CREATE TRIGGER trg_after_update_barang
AFTER UPDATE ON tbl_barang
FOR EACH ROW
BEGIN
    INSERT INTO log_barang (aksi, kode_barang, nama_barang, waktu)
    VALUES ('UPDATE', NEW.kode_barang, NEW.nama_barang, NOW());
END $$
DELIMITER ;

-- Trigger Setelah Delete
DELIMITER $$
CREATE TRIGGER trg_after_delete_barang
AFTER DELETE ON tbl_barang
FOR EACH ROW
BEGIN
    INSERT INTO log_barang (aksi, kode_barang, nama_barang, waktu)
    VALUES ('DELETE', OLD.kode_barang, OLD.nama_barang, NOW());
END $$
DELIMITER ;

-- ========================================================
-- SEED DATA (DATA AWAL)
-- ========================================================
INSERT INTO tbl_barang (kode_barang, nama_barang, harga_barang, stok_barang) VALUES
('B001', 'Kopi Susu Instan', 3500, 120),
('B002', 'Biskuit Cokelat', 7500, 85),
('B003', 'Mie Instan Goreng', 3000, 200),
('B004', 'Air Mineral 600ml', 4000, 150),
('B005', 'Teh Kotak Melati', 5500, 90)
ON DUPLICATE KEY UPDATE 
    nama_barang=VALUES(nama_barang), 
    harga_barang=VALUES(harga_barang), 
    stok_barang=VALUES(stok_barang);
