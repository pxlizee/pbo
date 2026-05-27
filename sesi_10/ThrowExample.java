package sesi_10;

public class ThrowExample {
    static void demo()
    {
        NullPointerException t;
        t = new NullPointerException("coba throw");
        throw t;
    }
    public static void main(String[] args) {
        try
        {
            demo();
            System.out.println("Selesai");
        }
        catch (NullPointerException e)
        {
            System.out.println("Ada pesan error: " + e.getMessage());
        }
    }
}
