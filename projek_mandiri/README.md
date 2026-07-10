# Projek Mandiri - Sistem Manajemen Kendaraan (Spring Boot)

Aplikasi ini adalah sistem inventarisasi dan manajemen data kendaraan berbasis web, yang dirancang menggunakan framework **Spring Boot** dengan visualisasi UI bertema modern **Glassmorphism** menggunakan **Thymeleaf** dan **CSS Vanilla**. 

Proyek ini telah dikontainerisasi penuh menggunakan **Docker** & **Docker Compose** agar mempermudah proses deployment lokal tanpa harus memasang JDK atau database server secara manual di mesin lokal.

---

## 🛠️ Arsitektur & Teknologi
- **Backend Framework**: Spring Boot 3.3.1 (Java 17)
- **Database**: MySQL 8.0
- **ORM & Data Layer**: Spring Data JPA & Hibernate
- **Frontend Template**: Thymeleaf
- **Styling**: Vanilla CSS (Modern Glassmorphic Dark UI)
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Maven

---

## 📂 Struktur Proyek
- `src/main/java/com/example/project/`
  - `ProjectApplication.java` (Entri utama aplikasi)
  - `controller/VehicleController.java` (Mengatur routing HTTP GET & POST)
  - `model/Entity.java` (Abstract class dasar yang memiliki atribut nama)
  - `model/Vehicle.java` (Subclass kendaraan yang mewarisi atribut nama dan memiliki tipe serta nomor polisi)
  - `repository/VehicleRepository.java` (Interface JPA repository untuk operasi database)
- `src/main/resources/`
  - `templates/index.html` (Template antarmuka pengguna berbasis HTML Thymeleaf)
  - `application.properties` (Konfigurasi lokal Spring Boot)
- `database.sql` (Skema awal pembuatan database MySQL)
- `Dockerfile` (Konfigurasi pembuatan image Docker aplikasi)
- `docker-compose.yml` (Konfigurasi orkestrasi container aplikasi dan database)

---

## 🚀 Cara Menjalankan Aplikasi

Ada dua opsi untuk menjalankan aplikasi ini di komputer Anda:

### Opsi A: Menggunakan Docker Compose (Direkomendasikan)
Opsi ini akan otomatis menyiapkan MySQL Database dan menjalankan aplikasi Spring Boot di port `8080`.

1. Pastikan Anda telah memasang **Docker Desktop** dan layanannya sedang berjalan.
2. Buka terminal dan masuk ke folder proyek:
   ```bash
   cd projek_mandiri
   ```
3. Bangun image dan jalankan container:
   ```bash
   docker-compose up --build
   ```
4. Buka browser dan kunjungi: [http://localhost:8080](http://localhost:8080)

---

### Opsi B: Menjalankan Secara Lokal (Maven)
Jika Anda ingin menjalankan tanpa Docker, pastikan Anda memiliki server MySQL lokal yang berjalan di port `3306`.

1. Buat database baru bernama `vehicle_db` di server MySQL lokal Anda dan pastikan username-nya `vehicle_user` dengan password `vehicle_password` (atau sesuaikan di `application.properties`).
2. Jalankan perintah SQL yang ada pada [database.sql](./database.sql) untuk membuat tabel `vehicle`.
3. Kompilasi dan jalankan aplikasi Spring Boot menggunakan Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Buka browser dan kunjungi: [http://localhost:8080](http://localhost:8080)

---

## 🌟 Fitur Utama
1. **Glassmorphism Dark UI**: Desain antarmuka modern yang futuristik, responsif, dan nyaman dipandang dengan efek bayangan dan blur kaca (*backdrop-filter*).
2. **Tambah Kendaraan**: Form interaktif dengan validasi input (Nama Kendaraan, Tipe Kendaraan, Nomor Polisi).
3. **Daftar Inventaris Kendaraan**: Menampilkan seluruh data kendaraan yang tersimpan di database dalam bentuk tabel interaktif.
4. **Desain OOP yang Bersih**: Menerapkan konsep pewarisan (*inheritance*) di mana kelas `Vehicle` merupakan turunan dari abstract class `Entity`.
