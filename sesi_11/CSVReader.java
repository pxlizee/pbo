package sesi_11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line = "";
        String csvSplitBy = ";";
        int index = 0;
        System.out.println("NIM, NAMA, KELAS, PRODI");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((line = br.readLine()) != null) {
            index ++;
            if (index > 1) {
            String[] student = line.split(csvSplitBy);
            System.out.println(student[0] + ", " + student[1] + ", " + student[2] + ", " + student[3]);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
