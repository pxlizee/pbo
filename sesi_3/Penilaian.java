public class Penilaian extends Mahasiswa {
    private double nilai;
    private String grade;
    private boolean statusLulus;

    public Penilaian(String nim, String nama, double nilai) {
        super(nim, nama);
        this.nilai = nilai;
        tentukanGradeDanStatus();
    }

    // Method untuk menentukan grade dan status lulus berdasarkan nilai
    private void tentukanGradeDanStatus() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A"; statusLulus = true;
        } else if (nilai >= 70 && nilai < 80) {
            grade = "B"; statusLulus = true;
        } else if (nilai >= 60 && nilai < 70) {
            grade = "C"; statusLulus = true;
        } else if (nilai >= 50 && nilai < 60) {
            grade = "D"; statusLulus = false;
        } else {
            grade = "E"; statusLulus = false;
        }
    }

    public double getNilai() {
        return nilai;
    }

    public String getGrade() {
        return grade;
    }

    public boolean isLulus() {
        return statusLulus;
    }
}