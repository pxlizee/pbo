package sesi_10;

public class Propagate {
    public static void main(String[] args) {
        try
        {
            System.out.println(reverse("This is a string"));
        }
        catch (RuntimeException e)
        {
            System.out.println("the string was blank");
        }
        finally
        {
            System.out.println("all done");
        }
    
    }
    public static String reverse(String s)
    {
        if (s.length() == 0)
        {
            throw new RuntimeException("String is empty");
        }
        String reverseStr = "";
        for (int i=s.length()-1 ; i>=0 ; --i) {
            reverseStr += s.charAt(i);
        }
        return reverseStr;
    }
}
