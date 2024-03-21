import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoFinal {
    public static Scanner leerDatoTeclado = new Scanner(System.in);
    public static final int TIPO_DOCUMENTO_IDENTIFICACION = 0;
    public static final int DOCUMENTO_IDENTIFICACION = 1;
    public static final int NOMBRES = 2;
    public static final int CORREO_ELECTRONICO = 6;
    public static final int CONTRASENA = 8;
    
    public static List<String[]> usuarios = new ArrayList<>();

    public static void mostrarMenuLoginRegistro() {
        System.out.println("Bienvenido a MyHotel ...");
        System.out.println("Mas que un lugar para descansar.");
        System.out.println("----------------------------------------------");
        System.out.println("Ingrese la opción deseada:");
        System.out.println("1. Registrarse como cliente.");
        System.out.println("2. Iniciar Sesión.");
        System.out.println("3. Salir");
        
        int opcion = leerDatoTeclado.nextInt();
        
        switch (opcion) {
            case 1:
                solicitarDatosDeRegistro();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                System.out.println("¡Hasta pronto!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida");
        }
        mostrarMenuLoginRegistro();
    }

    public static void solicitarDatosDeRegistro() {
        System.out.println("Ingrese los siguientes datos:");

        leerDatoTeclado.nextLine();
  
        System.out.print("Tipo de identificación: ");
        String tipoIdentificacion = leerDatoTeclado.nextLine();
  
        System.out.print("Documento de identificación: ");
        String documentoIdentificacion = leerDatoTeclado.nextLine();
  
        System.out.print("Nombres: ");
        String nombres = leerDatoTeclado.nextLine();
  
        System.out.print("Apellidos: ");
        String apellidos = leerDatoTeclado.nextLine();
  
        System.out.print("Correo electrónico: ");
        String correoElectronico = leerDatoTeclado.nextLine();
  
        System.out.print("Dirección de residencia: ");
        String direccionResidencia = leerDatoTeclado.nextLine();
  
        System.out.print("Ciudad de residencia: ");
        String ciudadResidencia = leerDatoTeclado.nextLine();
  
        System.out.print("Teléfono de contacto: ");
        String telefonoContacto = leerDatoTeclado.nextLine();
  
        System.out.print("Contraseña: ");
        String contrasena = leerDatoTeclado.nextLine();
  
        System.out.print("Confirmar contraseña: ");
        String confirmarContrasena = leerDatoTeclado.nextLine();
  
        registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico, direccionResidencia, ciudadResidencia, telefonoContacto, contrasena, confirmarContrasena);
    }
  
    public static void registrarUsuario(String tipoDocumentoIdentificacion, String documentoIdentificacion, String nombres, String apellidos, String correoElectronico, String direccionResidencia, String ciudadResidencia, String telefonoContacto, String contrasena, String confirmarContrasena) {
        if (!contrasena.equals(confirmarContrasena)) {
            System.out.println("Las contraseñas no coinciden. Intente nuevamente.");
            return;
        }
  
        String[] usuario = new String[10];
        usuario[TIPO_DOCUMENTO_IDENTIFICACION] = tipoDocumentoIdentificacion;
        usuario[DOCUMENTO_IDENTIFICACION] = documentoIdentificacion;
        usuario[NOMBRES] = nombres;
        usuario[CORREO_ELECTRONICO] = correoElectronico;
        usuario[CONTRASENA] = contrasena;
  
        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente.");
    }
  

    public static void iniciarSesion() {
        leerDatoTeclado.nextLine(); // Consumir el carácter de nueva línea residual
        System.out.print("Ingrese su correo electrónico: ");
        String correoElectronico = leerDatoTeclado.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = leerDatoTeclado.nextLine();
  
        if (validarCredenciales(correoElectronico, contrasena)) {
            System.out.println("Usuario logueado correctamente.");
        } else {
            System.out.println("Usuario incorrecto, intente una vez más.");
        }
    }

    public static boolean validarCredenciales(String correoElectronico, String contrasena) {
        for (String[] usuario : usuarios) {
            if (usuario != null && usuario[CORREO_ELECTRONICO] != null && usuario[CONTRASENA] != null && usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        mostrarMenuLoginRegistro();
    }
}