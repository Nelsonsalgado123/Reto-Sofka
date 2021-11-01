/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto_sofka;

/**
 *
 * Nelson Livanier Salgado
 */
public class NodoListaJugadores {

    String NombreJugador;
    NodoListaJugadores Siguiente;

    public NodoListaJugadores(String NombreJugador) {
        this.NombreJugador = NombreJugador;
        Siguiente = this;
    }

}
