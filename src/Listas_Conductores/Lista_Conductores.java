/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas_Conductores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Lista_Conductores {

    NodoLista_Conductores Primero, ultimo, aux, nuevo, ant, post, aux2;

    public Lista_Conductores() {
        Primero = ultimo = aux = nuevo = ant = post = null;
    }

    public void insertarcola(int cedula, String nombre, String apellido, String telc, String RH, String placa, int Vehiculo_num) {
        if (Primero == null) {// si la lista esta vacia
            Primero = new NodoLista_Conductores(cedula, nombre, apellido, telc, RH, placa, Vehiculo_num);
            ultimo = Primero;
        } else {////ya hay mas nodos en la lista
            nuevo = new NodoLista_Conductores(cedula, nombre, apellido, telc, RH, placa, Vehiculo_num);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }

    }

    public String[] buscar(int busc) {

        String datos[] = new String[6];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay conductores registrados");
        }
        while (aux != null) {
            if (aux.Cedula == busc) {
                datos[0] = aux.Nombre;
                datos[1] = aux.Apellido;
                datos[2] = aux.Telefono;
                datos[3] = aux.Tipo_RH;
                datos[4] = aux.Placa;
                datos[5] = String.valueOf(aux.Numero_Vehiculo);

                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El conductor no se encuentra registrado");

        }
        return datos;
    }

    public String[] buscar_num(int busc) {

        String datos[] = new String[6];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay conductores registrados");
        }
        while (aux != null) {
            if (aux.Numero_Vehiculo == busc) {
                datos[0] = aux.Nombre;
                datos[1] = aux.Apellido;
                datos[2] = aux.Telefono;
                datos[3] = aux.Tipo_RH;
                datos[4] = aux.Placa;
                datos[5] = String.valueOf(aux.Numero_Vehiculo);

                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El conductor no se encuentra registrado");

        }
        return datos;
    }

    public void modificar(int busc, String nombre, String apellido, String telc, String RH, String placa, int Vehiculo_num) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay conductores registrados");
        }
        while (aux != null) {
            if (aux.Cedula == busc) {
                aux.Nombre = nombre;
                aux.Apellido = apellido;
                aux.Telefono = telc;
                aux.Tipo_RH = RH;
                aux.Placa = placa;
                aux.Numero_Vehiculo = Vehiculo_num;
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro con exito");
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El conductor no esta registrado");
        }
    }

    public void eliminar(int identificador) {

        aux = Primero;
        aux2 = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay conductores registrados");

        }
        if (identificador == Primero.Cedula) {
            Primero = aux.sig;
            aux = null;
            JOptionPane.showMessageDialog(null, "Se ha eliminado el conductor con cedula " + identificador);

        } else {

            aux = aux.sig;

            while (aux != null) {
                if (aux.Cedula == identificador) {
                    if (aux != ultimo) {
                        aux2.sig = aux.sig;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado el conductor de manera exitosa");

                        break;
                    } else {
                        ultimo = aux2;
                        ultimo.sig = null;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado el conductor de manera exitosa");

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
            FileReader leer_archivo = new FileReader("Conductores.txt");
            BufferedReader br = new BufferedReader(leer_archivo);
            Character separador = ';';
            String datos = "";
            File archivo = new File("Conductores.txt");

            if (archivo.exists() && archivo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            } else {
                while ((datos = br.readLine()) != null) {
                    Datos_lista = datos.split(String.valueOf(separador));
                    Integer cedula = Integer.parseInt(Datos_lista[0]);
                    String nombre = Datos_lista[1];
                    String apellido = Datos_lista[2];
                    String telc = Datos_lista[3];
                    String RH = Datos_lista[4];
                    String placa = Datos_lista[5];
                    int Vehiculo_num = Integer.parseInt(Datos_lista[6]);

                    insertarcola(cedula, nombre, apellido, telc, RH, placa, Vehiculo_num);
                }
                br.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No existen datos para iniciar sesion");
        }
    }

    public void guardar_datos() {
        try {
            FileWriter escribir_archivo = new FileWriter("Conductores.txt");
            BufferedWriter bw = new BufferedWriter(escribir_archivo);
            PrintWriter pw = new PrintWriter(bw);
            Character limite = ';';
            aux = Primero;
            while (aux != null) {
                pw.println(String.valueOf(aux.Cedula) + limite + aux.Nombre + limite + aux.Apellido + limite + aux.Telefono + limite
                        + aux.Tipo_RH + limite + aux.Placa + limite + aux.Numero_Vehiculo);
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

            cad = cad + "Cedula del conductor: " + aux.Cedula + " \n| Nombre: " + aux.Nombre + " \n | Apellido: "
                    + aux.Apellido + " \n| Telefono: " + aux.Telefono + " \n| RH: " + aux.Tipo_RH + " \n| Placa"
                    + aux.Placa + "\n| Numero de vehiculo: " + aux.Numero_Vehiculo + "\n";
            aux = aux.sig;

        }
        JOptionPane.showMessageDialog(null, cad);

    }
}
