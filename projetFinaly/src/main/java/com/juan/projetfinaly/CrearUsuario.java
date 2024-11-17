
package com.juan.projetfinaly;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class CrearUsuario extends javax.swing.JDialog {

    public CrearUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       
        initComponents();
        setLocationRelativeTo(null);
    }
    public CrearUsuario() {
        throw new UnsupportedOperationException("no soportadoo."); 
    }
    
    // Método para validar los campos
    private boolean validarCampos(String nombre, String apellido, String correo, String carrera, String semestre, String contraseña, String confirmarContraseña) {
        
        //Esta condicion es para que las dos contraseñas que se ingresen se validen, es decir que la confirmacion de la segunda contraseña tiene que ser igual con la primera 
     if (!contraseña.equals(confirmarContraseña)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
        imputContraseña.setText(""); 
        imputConfPassw.setText("");
        return false;
       }
        //Esta condicon es para para que los campos del JTextFiel y el JPassword no queden vacios
        if (Stream.of(nombre, apellido, correo, carrera, semestre, contraseña).anyMatch(String::isEmpty)) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
     }
        return true;
    }
       // Es un metodo para que las contraseñas que se crean tien que cuncplir con cierto requerimiento para que se puda crear el usuario
        private boolean validarContraseña(String contraseña) {
    if (contraseña.length() < 8 || !contraseña.matches(".*[a-zA-Z].*") || !contraseña.matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 8 caracteres, una letra y un número.", "Error", JOptionPane.ERROR_MESSAGE);
        imputContraseña.setText("");
        imputConfPassw.setText("");
        return false;
    }
    return true;
}
 
     // Método para guardar los datos del usuario en un archivo
    private void guardarUsuarioEnBlocNotas(String nombre, String apellido, String correo, String carrera, String semestre, String contraseña) {
       
        //aqui se guarfda en un bloc de notas
        String blocNotas = "usuarios.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(blocNotas, true))) {
            
            writer.write("Nombre: " + nombre);
            writer.newLine();
            writer.write("Apellido: " + apellido);
            writer.newLine();
            writer.write("Correo: " + correo);
            writer.newLine();
            writer.write("Carrera: " + carrera);
            writer.newLine();
            writer.write("Semestre: " + semestre);
            writer.newLine();
            writer.write("Contraseña: " + contraseña);
            writer.newLine();
            writer.write("-----------------------------");
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.", "Registro", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
    }
    private void limpiar_campos2(){
        inputname.setText("");
        inputapellido.setText("");
        imputCorreo.setText("");
        imputCarrea.setText("");
        imputSemestre.setText("");
        imputContraseña.setText("");
        imputConfPassw.setText(""); 
    }

    public void registrarme(){
        
       String nombre = inputname.getText();
       String apellido = inputapellido.getText();
       String correo = imputCorreo.getText();
        String carrera = imputCarrea.getText();
        String semestre = imputSemestre.getText();
        String contraseña = new String(imputContraseña.getPassword());
        String confirmarContraseña = new String(imputConfPassw.getPassword());
        
        if (!validarCampos(nombre, apellido, correo, carrera, semestre, contraseña, confirmarContraseña)) {
            return;
        }
        if (!validarContraseña(contraseña)) {
            return;
        }

        guardarUsuarioEnBlocNotas(nombre, apellido, correo, carrera, semestre, contraseña);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        imputCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imputContraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        imputCarrea = new javax.swing.JTextField();
        imputSemestre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        imputConfPassw = new javax.swing.JPasswordField();
        Crear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputapellido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Correo Institucional");

        imputCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imputCorreoActionPerformed(evt);
            }
        });

        jLabel3.setText("Carrera");

        jLabel4.setText("Semestre");

        jLabel5.setText("Constraseña");

        jLabel6.setText("Confirmar contraseña");

        Crear.setText("Crear");
        Crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\RYZEN\\Documents\\NetBeansProjects\\projetFinaly\\src\\logo\\dial.PNG")); // NOI18N

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 99, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(Crear))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputapellido)
                                    .addComponent(imputCarrea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(imputCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(imputContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(imputSemestre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(imputConfPassw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(inputname, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Crear))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(inputapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imputCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imputCarrea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imputSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imputContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imputConfPassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imputCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imputCorreoActionPerformed
  
    }//GEN-LAST:event_imputCorreoActionPerformed

    private void CrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearMouseClicked
      
        registrarme();
        limpiar_campos2();

        this.dispose();
   
    }//GEN-LAST:event_CrearMouseClicked

    public static void main(String args[]) {
     
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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearUsuario dialog = new CrearUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Crear;
    private javax.swing.JTextField imputCarrea;
    private javax.swing.JPasswordField imputConfPassw;
    private javax.swing.JPasswordField imputContraseña;
    private javax.swing.JTextField imputCorreo;
    private javax.swing.JTextField imputSemestre;
    private javax.swing.JTextField inputapellido;
    private javax.swing.JTextField inputname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    private void mostrar_Datos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
