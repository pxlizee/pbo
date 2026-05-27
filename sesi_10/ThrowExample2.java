package sesi_10;

public class ThrowExample2 {
    public static void main(String[] args) {
        try
        {
            throw new java.lang.Exception("Here's my exception");
        }
        catch (java.lang.Exception e)
        {
            System.out.println("caught exception: ");
            System.out.println("e.getMessage() : " + e.getMessage());
            System.out.println("e.toString() : " + e.toString());
            System.out.println("e.printStackTrace() : ");
            e.printStackTrace(System.out);
        }
    }
    
}
