package app.model;

public class User extends Person {
    private String role;

    public User(String nama, int id, String role) {
        super(nama, id);
        this.role = role;
    }
    @Override
    public void tampilkanPeran() {
        System.out.println("User Login Sebagai: " + role);
    }
}
