package Mundial_de_futbol;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interfaz interfaz = new Interfaz();
            }
        });
    }
}
