package sesi_10;

import java.io.RandomAccessFile;

public class RandomAccesRevisi {
    public static void main(String[] args) {
        String bookList[] = {"Java", "Python", "C++", "JavaScript"};
        int yearList[] = {1995, 1991, 1985, 1995};
        try (RandomAccessFile books = new RandomAccessFile("books.txt", "rw")) {
            for (int i = 0; i < bookList.length; i++) {
                books.writeUTF(bookList[i]);
                books.writeInt(yearList[i]);
            }
            books.seek(0);
            System.out.println(books.readUTF() + " " + books.readInt());
            System.out.println(books.readUTF() + " " + books.readInt());
        } catch (java.lang.Exception e) {
            System.out.println("Index Melebihi batas");
        }
        System.out.println("test");
    }
    
}
