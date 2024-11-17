

package com.juan.projetfinaly;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


public class UniConecta extends javax.swing.JFrame {
      public UniConecta() {
        initComponents();
        setTitle("Uniconecta");
      
        int ancho = 350; 
        int alto = 500;
        setSize(ancho, alto);
        setLocationRelativeTo(null);
   
         addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent evt) {
         if (getExtendedState() == javax.swing.JFrame.MAXIMIZED_BOTH) {
              
             setSize(ancho, alto); 
                setLocationRelativeTo(null);
            }
        }
    }); 
    }
      

      
      
      
      
      
   //mmetodo para limpiar JtextFiel
    public void limpiar_campos(){
       imputUser.setText("");
        imputContrasenia.setText("");    
    }
        //Logica para el inicio de sesion
        public void iniciarSesion(){
        String usuario = imputUser.getText();
        char[] password = imputContrasenia.getPassword();
        //pasar el char a texto
        String contraseniaIngresada = new String(password);
       
        if (usuario.isEmpty() || contraseniaIngresada.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
        return; 
        
    } 
    boolean usuarioEncontrado = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
    String linea;
    
    //Se crea un objeto User
     UserDates user = new UserDates(); 
    String nombre = null;
    String apellido = null;
    String correo = null;
    String contrasena = null;
    String semestre = null;
    String carrera = null;
  
    // Lee el archivo (bloc de notas) linea por linea
    
    while ((linea = reader.readLine()) != null) {
        if (linea.startsWith("Correo: ")) {
            correo = linea.substring(8);  
          }
        //obtener el semestre
        else if (linea.startsWith("Semestre: ")) {
            semestre= linea.substring(10);   
        }
         //obtener la carrea
        else if (linea.startsWith("Carrera: ")) {
            carrera= linea.substring(9);   
        }
         //obtener el nombre
        else if (linea.startsWith("Nombre: ")) {
            nombre= linea.substring(8);   
        }
         //obtener el apellido
         else  if (linea.startsWith("Apellido: ")) {
            apellido= linea.substring(10);   
        }
      
        // Comprueba si la línea contiene la contraseña del usuario
        else if (linea.startsWith("Contraseña: ")) {
            contrasena = linea.substring(12);  
    
            // Verifica si el correo y la contraseña coinciden 
            if (correo != null && contrasena != null && correo.equals(usuario) && contrasena.equals(contraseniaIngresada)) {
                usuarioEncontrado = true;
             
               user.setCorreo(correo);
               user.setSemestre(semestre);
               user.setCarrera(carrera);
               user.setNombre(nombre);
               user.setApellido(apellido);
          
                break;  
            }
        }
    }

    // Este codigo verigfica si el usuario fue encontrado
    if (usuarioEncontrado) {
        
            WindowsPrincipal ventana = new WindowsPrincipal();
               ventana.setUsuario(user);
             
             ventana.setVisible(true);
         ventana.setExtendedState(ventana.MAXIMIZED_BOTH); 
      
        dispose(); 
        
    } else {
    
        
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecos", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error al leer el archivo de usuarios", "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
      
    }
        
        limpiar_campos();
 
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imputUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        imputContrasenia = new javax.swing.JPasswordField();
        Continuar = new javax.swing.JButton();
        oneRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        visiblePassw = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Iniciar sesion");

        jLabel2.setText("Ingrese su usuario");

        imputUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imputUserActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingrese su contraseña");

        imputContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imputContraseniaActionPerformed(evt);
            }
        });

        Continuar.setText("Continuar");
        Continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContinuarMouseClicked(evt);
            }
        });
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });

        oneRegistrar.setText("Registrarse");
        oneRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneRegistrarMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\RYZEN\\Documents\\NetBeansProjects\\projetFinaly\\src\\logo\\logo.PNG")); // NOI18N

        visiblePassw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visiblePasswMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visiblePasswMouseExited(evt);
            }
        });
        visiblePassw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visiblePasswActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imputUser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imputContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(oneRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(visiblePassw)))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel3)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imputUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imputContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visiblePassw))
                .addGap(11, 11, 11)
                .addComponent(Continuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oneRegistrar)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imputUserActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_imputUserActionPerformed

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
    
     iniciarSesion();
        
        
           
    }//GEN-LAST:event_ContinuarActionPerformed

    private void oneRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneRegistrarMouseClicked
     
        CrearUsuario dialog = new CrearUsuario(this, true);
        dialog.setVisible(true);
        

    
    }//GEN-LAST:event_oneRegistrarMouseClicked

    private void imputContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imputContraseniaActionPerformed
        // TODO add your handling code here:
  
        
    
    }//GEN-LAST:event_imputContraseniaActionPerformed

    private void ContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContinuarMouseClicked
        
       
    }//GEN-LAST:event_ContinuarMouseClicked
      private  boolean isPasswordVisible = false;
         
    private void visiblePasswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visiblePasswActionPerformed
       
      //cambia el estado de visibilidad
        isPasswordVisible = !isPasswordVisible; 
        imputContrasenia.setEchoChar(isPasswordVisible ? (char) 0 : '*');  
    }//GEN-LAST:event_visiblePasswActionPerformed

    private void visiblePasswMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visiblePasswMouseEntered
     
    }//GEN-LAST:event_visiblePasswMouseEntered

    private void visiblePasswMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visiblePasswMouseExited
     
    }//GEN-LAST:event_visiblePasswMouseExited

    
    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UniConecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniConecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniConecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniConecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UniConecta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JPasswordField imputContrasenia;
    private javax.swing.JTextField imputUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton oneRegistrar;
    private javax.swing.JCheckBox visiblePassw;
    // End of variables declaration//GEN-END:variables
}
