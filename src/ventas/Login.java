/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import sun.security.util.Password;
import java.sql.*;
//import jbbc.Jbbc;

/**
 *
 * @author Freddy
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLUsuario = new javax.swing.JLabel();
        jContraseña = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jEntrar = new javax.swing.JButton();
        contrasena = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLUsuario.setText("Usuario");
        getContentPane().add(jLUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, -1));

        jContraseña.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jContraseña.setText("Contraseña");
        getContentPane().add(jContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 30));

        jEntrar.setText("Entrar");
        jEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEntrarMouseClicked(evt);
            }
        });
        jEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 100, 30));
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Freddy\\Documents\\NetBeansProjects\\Imagenes y iconos\\Login_Sistema.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 520, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void jEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntrarActionPerformed
     
        new Jbbc();
        String user = usuario.getText();
        String pass = contrasena.getText(); 
        String UsuTab = "";     
        String ConTab = "";
        boolean EntradaActivada = false;
        boolean UsuarioCorrecto = false;
        boolean ContrasenaCorrecta = false;
        ResultSet Resultado = Jbbc.Consulta("Select * From Login");
        try{
            
        while(Resultado.next()){
        
             UsuTab = Resultado.getString("Usuario");
             ConTab = Resultado.getString("Contraseña");
             
             if(UsuTab.equals(user) == true && ConTab.equals(pass) ==  true){
             
               UsuarioCorrecto = true;
               ContrasenaCorrecta = true;        
               break;
             
                                                                            }
             
             else 
                 
             if(UsuTab.equals(user) == false && ConTab.equals(pass) ==  false){
             
                UsuarioCorrecto = false;
                ContrasenaCorrecta = false;             
             
                                                                              } 
             
             else
              
             if(UsuTab.equals(user) == true){
             
               ContrasenaCorrecta = false; 
               
                                            }
             
             else {
             
               UsuarioCorrecto = false;
                  
                  }
             
          //   if(UsuTab.equals(user) == true)UsuarioCorrecto = true;
           //  if(ConTab.equals(pass) == true)ContrasenaCorrecta = true;
             
            
                               }
        
        }catch(SQLException ex){
        
              JOptionPane.showMessageDialog(this, "Error sql");
            
                               }

       if(UsuarioCorrecto == false){
       
         JOptionPane.showMessageDialog(this, "Usuario incorrecto");   
       
                                    }
       
       if(ContrasenaCorrecta == false){
       
         JOptionPane.showMessageDialog(this, "Contraseña incorrecta");   
       
                                      } 
       
       if(UsuarioCorrecto == true && ContrasenaCorrecta == true){
       
          Menu_Principal MP = new Menu_Principal();
          MP.setVisible(true);
          dispose();      
                                                                   
                                                                 }
       
           
    }//GEN-LAST:event_jEntrarActionPerformed

    private void jEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEntrarMouseClicked
      
       
    }//GEN-LAST:event_jEntrarMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JLabel jContraseña;
    private javax.swing.JButton jEntrar;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

    private String PasswordgetPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
