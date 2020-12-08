package Listas_rutas;

public class NodoLista_rutas {

    int Horario, id_ruta;
    String Origen, Destino;
    double Precio;

    NodoLista_rutas sig;

    //PRIMER CONSTRUCTOR
    public NodoLista_rutas(int id, String origen, String destino, double precio, int horario) {
        id_ruta = id;
        Origen = origen;
        Destino = destino;
        Precio = precio;
        Horario = horario;
        sig = null;
    }

    //SEGUNDO CONSTRUCTOR
    public NodoLista_rutas(int id, String origen, String destino, double precio, int horario, NodoLista_rutas liga) {
        id_ruta = id;
        Origen = origen;
        Destino = destino;
        Precio = precio;
        Horario = horario;
        this.sig = liga;
    }
}
