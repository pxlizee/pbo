package app.model;

public class Person {
    protected String nama;
    protected int id;
    
    public Person(String nama, int id) {
        this.nama = nama;
        this.id = id;
    }
    public void tampilkanPeran() {
        System.out.println("Peran Sistem umum");
    }
    public int getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
}
