// 1. Nama Class
public class Komputer {
    
    // 2. Atribut / Properties
    String jenis_komputer;
    private String merk;

    // 3. Method Mutator (Setter)
    public void setDataKomputer(String jenis, String merk) {
        jenis_komputer = jenis;
        this.merk = merk;
    }

    // 4. Method Accessor (Getter) untuk Jenis
    public String getJenis() {
        return jenis_komputer;
    }

    // 5. Method Accessor (Getter) untuk Merk
    public String getMerk() {
        return merk;
    }

    public static void main(String[] args) {
        // 6. Instansiasi Objek
        Komputer mykom = new Komputer();
        
        // 7. Pemanggilan Method
        mykom.setDataKomputer("LAPTOP", "MACBOOK");
        
        // 8. Menampilkan Output
        System.out.println(mykom.getJenis());
        System.out.println(mykom.getMerk());
    }
}