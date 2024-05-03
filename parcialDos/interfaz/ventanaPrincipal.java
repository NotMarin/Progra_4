package interfaz;

import modelacion.crearUsuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ventanaPrincipal extends javax.swing.JFrame {
  public ventanaPrincipal() {
    initComponents();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
private void initComponents() {

    iniciarsesion = new javax.swing.JButton();
    registrarse = new javax.swing.JButton();
    salir = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    iniciarsesion.setText("Iniciar Sesión");
    iniciarsesion.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            iniciarsesionActionPerformed(evt);
        }
    });

    registrarse.setText("Registrarse");
    registrarse.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            registrarseActionPerformed(evt);
        }
    });

    salir.setText("Salir");
    salir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            salirActionPerformed(evt);
        }
    });

    jLabel1.setText("MyHotel");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(iniciarsesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registrarse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(jLabel1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(salir)))
            .addContainerGap(159, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(iniciarsesion)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(registrarse)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
            .addComponent(salir)
            .addGap(27, 27, 27))
    );

    pack();
}// </editor-fold>//GEN-END:initComponents

private void iniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarsesionActionPerformed

    if(crearUsuario.registro_usuarios.isEmpty()){
        ventanaEmergente.mostrarVentanaEmergente("No hay usuarios registrados", "Vacío", JOptionPane.INFORMATION_MESSAGE, 2000);
    }else{ventanaLogin ventanalogin = new ventanaLogin();
    ventanalogin.setSize(600, 500);
    
    // Hacer visible la ventana
    ventanalogin.setVisible(true);
    }
}//GEN-LAST:event_iniciarsesionActionPerformed

private void registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseActionPerformed
    ventanaRegistroUsuario ventanaregistro = new ventanaRegistroUsuario();
    ventanaregistro.setSize(600, 500);
    
    // Hacer visible la ventana
    ventanaregistro.setVisible(true);
    
}//GEN-LAST:event_registrarseActionPerformed

private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
    this.dispose();
            ventanaEmergente.mostrarVentanaEmergente("Hasta Pronto", "Adiós", JOptionPane.INFORMATION_MESSAGE, 2000);

}//GEN-LAST:event_salirActionPerformed

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new ventanaPrincipal().setVisible(true);
        }
    });
}

// Variables declaration - do not modify//GEN-BEGIN:variables
public javax.swing.JButton iniciarsesion;
private javax.swing.JLabel jLabel1;
public javax.swing.JButton registrarse;
public javax.swing.JButton salir;
}
