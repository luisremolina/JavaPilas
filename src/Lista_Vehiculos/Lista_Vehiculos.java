package Lista_Vehiculos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Lista_Vehiculos {

    NodoLista_Vehiculos Primero, ultimo, aux, nuevo, ant, post, aux2;

    public Lista_Vehiculos() {
        Primero = ultimo = aux = nuevo = ant = post = null;
    }

    public void insertarcola(int num, String placa, String conductor, String ruta, String hora, float precio, int pasajeros_max, int frecuencia, Object cpasa1, Object npasa1, Object cpasa2, Object npasa2, Object cpasa3, Object npasa3, Object cpasa4, Object npasa4, Object cpasa5, Object npasa5, Object cpasa6, Object npasa6, Object cpasa7, Object npasa7, Object cpasa8, Object npasa8, Object cpasa9, Object npasa9, Object cpasa10, Object npasa10) {
        if (Primero == null) {
            Primero = new NodoLista_Vehiculos(num, placa, conductor, ruta, hora, precio, pasajeros_max, frecuencia, cpasa1, npasa1, cpasa2, npasa2, cpasa3, npasa3, cpasa4, npasa4, cpasa5, npasa5, cpasa6, npasa6, cpasa7, npasa7, cpasa8, npasa8, cpasa9, npasa9, cpasa10, npasa10);
            ultimo = Primero;
        } else {
            nuevo = new NodoLista_Vehiculos(num, placa, conductor, ruta, hora, precio, pasajeros_max, frecuencia, cpasa1, npasa1, cpasa2, npasa2, cpasa3, npasa3, cpasa4, npasa4, cpasa5, npasa5, cpasa6, npasa6, cpasa7, npasa7, cpasa8, npasa8, cpasa9, npasa9, cpasa10, npasa10);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }

    }

    public String[] buscar(int busc) {

        String datos[] = new String[7];
        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados registradas");
        }
        while (aux != null) {
            if (aux.Numero_Vehi == busc) {
                datos[0] = aux.Placa;
                datos[1] = aux.Conductor;
                datos[2] = aux.Ruta;
                datos[3] = aux.Hora_Salida;
                datos[4] = String.valueOf(aux.Precio);
                datos[5] = String.valueOf(aux.Max_Pasajeros);
                datos[6] = String.valueOf(aux.Frecuencia);

                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra registrado");

        }
        return datos;
    }

    public void modificar(int busc, String ruta, String hora, int frecuencia, float precio) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay Vehiculos registrados");
        }
        while (aux != null) {
            if (aux.Numero_Vehi == busc) {
                aux.Ruta = ruta;
                aux.Precio = precio;
                aux.Frecuencia = frecuencia;
                aux.Hora_Salida = hora;

                JOptionPane.showMessageDialog(null, "Se ha modificado el vehiculo con exito");
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "El vehiculo no existe");
        }
    }

    /*public void vender(int num) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay Vehiculos registrados");
        }
        while (aux != null) {
            if (aux.Numero_Vehi == num) {

                
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La venta no se pudo realizar");
        }
    }

    public void eliminar_venta(int num) {

        aux = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay Vehiculos registrados");
        }
        while (aux != null) {
            if (aux.Numero_Vehi == num) {

                
                break;
            }
            aux = aux.sig;
        }
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La venta no existe");
        }
    }*/

    public void eliminar(int identificador) {

        aux = Primero;
        aux2 = Primero;
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");

        }
        if (identificador == Primero.Numero_Vehi) {
            Primero = aux.sig;
            aux = null;
            JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo numero: " + identificador + " correctamente ");

        } else {

            aux = aux.sig;

            while (aux != null) {
                if (aux.Numero_Vehi == identificador) {
                    if (aux != ultimo) {
                        aux2.sig = aux.sig;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo numero: " + identificador + " correctamente ");
                        break;
                    } else {
                        ultimo = aux2;
                        ultimo.sig = null;
                        aux = null;
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo numero: " + identificador + " correctamente ");
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
            FileReader leer_archivo = new FileReader("Vehiculos.txt");
            BufferedReader br = new BufferedReader(leer_archivo);
            Character separador = ';';
            String datos = "";
            File archivo = new File("Vehiculos.txt");

            if (archivo.exists() && archivo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            } else {
                while ((datos = br.readLine()) != null) {

                    Datos_lista = datos.split(String.valueOf(separador));

                    int num = Integer.parseInt(Datos_lista[0]);
                    String placa = Datos_lista[1];
                    String conductor = Datos_lista[2];
                    String ruta = Datos_lista[3];
                    String hora = Datos_lista[4];
                    float precio = Float.parseFloat(Datos_lista[5]);
                    int pasajeros_max = Integer.parseInt(Datos_lista[6]);
                    int frecuencia = Integer.parseInt(Datos_lista[7]);

                    Object Cpasa1 = Datos_lista[8];
                    Object Npasa1 = Datos_lista[9];

                    Object Cpasa2 = Datos_lista[10];
                    Object Npasa2 = Datos_lista[11];

                    Object Cpasa3 = Datos_lista[12];
                    Object Npasa3 = Datos_lista[13];

                    Object Cpasa4 = Datos_lista[14];
                    Object Npasa4 = Datos_lista[15];

                    Object Cpasa5 = Datos_lista[16];
                    Object Npasa5 = Datos_lista[17];

                    Object Cpasa6 = Datos_lista[18];
                    Object Npasa6 = Datos_lista[19];

                    Object Cpasa7 = Datos_lista[20];
                    Object Npasa7 = Datos_lista[21];

                    Object Cpasa8 = Datos_lista[22];
                    Object Npasa8 = Datos_lista[23];

                    Object Cpasa9 = Datos_lista[24];
                    Object Npasa9 = Datos_lista[25];

                    Object Cpasa10 = Datos_lista[26];
                    Object Npasa10 = Datos_lista[27];

                    insertarcola(num, placa, conductor, ruta, hora, precio, pasajeros_max, frecuencia, Cpasa1, Npasa1, Cpasa2, Npasa2, Cpasa3, Npasa3, Cpasa4, Npasa4, Cpasa5, Npasa5, Cpasa6, Npasa6, Cpasa7, Npasa7, Cpasa8, Npasa8, Cpasa9, Npasa9, Cpasa10, Npasa10);
                }
                br.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
        }
    }

    public void guardar_datos() {
        try {
            FileWriter escribir_archivo = new FileWriter("Vehiculos.txt");
            BufferedWriter bw = new BufferedWriter(escribir_archivo);
            PrintWriter pw = new PrintWriter(bw);
            Character limite = ';';
            aux = Primero;
            while (aux != null) {
                pw.println(String.valueOf(aux.Numero_Vehi) + limite + aux.Placa + limite + aux.Conductor + limite + aux.Ruta + limite
                        + aux.Hora_Salida + limite + aux.Precio + limite + aux.Max_Pasajeros + limite + aux.Frecuencia + limite
                        + aux.Cpasa1 + limite + aux.Npasa1 + limite + aux.Cpasa2 + limite + aux.Npasa2 + limite + aux.Cpasa3 + limite + aux.Npasa3 + limite + aux.Cpasa4 + limite + aux.Npasa4 + limite
                        + aux.Cpasa5 + limite + aux.Npasa5 + limite + aux.Cpasa6 + limite + aux.Npasa6 + limite + aux.Cpasa7 + limite
                        + aux.Npasa7 + limite + aux.Cpasa8 + limite + aux.Npasa8 + limite + aux.Cpasa9 + limite + aux.Npasa9 + limite
                        + aux.Cpasa10 + limite + aux.Npasa10 + limite);
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

            cad = cad + "\n - Numero de vehiculo: " + aux.Numero_Vehi + " \n| Placa: " + aux.Placa + "\n | Conductor: "
                    + aux.Conductor + " \n| Ruta: " + aux.Ruta + "\n| Precio: $" + aux.Precio + "\n| Pasajeros Maximos: " + aux.Max_Pasajeros
                    + "\n| Frecuencia: " + aux.Frecuencia + "\n| Hora de salida: " + aux.Hora_Salida;
            aux = aux.sig;

        }
        JOptionPane.showMessageDialog(null, cad);

    }

}
