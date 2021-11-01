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
public class NodoCodigo {

    int dato;
    NodoCodigo siguiente;

    public NodoCodigo(int dato) {

        this.dato = dato;
        siguiente = this;

    }
}
