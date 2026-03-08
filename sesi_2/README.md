# 📚 Tugas Pemrograman Berorientasi Objek (OOP) - Java

**Nama:** Muhammad Alfarizzi  
**NIM:** 20240040043  
**Kelas/Organisasi:** TI24E 

---


### 1. Pengertian *Class* dan *Object*
* **Class**: Merupakan cetak biru (*blueprint*), rancangan, atau *template* untuk menciptakan sebuah objek. *Class* mendefinisikan atribut (data/variabel) dan *method* (fungsi/perilaku) apa saja yang nantinya akan dimiliki oleh objek tersebut.
* **Object**: Merupakan wujud nyata (*instansiasi*) dari sebuah *class*. Jika *class* adalah denah rumah, maka *object* adalah bangunan rumah fisiknya yang sudah dibangun dan memiliki data serta perilaku spesifik sesuai dengan yang didefinisikan pada *class*-nya.

### 2. Jenis-jenis *Method*
Dalam Java, *method* secara umum dibagi berdasarkan nilai kembalian dan fungsinya:
* **Method Void**: *Method* yang tidak mengembalikan nilai apa-apa setelah selesai dieksekusi (menggunakan *keyword* `void`).
* **Method Non-Void (Return Method)**: *Method* yang mengembalikan sebuah nilai setelah dieksekusi dan wajib menggunakan *keyword* `return` dengan tipe data tertentu.
* **Method Mutator (Setter)**: Berfungsi untuk mengatur, mengubah, atau memasukkan nilai ke dalam suatu atribut privat di dalam *class*.
* **Method Accessor (Getter)**: Berfungsi untuk mengambil atau membaca nilai dari suatu atribut privat di dalam *class*.
* **Constructor**: *Method* khusus yang memiliki nama sama dengan *class* dan otomatis dijalankan saat sebuah objek pertama kali dibuat.

---

## 3. 

Berdasarkan gambar potongan kode pada soal nomor 3, berikut adalah penjelasan dari masing-masing bagian sesuai dengan nomor urutnya:

| Nomor | Potongan Kode | Penjelasan |
|:---:|---|---|
| **1** | `public class Komputer` | **Nama Class**. Deklarasi pembuatan *class* utama dengan nama `Komputer`. |
| **2** | `String jenis_komputer;...` | **Atribut / Properties**. Variabel global di dalam *class* yang menyimpan keadaan/data dari objek. |
| **3** | `setDataKomputer(...)` | **Method Mutator (Setter)**. *Method void* untuk menerima parameter dan memasukkannya ke dalam atribut *class*. |
| **4** | `getJenis()` | **Method Accessor (Getter)**. *Method non-void* untuk mengembalikan nilai dari atribut `jenis_komputer`. |
| **5** | `getMerk()` | **Method Accessor (Getter)**. *Method non-void* untuk mengembalikan nilai dari atribut `merk`. |
| **6** | `new Komputer()` | **Instansiasi Objek**. Proses pembuatan wujud objek baru bernama `mykom` berdasarkan *class* `Komputer`. |
| **7** | `mykom.setDataKomputer(...)` | **Pemanggilan Method**. Memanggil *method setter* dan memberikan argumen data ke dalamnya. |
| **8** | `System.out.println(...)`| **Menampilkan Output**. Mencetak hasil ke layar konsol dengan memanggil *method getter* dari objek yang telah dibuat. |

---

## 4.Perbaikan Kode (Debugging) `HandPhone.java`

Pada soal nomor 4, terdapat beberapa kesalahan penulisan sintaks yang membuat program gagal di-*compile*. Berikut adalah perbaikan kodenya agar dapat berjalan dengan benar:

```java
public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan 1 & 2: Urutan modifier diubah menjadi public void dan penambahan keyword "this." untuk merujuk ke atribut class (mencegah variable shadowing).
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // Perbaikan 3: Menambahkan keyword "return" karena ini adalah method non-void.
    public String getJenisHP() {
        return jenis_hp;
    }

    // Perbaikan 4: Tipe data kembalian disesuaikan dengan atribut (int) dan menambahkan keyword "return".
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // Perbaikan 5: Urutan main method diperbaiki menjadi "public static void main".
    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        
        // Perbaikan 6: Memasukkan argumen nilai (literal) secara langsung saat memanggil method setter.
        hp.setDataHP("Android - Smartphone", 2023);
        
        // Perbaikan 7: Membungkus pemanggilan method getter dengan System.out.println agar hasilnya tercetak di layar.
        System.out.println("Jenis HP : " + hp.getJenisHP());
        System.out.println("Tahun    : " + hp.getTahunPembuatan());
    }
}
