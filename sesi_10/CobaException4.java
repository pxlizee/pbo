package sesi_10;

public class CobaException4 {
    public static void main(String[] args) {
        int bil = 10;
        String b[] = {"a", "b", "c"};

        try {
            System.out.println(b[3]);
            System.out.println(bil / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Melebihi jumlah array");
        } catch (ArithmeticException e) {
            System.out.println("Terjadi Arithmetic error");
        }
            catch (Throwable e) {
                System.out.println("Ini menghandle error yang terjadi");
            }
    }
}
