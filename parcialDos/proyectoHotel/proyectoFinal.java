package proyectoHotel;
import interfaz.*;
import javax.swing.JFrame;

public class proyectoFinal {
  public static void main(String[] args) {
    ventanaPrincipal ventana = new ventanaPrincipal();
    
    ventana.setSize(400, 300);
    ventana.setLocationRelativeTo(null);
    // Configurar la operación por defecto al cerrar la ventana
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Hacer visible la ventana
    ventana.setVisible(true);
}
}
