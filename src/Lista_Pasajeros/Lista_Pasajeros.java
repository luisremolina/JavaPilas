package Lista_Pasajeros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Lista_Pasajeros {

    NodoLista_Pasajeros Primero, ultimo, aux, nuevo, ant, post, aux2;

    public Lista_Pasajeros() {
        Primero = ultimo = aux = nuevo = ant = post = null;
    }

    public void insertarcola(int cedula, String nombres, String apellido, String rh, String telefono) {
        if (Primero == null) {// si la lista esta vacia
            Primero = new NodoLista_Pasajeros(cedula, nombres, apellido, rh, telefono);
            ultimo = Primero;
        } else {////ya hay mas nodos en la lista
            nuevo = new NodoLista_Pasajeros(cedula, nombres, apellido, rh, telefono);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }

    }

    public String[] buscar(int busc) {

        String datos[] = new String[4];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay pasajeros registradas");
        }
        while (aux != null) {
            if (aux.Cedula == busc) {

                datos[0] = aux.Nombres;
                datos[1] = aux.Apellidos;
                datos[2] = aux.Telefono;
                datos[3] = aux.RH;
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El pasajero no se encuentra registrado");

        }
        return datos;
    }

    public void modificar(int busc, String nombres, String apellido, String rh, String telefono) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay pasajeros registrados");
        }
        while (aux != null) {
            if (aux.Cedula == busc) {
                aux.Nombres = nombres;
                aux.Apellidos = apellido;
                aux.Telefono = telefono;
                aux.RH = rh;
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro con exito");
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
        }
    }

    public void eliminar(int identificador) {

        aux = Primero;
        aux2 = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay pasjaeros registrados");

        }
        if (identificador == Primero.Cedula) {
            Primero = aux.sig;
            aux = null;
            JOptionPane.showMessageDialog(null, "Se ha eliminado el pasajero con cedula " + identificador);

        } else {

            aux = aux.sig;

            while (aux != null) {
                if (aux.Cedula == identificador) {
                    if (aux != ultimo) {
                        aux2.sig = aux.sig;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado el pasajero de manera exitosa");

                        break;
                    } else {
                        ultimo = aux2;
                        ultimo.sig = null;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado el pasajero de manera exitosa");

                        break;
                    }
                }
                aux = aux.sig;
                aux2 = aux2.sig;
            }
        }
    }

    public void cargar_datos() {
        try {
            String[] Datos_lista = null;
            FileReader leer_archivo = new FileReader("Pasajeros.txt");
            BufferedReader br = new BufferedReader(leer_archivo);
            Character separador = ';';
            String datos = "";
            File archivo = new File("Pasajeros.txt");

            if (archivo.exists() && archivo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            } else {
                while ((datos = br.readLine()) != null) {
                    Datos_lista = datos.split(String.valueOf(separador));
                    Integer cedula = Integer.parseInt(Datos_lista[0]);
                    String nombres = Datos_lista[1];
                    String apellido = Datos_lista[2];
                    String rh = Datos_lista[3];
                    String telefono = Datos_lista[4];

                    insertarcola(cedula, nombres, apellido, rh, telefono);
                }
                br.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No existen datos para iniciar sesion");
        }
    }

    public void guardar_datos() {
        try {
            FileWriter escribir_archivo = new FileWriter("Pasajeros.txt");
            BufferedWriter bw = new BufferedWriter(escribir_archivo);
            PrintWriter pw = new PrintWriter(bw);
            Character limite = ';';
            aux = Primero;
            while (aux != null) {
                pw.println(String.valueOf(aux.Cedula) + limite + aux.Nombres + limite + aux.Apellidos + limite + aux.Telefono + limite
                        + aux.RH + limite);
                aux = aux.sig;
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error intentelo nuevamente");
        }
    }

    public void despliegaLista() {
        String cad = "";
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "no hay datos en la lista");
        }

        while (aux != null) {

            cad = cad + "Cedula " + aux.Cedula + " \n| Nombre: " + aux.Nombres + " | Apellido: "
                    + aux.Apellidos + " \n| Telefono: " + aux.Telefono + " \n| RH: " + aux.RH
                    + "\n";
            aux = aux.sig;

        }
        JOptionPane.showMessageDialog(null, cad);

    }
}
