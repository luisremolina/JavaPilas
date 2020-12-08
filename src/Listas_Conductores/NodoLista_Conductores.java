package Listas_Conductores;

public class NodoLista_Conductores {

    int Cedula, Numero_Vehiculo;
    String Nombre, Apellido, Telefono, Placa, Tipo_RH;

    NodoLista_Conductores sig;

    //PRIMER CONSTRUCTOR
    public NodoLista_Conductores(int cedula, String nombre, String apellido, String telc, String RH, String placa, int Vehiculo_num) {
        
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telc;
        Tipo_RH = RH;

        Placa = placa;
        Numero_Vehiculo = Vehiculo_num;

        sig = null;
    }

    //SEGUNDO CONSTRUCTOR
    public NodoLista_Conductores(int cedula, String nombre, String apellido, String telc, String RH, String placa, int Vehiculo_num, NodoLista_Conductores liga) {
       
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telc;
        Tipo_RH = RH;

        Placa = placa;
        Numero_Vehiculo = Vehiculo_num;

        this.sig = liga;
    }
}
