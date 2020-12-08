package Lista_Pasajeros;

public class NodoLista_Pasajeros {

    int Cedula;
    String Nombres, Apellidos, RH, Telefono;
    NodoLista_Pasajeros sig;

    //PRIMER CONSTRUCTOR
    public NodoLista_Pasajeros(int cedula, String nombres, String apellido, String rh, String telefono) {

        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellido;
        RH = rh;
        Telefono = telefono;

        sig = null;
    }

    //SEGUNDO CONSTRUCTOR
    public NodoLista_Pasajeros(int cedula, String nombres, String apellido, String rh, String telefono, NodoLista_Pasajeros liga) {

        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellido;
        RH = rh;
        Telefono = telefono;

        this.sig = liga;
    }
}
