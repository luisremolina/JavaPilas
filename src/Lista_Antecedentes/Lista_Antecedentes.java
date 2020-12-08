package Lista_Antecedentes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Lista_Antecedentes {

    NodoLista_Antecedentes Primero, ultimo, aux, nuevo, ant, post, aux2;

    public Lista_Antecedentes() {
        Primero = ultimo = aux = nuevo = ant = post = null;
    }

    public void insertarcola(int cedula, String nombre, String apellido, String motivo, String activo) {
        if (Primero == null) {
            Primero = new NodoLista_Antecedentes(cedula, nombre, apellido, motivo, activo);
            ultimo = Primero;
        } else {
            nuevo = new NodoLista_Antecedentes(cedula, nombre, apellido, motivo, activo);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }

    }

    public void cargar_datos() {
        try {
            String[] Datos_lista = null;
            FileReader leer_archivo = new FileReader("Antecedentes.txt");
            BufferedReader br = new BufferedReader(leer_archivo);
            Character separador = ';';
            String datos = "";
            File archivo = new File("Antecedentes.txt");

            if (archivo.exists() && archivo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            } else {
                while ((datos = br.readLine()) != null) {

                    Datos_lista = datos.split(String.valueOf(separador));

                    int cedula = Integer.parseInt(Datos_lista[0]);
                    String nombre = Datos_lista[1];
                    String apellido = Datos_lista[2];
                    String motivo = Datos_lista[3];
                    String activo = Datos_lista[4];

                    insertarcola(cedula, nombre, apellido, motivo, activo);
                }
                br.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No hay antecedentes registrados");
        }
    }

    public String[] buscar(int busc) {

        String datos[] = new String[4];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La persona no cuenta con antecedentes penales");
        } else {
            while (aux != null) {
                if (aux.Cedula == busc) {
                    datos[0] = aux.Nombres;
                    datos[1] = aux.Apellidos;
                    datos[2] = aux.Motivo;
                    datos[3] = aux.Activo;
                    break;
                }
                aux = aux.sig;
            }
        }
        return datos;
    }

    public void despliegaLista() {
        String cad = "";
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La persona no cuenta con antecedentes penales");
        } else {

            while (aux != null) {

                cad = cad + "La persona identificada con cedula: " + aux.Cedula + " \n Cuenta con antecedentes por: " + aux.Motivo + " \n y se encuentran en estado: " + aux.Activo + "\n";
                aux = aux.sig;

            }
            JOptionPane.showMessageDialog(null, cad);

        }
    }
}
