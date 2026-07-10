package app.main;
import app.gui.LoginForm;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()-> {
            new LoginForm().setVisible(true);
        });
    }
    
}
