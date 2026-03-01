import javax.swing.JOptionPane;
public class Tugas2 {
    public static void main(String[] args) {
        String matkul = JOptionPane.showInputDialog(null, "Anda sedang belajar apa?", "Input", JOptionPane.QUESTION_MESSAGE);

        if (matkul != null) {
            JOptionPane.showMessageDialog(null, "Belajar " + matkul + " sangat mudah", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
