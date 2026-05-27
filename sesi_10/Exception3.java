package sesi_10;

public class Exception3 {
    public static void main(String[] args) {
    int bil = 10;
    try {
        System.out.println(bil/10);
    }
    catch (java.lang.Exception e) 
    {
        System.out.println("Ini menghandle error yang terjadi");
    }
    }
}

