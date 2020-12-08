package Lista_Antecedentes;

public class NodoLista_Antecedentes {

    int Cedula;
    String Nombres, Apellidos, Motivo;
    String Activo;

    NodoLista_Antecedentes sig;

    public NodoLista_Antecedentes(int cedula, String nombre, String apellido, String motivo, String activo) {

        Cedula = cedula;
        Nombres = nombre;
        Apellidos = apellido;
        Motivo = motivo;
        Activo = activo;

        sig = null;
    }

    public NodoLista_Antecedentes(int cedula, String nombre, String apellido, String motivo, String activo, NodoLista_Antecedentes liga) {

        Cedula = cedula;
        Nombres = nombre;
        Apellidos = apellido;
        Motivo = motivo;
        Activo = activo;

        this.sig = liga;
    }
}
