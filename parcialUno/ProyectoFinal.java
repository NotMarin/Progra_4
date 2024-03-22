import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoFinal {
    public static Scanner leerDatoTeclado = new Scanner(System.in);
    public static final byte TIPO_DOCUMENTO_IDENTIFICACION = 0;
    public static final byte DOCUMENTO_IDENTIFICACION = 1;
    public static final byte NOMBRES = 2;
    public static final byte APELLIDOS = 3;
    public static final byte CORREO_ELECTRONICO = 4;
    public static final byte DIRECCION_DE_RESIDENCIA = 5;
    public static final byte CIUDAD_DE_RESIDENCIA = 6;
    public static final byte TELEFONO_DE_CONTACTO = 7;
    public static final byte CONTRASENA = 8;
    public static final byte CONFIRMAR_CONTRASENA = 9;
    
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

        String contrasena = "1";
        String confirmarContrasena = "0";

        while (!contrasena.equals(confirmarContrasena)) {
            System.out.print("Contraseña: ");
            contrasena = leerDatoTeclado.nextLine();
        
            System.out.print("Confirmar contraseña: ");
            confirmarContrasena = leerDatoTeclado.nextLine();
            
            if (!contrasena.equals(confirmarContrasena)) {
                System.out.print("Las contraseñas no coinciden. Inténtelo de nuevo.\n");
            }
        }
  
        registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico, direccionResidencia, ciudadResidencia, telefonoContacto, contrasena, confirmarContrasena);
    }
  
    public static void registrarUsuario(String tipoDocumentoIdentificacion, String documentoIdentificacion, String nombres, String apellidos, String correoElectronico, String direccionResidencia, String ciudadResidencia, String telefonoContacto, String contrasena, String confirmarContrasena) {
  
        String[] usuario = new String[10];
        usuario[TIPO_DOCUMENTO_IDENTIFICACION] = tipoDocumentoIdentificacion;
        usuario[DOCUMENTO_IDENTIFICACION] = documentoIdentificacion;
        usuario[NOMBRES] = nombres;
        usuario[APELLIDOS] = apellidos;
        usuario[CORREO_ELECTRONICO] = correoElectronico;
        usuario[DIRECCION_DE_RESIDENCIA] = direccionResidencia;
        usuario[CIUDAD_DE_RESIDENCIA] = ciudadResidencia;
        usuario[TELEFONO_DE_CONTACTO] = telefonoContacto;
        usuario[CONTRASENA] = contrasena;
        usuario[CONFIRMAR_CONTRASENA] = confirmarContrasena;
  
        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente.\n");
    }
  

    public static void iniciarSesion() {
        leerDatoTeclado.nextLine();
        System.out.print("Ingrese su correo electrónico: ");
        String correoElectronico = leerDatoTeclado.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = leerDatoTeclado.nextLine();
  
        if (validarCredenciales(correoElectronico, contrasena)) {
            System.out.println("Usuario logueado correctamente.\n");
        } else {
            System.out.println("Usuario incorrecto, intente una vez más.\n");
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
