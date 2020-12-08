package Listas_emple;

import Interfacez.Administrar_Vendedores;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

////clase que manipula a los punteros para manipular los nodos en la memoria
public class Lista_emple {

    NodoLista_emple Primero, ultimo, aux, nuevo, ant, post, aux2;

    public Lista_emple() {
        Primero = ultimo = aux = nuevo = ant = post = null;
    }

    public void insertarcola(int cedula, Object nombres, Object apellidos, Object telefono, Object user, Object Pwd, boolean admin) {
        if (Primero == null) {// si la lista esta vacia
            Primero = new NodoLista_emple(cedula, nombres, apellidos, telefono, user, Pwd, admin);
            ultimo = Primero;
        } else {////ya hay mas nodos en la lista
            nuevo = new NodoLista_emple(cedula, nombres, apellidos, telefono, user, Pwd, admin);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }

    }

    public int iniciar_sesion(String user, String password) {
        int inicia = 0;
        aux = Primero;

        while (aux != null) {
            if (aux.usuario.equals(user) && aux.contraseña.equals(password) && aux.admon == true) {

                inicia = 1;
                break;
            } else if (aux.usuario.equals(user) && aux.contraseña.equals(password) && aux.admon == false) {

                inicia = 2;
                break;
            }
            aux = aux.sig;
        }
        return inicia;
    }

    public String[] buscar(int busc) {
        Administrar_Vendedores adv = new Administrar_Vendedores();
        String datos[] = new String[5];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay vendedores registrados");
        }
        while (aux != null) {
            if (aux.Cedula == busc) {

                datos[0] = (String) aux.nombre;
                datos[1] = (String) aux.apellido;
                datos[2] = (String) aux.celular;
                datos[3] = (String) aux.usuario;
                datos[4] = String.valueOf(aux.admon);
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El vendedor no se encuentra registrado");
            adv.txtCedula.setText("");
        }
        return datos;
    }

    public void modificar(int busc, Object nombres, Object apellidos, Object telefono, Object user, Object Pwd, boolean admin) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
        }
        while (aux != null) {
            if (aux.Cedula == busc) {
                aux.nombre = nombres;
                aux.apellido = apellidos;
                aux.celular = telefono;
                aux.usuario = user;
                aux.contraseña = Pwd;
                aux.admon = admin;
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro con exito");
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        }
    }

    public void eliminar(int identificador) {

        aux = Primero;
        aux2 = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay vendedores registrados");

        }
        if (identificador == Primero.Cedula) {
            Primero = aux.sig;
            aux = null;
            JOptionPane.showMessageDialog(null, "Se ha eliminado el vendedor con cedula " + identificador);

        } else {

            aux = aux.sig;

            while (aux != null) {
                if (aux.Cedula == identificador) {
                    if (aux != ultimo) {
                        aux2.sig = aux.sig;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado el vendedor de manera exitosa");

                        break;
                    } else {
                        ultimo = aux2;
                        ultimo.sig = null;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha borrado el vendedor de manera exitosa");

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
            FileReader leer_archivo = new FileReader("Empleados.txt");
            BufferedReader br = new BufferedReader(leer_archivo);
            Character separador = ';';
            String datos = "";
            File archivo = new File("Empleados.txt");

            if (archivo.exists() && archivo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            } else {
                while ((datos = br.readLine()) != null) {
                    Datos_lista = datos.split(String.valueOf(separador));
                    Integer Cedula = Integer.parseInt(Datos_lista[0]);
                    String nombre = Datos_lista[1];
                    String apellido = Datos_lista[2];
                    String celular = Datos_lista[3];
                    String usuario = Datos_lista[4];
                    String contraseña = Datos_lista[5];
                    boolean administrador = Boolean.parseBoolean(Datos_lista[6]);
                    insertarcola(Cedula, nombre, apellido, celular, usuario, contraseña, administrador);
                }
                br.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No existen datos para iniciar sesion");
        }
    }

    public void guardar_datos() {
        try {
            FileWriter escribir_archivo = new FileWriter("Empleados.txt");
            BufferedWriter bw = new BufferedWriter(escribir_archivo);
            PrintWriter pw = new PrintWriter(bw);
            Character limite = ';';
            aux = Primero;
            while (aux != null) {
                pw.println(String.valueOf(aux.Cedula) + limite + aux.nombre + limite + aux.apellido + limite + aux.celular + limite
                        + aux.usuario + limite + aux.contraseña + limite + aux.admon);
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

            cad = cad + "identificacion " + aux.Cedula + " \n| nombre: " + aux.nombre + " |apellido: "
                    + aux.apellido + " \n| telefono: " + aux.celular + " \n| usuario: " + aux.usuario + " \n| contraseña: "
                    + aux.contraseña + "\n";
            aux = aux.sig;

        }
        JOptionPane.showMessageDialog(null, cad);

    }
}
