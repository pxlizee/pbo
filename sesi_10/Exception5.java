package sesi_10;

public class Exception5 {
    public static void main(String[] args) {
        int bil =10;
        try 
        {
            System.out.println(bil/10);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Pesan Error :  ");
            System.out.println(e.getMessage());
            System.out.println("Info stack trace");
            e.printStackTrace(System.out);
        }
            catch (Throwable e)
            {
                System.out.println("Ini menghandle error yang terjadi");
            }
    }
}
