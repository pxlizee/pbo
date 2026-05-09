package sesi_7;

class Mahasiswa<T, U, V> {
    private T nim;
    private U nama;
    private V kelas;

    public void setNim(T nim) {this.nim = nim;}
    public void setNama(U nama) {this.nama = nama;}
    public void setKelas(V kelas) {this.kelas = kelas;}

    public T getNim() {return nim;}
    public U getNama() {return nama;}
    public V getKelas() {return kelas;}
}


public class MahasiswaKu {
    
    public static void main(String[] args) {
        Mahasiswa <String, String, Integer> m = new Mahasiswa<>();
        m.setNim("1102020");
        m.setNama("Budi");
        m.setKelas(21);

        System.out.println(m.getNim());
        System.out.println(m.getNama());
        System.out.println(m.getKelas());

    }
}