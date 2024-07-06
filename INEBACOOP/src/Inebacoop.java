
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;  //decclarar


public class Inebacoop extends JFrame {


    private JPanel panel1;
    //impoetar la clase Usuario declraando una variable
    private HashMap<String, Estudiante> usuariosRegistrados;

    private JTextField ingresadopor_usuario;
    private JPasswordField ingresado_pasword;
    private static final String GUARDAR = "usuarios.txt";


    public Inebacoop() {

        usuariosRegistrados = new HashMap<>(); //inicializacion del HashMaP
        CargarDatos_a_HashMap_paraValidacion_de_InicioSesion();//Llamar funcion cargar usuarios

        setSize(400, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("INEBACOP");

        LlamarMetodos();

    }

    public void LlamarMetodos() {
        CrearPanel();
        CrearEtiquetasPanelPrincial();
        CrearBottones();

    }

    public void CrearPanel() {
        panel1 = new JPanel();
        panel1.add(new JPanel());
        panel1.setLayout(null);
        panel1.setBackground(Color.gray);
        getContentPane().add(panel1);

    }

    public void CrearEtiquetasPanelPrincial() {
        JLabel etiqueta1 = new JLabel();
        etiqueta1.setBounds(100, 20, 220, 20);
        etiqueta1.setText("BIENVENIDO ESTUDIANTE");
        etiqueta1.setForeground(Color.blue);
        etiqueta1.setFont(new Font("Amasis MT Pro Black", Font.BOLD, 16));
        panel1.add(etiqueta1);


        //crear etiquetas tipo imagen
        ImageIcon imageIcon = new ImageIcon("logo.jpeg");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(80, 100, 230, 200);
        etiqueta2.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_AREA_AVERAGING)));
        etiqueta2.setBackground(Color.lightGray);
        panel1.add(etiqueta2);

        JLabel etiqueta3 = new JLabel("---INEBACOP---");
        etiqueta3.setBounds(150, 40, 220, 20);
        etiqueta3.setForeground(Color.blue);
        etiqueta3.setFont(new Font("Amasis MT Pro Black", Font.BOLD, 16));
        panel1.add(etiqueta3);

        JLabel etiqueta4 = new JLabel("Santa María Tzejá");
        etiqueta4.setBounds(120, 70, 220, 20);
        etiqueta4.setForeground(Color.blue);
        etiqueta4.setFont(new Font("Edwardian Script ITC", Font.BOLD, 26));
        panel1.add(etiqueta4);


        JLabel etiqueta5 = new JLabel("Ingrese su usuario");
        etiqueta5.setBounds(130, 320, 220, 20);
        etiqueta5.setForeground(Color.black);
        etiqueta5.setFont(new Font("Arial", Font.BOLD, 15));
        panel1.add(etiqueta5);

        ingresadopor_usuario = new JTextField();
        ingresadopor_usuario.setBounds(120, 343, 170, 20);
        panel1.add(ingresadopor_usuario);

        JLabel etiqueta6 = new JLabel("Ingrese su contraseña");
        etiqueta6.setBounds(120, 370, 220, 20);
        etiqueta6.setForeground(Color.black);
        etiqueta6.setFont(new Font("Arial", Font.BOLD, 15));
        panel1.add(etiqueta6);


        /*este objeto es epecialmente para contraseñas*/
        ingresado_pasword = new JPasswordField();
        ingresado_pasword.setBounds(120, 395, 160, 20);
        panel1.add(ingresado_pasword);


    }

    private void CrearBottones() {

        JButton botonIniciosesion = new JButton();
        botonIniciosesion.setText("Incicar sesion");
        botonIniciosesion.setBounds(140, 425, 120, 20);
        panel1.add(botonIniciosesion);

        //crear un evento a este boton de inicio de sesion
        ActionListener actionBoton1Inciciosesion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IniciarSesion();  /*llamar funcion para iniciar sesion*/
            }
        };
        botonIniciosesion.addActionListener(actionBoton1Inciciosesion);


        JButton boton2 = new JButton();
        boton2.setText("Incicar sesion en otra cuenta");
        boton2.setBounds(105, 455, 200, 20);
        boton2.setBackground(Color.green);
        panel1.add(boton2);

        //boton registrar usuario
        JButton boton3Registrase = new JButton();
        boton3Registrase.setText("Registrase");
        boton3Registrase.setBounds(8, 40, 100, 30);
        panel1.add(boton3Registrase);


        //crear un evento para registrar o crear usuario
        ActionListener actionBoton3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarNuevousuario();//llamar la funcion para que crear usuario
            }
        };
        boton3Registrase.addActionListener(actionBoton3);

    }
    /*-----------------------------------------------------------------*/


    //El metodo de incicio de sesion
    private void IniciarSesion() {

        String usuario_entrando = ingresadopor_usuario.getText();
        String contrasena = new String(ingresado_pasword.getPassword());
        Estudiante consultando_estudiante = usuariosRegistrados.get(usuario_entrando);

        if (consultando_estudiante != null && consultando_estudiante.getConstrasena().equals(contrasena)) {
            JOptionPane.showMessageDialog(this, "Incicio de sesion exitoso. ");
            VentanaPostLogin ventanaPostLogin = new VentanaPostLogin();
            ventanaPostLogin.setVisible(true);
            //cerrar ventan actual inebacop
            dispose();
        } else {

            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña icorrecto");
        }
    }


    //aqui hay una metddo con eventos dentro del metodo
    /*-----------------------------------------------------------------*/
    //uso de JDialog
    private void RegistrarNuevousuario() {

        JDialog VentEn_panel = new JDialog(this, "Crear un Usuario", true);

        VentEn_panel.setSize(350, 500);
        VentEn_panel.setLocationRelativeTo(this);


        //aqui se usa Layout null, para modificar el diseño de fabrica
        VentEn_panel.setLayout(null);

        //aqui se crea unas etiquetas
        JLabel usuarioLabel = new JLabel("Usuario");
        usuarioLabel.setBounds(50, 50, 100, 20);
        VentEn_panel.add(usuarioLabel);

        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(150, 50, 150, 30);
        VentEn_panel.add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Contraseña");
        contrasenaLabel.setBounds(50, 100, 100, 30);
        VentEn_panel.add(contrasenaLabel);

        //Aqui se crea campos especiales para contraseña
        JPasswordField contraenaPasword = new JPasswordField();
        contraenaPasword.setBounds(150, 100, 150, 30);
        VentEn_panel.add(contraenaPasword);

        JButton registrarBoton = new JButton("Crear mi cuenta");
        registrarBoton.setBounds(40, 200, 130, 30);
        VentEn_panel.add(registrarBoton);


        //aqui para abajo evento para registrar Nuevo usuario
        //se instacnio el objeto registroBoton
        registrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = usuarioField.getText();
                String contrasena = new String(contraenaPasword.getPassword());

                if (usuariosRegistrados.containsKey(nombreUsuario)) {
                    JOptionPane.showMessageDialog(VentEn_panel, "El nombre del usuario ya existe, vuela a registrar uno nuevo");
                } else {

                    usuariosRegistrados.put(nombreUsuario, new Estudiante(nombreUsuario, contrasena));

                    guardarUsuarios(); //se llama la funcion guardar usuario
                    JOptionPane.showMessageDialog(VentEn_panel, "Usuario registrado correctamente");
                    VentEn_panel.dispose();
                }
            }

        });

        JButton cancelarBoton = new JButton("Cancelar");
        cancelarBoton.setBounds(200, 200, 90, 30);
        VentEn_panel.add(cancelarBoton);


        //aqui para abajo el evento para cancelar bototn
        //se crea un objeto
        cancelarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentEn_panel.dispose(); //se cierra la ventana de dialogo

            }
        });

        VentEn_panel.setVisible(true);

    }

    /*-------------------------------------------------------------------------------------------------------*/

    private void CargarDatos_a_HashMap_paraValidacion_de_InicioSesion() {
        try (BufferedReader br = new BufferedReader(new FileReader(GUARDAR))) {
            String leido;
            while ((leido = br.readLine()) != null) {
                String[] datos_guardados = leido.split(",");

                if (datos_guardados.length == 2) {
                    String student = datos_guardados[0].trim();
                    String contrasena = datos_guardados[1].trim();
                    usuariosRegistrados.put(student, new Estudiante(student, contrasena));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(GUARDAR))) {
            for (Estudiante usuario : usuariosRegistrados.values()) {
                bw.write(usuario.getUsuario() + "," + usuario.getConstrasena());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //una ventana interna de Jframe
    public static class VentanaPostLogin extends JFrame {

        public VentanaPostLogin() {

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            setSize(screenSize.width, screenSize.height);
            setLocation(0, 0);

            //setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
    }
}







