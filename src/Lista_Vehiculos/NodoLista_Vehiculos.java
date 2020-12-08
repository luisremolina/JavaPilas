package Lista_Vehiculos;

public class NodoLista_Vehiculos {

    float Precio;
    int Numero_Vehi, Max_Pasajeros, Frecuencia;
    String Placa, Conductor, Ruta, Hora_Salida;
    Object Cpasa1, Npasa1, Cpasa2, Npasa2, Cpasa3, Npasa3, Cpasa4, Npasa4, Cpasa5, Npasa5,
            Cpasa6, Npasa6, Cpasa7, Npasa7, Cpasa8, Npasa8, Cpasa9, Npasa9, Cpasa10, Npasa10;
    NodoLista_Vehiculos sig;

    //PRIMER CONSTRUCTOR
    public NodoLista_Vehiculos(int num, String placa, String conductor, String ruta, String hora, float precio, int pasajeros_max, int frecuencia, Object cpasa1, Object npasa1, Object cpasa2, Object npasa2, Object cpasa3, Object npasa3, Object cpasa4, Object npasa4, Object cpasa5, Object npasa5, Object cpasa6, Object npasa6, Object cpasa7, Object npasa7, Object cpasa8, Object npasa8, Object cpasa9, Object npasa9, Object cpasa10, Object npasa10) {

        Numero_Vehi = num;
        Placa = placa;
        Conductor = conductor;
        Ruta = ruta;
        Hora_Salida = hora;
        Max_Pasajeros = pasajeros_max;
        Precio = precio;
        Frecuencia = frecuencia;

        Cpasa1 = cpasa1;
        Npasa1 = npasa1;
        Cpasa2 = cpasa2;
        Npasa2 = npasa2;
        Cpasa3 = cpasa3;
        Npasa3 = npasa3;
        Cpasa4 = cpasa4;
        Npasa4 = npasa4;
        Cpasa5 = cpasa5;
        Npasa5 = npasa5;
        Cpasa6 = cpasa6;
        Npasa6 = npasa6;
        Cpasa7 = cpasa7;
        Npasa7 = npasa7;
        Cpasa8 = cpasa8;
        Npasa8 = npasa8;
        Cpasa9 = cpasa9;
        Npasa9 = npasa9;
        Cpasa10 = cpasa10;
        Npasa10 = npasa10;

        sig = null;
    }

    //SEGUNDO CONSTRUCTOR
    public NodoLista_Vehiculos(int num, String placa, String conductor, String ruta, String hora, float precio, int pasajeros_max, int frecuencia, Object cpasa1, Object npasa1, Object cpasa2, Object npasa2, Object cpasa3, Object npasa3, Object cpasa4, Object npasa4, Object cpasa5, Object npasa5, Object cpasa6, Object npasa6, Object cpasa7, Object npasa7, Object cpasa8, Object npasa8, Object cpasa9, Object npasa9, Object cpasa10, Object npasa10, NodoLista_Vehiculos liga) {

        Numero_Vehi = num;
        Placa = placa;
        Conductor = conductor;
        Ruta = ruta;
        Hora_Salida = hora;
        Max_Pasajeros = pasajeros_max;
        Precio = precio;
        Frecuencia = frecuencia;

        Cpasa1 = cpasa1;
        Npasa1 = npasa1;
        Cpasa2 = cpasa2;
        Npasa2 = npasa2;
        Cpasa3 = cpasa3;
        Npasa3 = npasa3;
        Cpasa4 = cpasa4;
        Npasa4 = npasa4;
        Cpasa5 = cpasa5;
        Npasa5 = npasa5;
        Cpasa6 = cpasa6;
        Npasa6 = npasa6;
        Cpasa7 = cpasa7;
        Npasa7 = npasa7;
        Cpasa8 = cpasa8;
        Npasa8 = npasa8;
        Cpasa9 = cpasa9;
        Npasa9 = npasa9;
        Cpasa10 = cpasa10;
        Npasa10 = npasa10;

        this.sig = liga;
    }
}
