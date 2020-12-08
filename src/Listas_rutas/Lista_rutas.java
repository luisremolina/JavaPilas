package Listas_rutas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Lista_rutas {

    NodoLista_rutas Primero, ultimo, aux, nuevo, ant, post, aux2;

    public Lista_rutas() {
        Primero = ultimo = aux = nuevo = ant = post = null;
    }

    public void insertarcola(int id, String orige, String destin, double precio, int hora) {
        if (Primero == null) {// si la lista esta vacia
            Primero = new NodoLista_rutas(id, orige, destin, precio, hora);
            ultimo = Primero;
        } else {////ya hay mas nodos en la lista
            nuevo = new NodoLista_rutas(id, orige, destin, precio, hora);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }

    }

    public String[] buscar(int busc) {

        String datos[] = new String[4];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay rutas registradas");
        }
        while (aux != null) {
            if (aux.id_ruta == busc) {
                datos[0] = aux.Origen;
                datos[1] = aux.Destino;
                datos[2] = String.valueOf(aux.Precio);
                datos[3] = String.valueOf(aux.Horario);
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La ruta no se encuentra registrado");

        }
        return datos;
    }

    public void modificar(int busc, String orige, String destin, double precio, int minutos) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay rutas registrados");
        }
        while (aux != null) {
            if (aux.id_ruta == busc) {
                aux.Origen = orige;
                aux.Destino = destin;
                aux.Precio = precio;
                aux.Horario = minutos;
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro con exito");
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La ruta no existe");
        }
    }

    public void eliminar(int identificador) {

        aux = Primero;
        aux2 = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay rutas registradas");

        }
        if (identificador == Primero.id_ruta) {
            Primero = aux.sig;
            aux = null;
            JOptionPane.showMessageDialog(null, "Se ha eliminado la ruta con ID " + identificador);

        } else {

            aux = aux.sig;

            while (aux != null) {
                if (aux.id_ruta == identificador) {
                    if (aux != ultimo) {
                        aux2.sig = aux.sig;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado la ruta de manera exitosa");

                        break;
                    } else {
                        ultimo = aux2;
                        ultimo.sig = null;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado la ruta de manera exitosa");

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
            FileReader leer_archivo = new FileReader("Rutas.txt");
            BufferedReader br = new BufferedReader(leer_archivo);
            Character separador = ';';
            String datos = "";
            File archivo = new File("Rutas.txt");

            if (archivo.exists() && archivo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            } else {
                while ((datos = br.readLine()) != null) {
                    Datos_lista = datos.split(String.valueOf(separador));
                    Integer id_ruta = Integer.parseInt(Datos_lista[0]);
                    String origen = Datos_lista[1];
                    String destino = Datos_lista[2];
                    double precio = Double.parseDouble(Datos_lista[3]);
                    int horario = Integer.parseInt(Datos_lista[4]);

                    insertarcola(id_ruta, origen, destino, precio, horario);
                }
                br.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No existen rutas registradas");
        }
    }

    public void guardar_datos() {
        try {
            FileWriter escribir_archivo = new FileWriter("Rutas.txt");
            BufferedWriter bw = new BufferedWriter(escribir_archivo);
            PrintWriter pw = new PrintWriter(bw);
            Character limite = ';';
            aux = Primero;
            while (aux != null) {
                pw.println(String.valueOf(aux.id_ruta) + limite + aux.Origen + limite + aux.Destino + limite + aux.Precio + limite
                        + aux.Horario);
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
            JOptionPane.showMessageDialog(null, "No existen rutas registradas");
        }

        while (aux != null) {

            cad = cad + "id de la ruta " + aux.id_ruta + " \n| origen: " + aux.Origen + " |destino: "
                    + aux.Destino + " \n| Precio: " + aux.Precio + " \n| Horario: " + aux.Horario + " minutos"
                    + "\n";
            aux = aux.sig;

        }
        JOptionPane.showMessageDialog(null, cad);

    }
}
