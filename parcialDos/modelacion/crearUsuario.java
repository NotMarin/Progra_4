package modelacion;

import java.util.ArrayList;
import java.util.List;


public class crearUsuario {

    //Constructor por defecto
    public crearUsuario(){
    }
    
    private String tipoIdentificacion;
    private String documentoIdentificacion;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String direccionResidencia;
    private String ciudadResidencia;
    private String telefono;
    private String cont;

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Declaración de las constantes que representan la posición en el array de un usuario
    public static final byte TIPO_DOCUMENTO_USUARIO = 0;
    public static final byte NUMERO_IDENTIFICACION_USUARIO = 1;
    public static final byte NOMBRES_USUARIO = 2;
    public static final byte APELLIDOS_USUARIO = 3;
    public static final byte CORREO_ELECTRONICO_USUARIO = 4;
    public static final byte DIRECCION_USUARIO = 5;
    public static final byte CIUDAD_USUARIO = 6;
    public static final byte TELEFONO_USUARIO = 7;
    public static final byte CONTRASENA = 8;

    //Lista que guardará los arrays de datos de los usuarios
    public static List<String[]> registro_usuarios = new ArrayList<>();
    //Array para ingresar los datos de los usuarios
    public static String[] usuario = new String[10];

    public static void registrarUsuario(String TipoIdentificacion, String NumIdentificacion, String Nombres, String Apellidos, String CorreoElectronico, String Direccion, String Telefono, String Contrasena, String Ciudad){
    String[] nuevoUsuario = new String[10]; // Crear un nuevo array para el usuario

    // Copiar los datos del usuario en el nuevo array
    nuevoUsuario[TIPO_DOCUMENTO_USUARIO] = TipoIdentificacion;
    nuevoUsuario[NUMERO_IDENTIFICACION_USUARIO] = NumIdentificacion;
    nuevoUsuario[NOMBRES_USUARIO] = Nombres;
    nuevoUsuario[APELLIDOS_USUARIO] = Apellidos;
    nuevoUsuario[CORREO_ELECTRONICO_USUARIO] = CorreoElectronico;
    nuevoUsuario[DIRECCION_USUARIO] = Direccion;
    nuevoUsuario[CIUDAD_USUARIO] = Ciudad;
    nuevoUsuario[TELEFONO_USUARIO] = Telefono;
    nuevoUsuario[CONTRASENA] = Contrasena;

    registro_usuarios.add(nuevoUsuario); // Agregar el nuevo usuario a la lista
}

    public static boolean confirmarContrasena(String Contrasena, String ConfiContrasena){
        boolean bandera;
        bandera = Contrasena.equals(ConfiContrasena);
        
        return bandera;
    }

//Métodos para el inicio de sesión de un usuario

public static void mostrar() {
    for (String[] usuario : registro_usuarios) {
        System.out.println("Tipo de Identificacion: " + usuario[TIPO_DOCUMENTO_USUARIO]);
        System.out.println("Número de Identificacion: " + usuario[NUMERO_IDENTIFICACION_USUARIO]);
        System.out.println("Nombres: " + usuario[NOMBRES_USUARIO]);
        System.out.println("Apellidos: " + usuario[APELLIDOS_USUARIO]);
        System.out.println("Correo Electronico: " + usuario[CORREO_ELECTRONICO_USUARIO]);
        System.out.println("Direccion de Residencia: " + usuario[DIRECCION_USUARIO]);
        System.out.println("Ciudad de Residencia: " + usuario[CIUDAD_USUARIO]);
        System.out.println("Telefono: " + usuario[TELEFONO_USUARIO]);
        System.out.println("Contrasena: " + usuario[CONTRASENA]);
        System.out.println("-----------------------");
    }
}
    
    public static boolean iniciarSesionUsuario(String CorreoElectronico, String Contrasena) {
    // Recorrido de la lista de usuarios
    for (String[] usuario : registro_usuarios) {
        // Obtener el correo electrónico y la contraseña del usuario actual
        String correoUsuario = usuario[CORREO_ELECTRONICO_USUARIO];
        String contrasenaUsuario = usuario[CONTRASENA];

        // Verificar si las credenciales coinciden con las del usuario actual
        if (CorreoElectronico.equals(correoUsuario) && Contrasena.equals(contrasenaUsuario)) {
            // Si coinciden, devolver verdadero y salir del método
            return true;
        }
    }
    
    // Si se recorre toda la lista de usuarios y no se encuentra una coincidencia, devolver falso
    return false;
}
}
