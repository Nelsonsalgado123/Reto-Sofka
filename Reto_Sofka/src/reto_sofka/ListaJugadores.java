package reto_sofka;

import javax.swing.JOptionPane;

/**
 *
 * Nelson Salgado Tejada
 */
public class ListaJugadores {

    NodoCodigo ultimo;
    NodoListaJugadores ultimo2;
    NodoPremios ultimo3;

    public ListaJugadores() {
        ultimo = null;
        ultimo2 = null;
        ultimo3 = null;
    }

    //metodo para saber cuando la lista esta vacia
    public boolean EstaVacia() {

        return ultimo == null;

    }
    //metodo para insertar Nodo

    public ListaJugadores insertar(String Nombre, int Posicion, int Premios) {

        NodoListaJugadores nuevo1 = new NodoListaJugadores(Nombre);
        NodoCodigo nuevo = new NodoCodigo(Posicion);
        NodoPremios nuevo2 = new NodoPremios(Premios);

        if (ultimo2 != null && ultimo != null && ultimo3 != null) {
            nuevo1.Siguiente = ultimo2.Siguiente;
            ultimo2.Siguiente = nuevo1;

            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;

            nuevo2.siguiente1 = ultimo3.siguiente1;
            ultimo3.siguiente1 = nuevo2;

        }
        ultimo = nuevo;
        ultimo2 = nuevo1;
        ultimo3 = nuevo2;
        return this;
    }

    //metodo para mostrar la lista
    public void MostrarLista() {

        NodoCodigo puntero = ultimo.siguiente;
        NodoListaJugadores puntero2 = ultimo2.Siguiente;
        NodoPremios puntero3 = ultimo3.siguiente1;

        String Cadena = "";
        do {
            Cadena = Cadena + "[" + puntero.dato + "]" + "               " + puntero2.NombreJugador
                    + "                       " + puntero3.Premio;
            puntero = puntero.siguiente;
            puntero2 = puntero2.Siguiente;
            puntero3 = puntero3.siguiente1;

            Cadena = Cadena + "\n";

        } while (puntero != ultimo.siguiente && puntero2 != ultimo2.Siguiente && puntero3 != ultimo3.siguiente1);
            JOptionPane.showMessageDialog(null, "Ingreso      Nombre                                        Premio\n\n\n" + Cadena + "  ", " HISTORIAL", JOptionPane.INFORMATION_MESSAGE);
    }

    //Metodo para eliminar un nodo de la lista circular
    public boolean Eliminar(int elemento) {
        NodoCodigo actual;
        boolean encontrado = false;
        actual = ultimo;
        while (actual.siguiente != ultimo && !encontrado) {
            encontrado = (actual.siguiente.dato == elemento);
            if (!encontrado) {
                actual = actual.siguiente;
            }
        }
        encontrado = (actual.siguiente.dato == elemento);
        if (encontrado) {
            NodoCodigo auxiliar = actual.siguiente;
            if (ultimo == ultimo.siguiente) {
                ultimo = null;
            } else {
                if (auxiliar == ultimo) {
                    ultimo = actual;
                }
                actual.siguiente = auxiliar.siguiente;
            }
            auxiliar = null;
        }
        return encontrado == true;
    }
    //Metodo para eliminar un nodo de la lista circular

    public boolean EliminarNombre(String elemento) {
        NodoListaJugadores actual;
        boolean encontrado = false;
        actual = ultimo2;
        String Cadena = "";
        
        while (actual.Siguiente != ultimo2 && !encontrado) {
            encontrado = (actual.Siguiente.NombreJugador.equalsIgnoreCase(elemento));
            if (!encontrado) {
                
                actual = actual.Siguiente;
            }
        }
        encontrado = (actual.Siguiente.NombreJugador.equalsIgnoreCase(elemento));
        if (encontrado) {
            NodoListaJugadores auxiliar = actual.Siguiente;
            if (ultimo == ultimo.siguiente) {
                ultimo = null;
            } else {
                if (auxiliar == ultimo2) {
                    ultimo2 = actual;
                }
                actual.Siguiente = auxiliar.Siguiente;
            }
            auxiliar = null;
        }
        if (encontrado == true) {
            JOptionPane.showMessageDialog(null, " el jugador  " + elemento + " Fue eliminado ", " Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El elemento  " + elemento + "  no fue Encontrado", " no fue encontrado", JOptionPane.ERROR_MESSAGE);
        }
        return encontrado == true;
    }

    public void BuscarJugador(String Juagador) {
        NodoListaJugadores puntero2;
        NodoCodigo puntero;
        NodoPremios puntero1;
        
        puntero2 = ultimo2;
        puntero = ultimo;
        puntero1 = ultimo3;
        
        boolean encontrado = false;
        String Cadena = "";
        do {

            if (puntero2.NombreJugador.equalsIgnoreCase(Juagador)) {
                Cadena = Cadena + "[" + puntero.dato + "]" + "           " + puntero2.NombreJugador
                    + "           " + puntero1.Premio;
                encontrado = true;

            }
            puntero2 = puntero2.Siguiente;
            puntero1 =puntero1.siguiente1;
            puntero = puntero.siguiente;

        } while (puntero2 != ultimo2 && encontrado != true);

        if (encontrado == true) {
            JOptionPane.showMessageDialog(null, " Ingreso    Nombre     Premio\n\n\n " + Cadena + "  ", " Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El elemento  " + Juagador + "  no fue Encontrado", " no fue encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
