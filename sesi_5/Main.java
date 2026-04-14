import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner diletakkan di dalam kurung try untuk "Try-with-resources"
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("=== SIMULASI DATA AKADEMIK ===");

            // 1. Simulasi Input Mahasiswa
            System.out.print("Masukkan Nama Mahasiswa: ");
            String sName = input.nextLine();
            System.out.print("Masukkan Alamat Mahasiswa: ");
            String sAddress = input.nextLine();
            
            Student student = new Student(sName, sAddress);
            
            System.out.print("Banyak mata kuliah yang diambil mahasiswa: ");
            int nS = input.nextInt();
            input.nextLine(); 

            for (int i = 0; i < nS; i++) {
                System.out.print("Mata Kuliah " + (i + 1) + ": ");
                String cName = input.nextLine();
                System.out.print("Nilai: ");
                int cGrade = input.nextInt();
                input.nextLine(); 
                student.addCourseGrade(cName, cGrade);
            }

            // 2. Simulasi Input Dosen
            System.out.println("\n----------------------------");
            System.out.print("Masukkan Nama Dosen: ");
            String tName = input.nextLine();
            System.out.print("Masukkan Alamat Dosen: ");
            String tAddress = input.nextLine();
            
            Teacher teacher = new Teacher(tName, tAddress);
            
            System.out.print("Banyak mata kuliah yang diampu dosen: ");
            int nT = input.nextInt();
            input.nextLine(); 

            for (int i = 0; i < nT; i++) {
                System.out.print("Tambah Mata Kuliah ke-" + (i + 1) + ": ");
                String tcName = input.nextLine();
                if (teacher.addCourse(tcName)) {
                    System.out.println("Berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal: Mata kuliah sudah ada.");
                }
            }

            // 3. Output Hasil
            System.out.println("\n=== RINGKASAN DATA ===");
            System.out.println(student.toString());
            student.printGrades();
            System.out.println("Rata-rata Nilai: " + student.getAverageGrade());

            System.out.println("\n" + teacher.toString());
            
        } // Di sini Scanner 'input' otomatis di-close oleh Java
    }
}