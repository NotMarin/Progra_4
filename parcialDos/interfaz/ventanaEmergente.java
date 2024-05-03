package interfaz;

import javax.swing.*;
import java.awt.event.*;

public class ventanaEmergente {
  public static void mostrarVentanaEmergente(String mensaje, String titulo, int tipoMensaje, int duracion) {
    JOptionPane optionPane = new JOptionPane(mensaje, tipoMensaje);
    final JDialog dialog = optionPane.createDialog(null, titulo);

    Timer timer = new Timer(duracion, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    });
    timer.setRepeats(false); // El temporizador se ejecutará solo una vez
    timer.start();

    dialog.setVisible(true);
}
}
