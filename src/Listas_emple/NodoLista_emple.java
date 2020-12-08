package Listas_emple;

///clase (registro) que sirve para generar nodos de dos tipos de formas (2 constructores)
public class NodoLista_emple {
    // 2 campos

    Integer Cedula;
    Object nombre, apellido, celular, usuario, contraseña;
    boolean admon;

    NodoLista_emple sig;

    //PRIMER CONSTRUCTOR
    public NodoLista_emple(int cedula, Object nombres, Object apellidos, Object telefono, Object user, Object pwd, boolean admin) {
        Cedula = cedula;
        nombre = nombres;
        apellido = apellidos;
        celular = telefono;
        usuario = user;
        contraseña = pwd;
        admon = admin;
        sig = null;
    }

    //SEGUNDO CONSTRUCTOR
    public NodoLista_emple(int dato, Object nom, Object apell, Object telefono, Object user, Object pwd, boolean admin, NodoLista_emple liga) {
        Cedula = dato;
        nombre = nom;
        apellido = apell;
        celular = telefono;
        usuario = user;
        contraseña = pwd;
        admon = admin;
        this.sig = liga;
    }
}
