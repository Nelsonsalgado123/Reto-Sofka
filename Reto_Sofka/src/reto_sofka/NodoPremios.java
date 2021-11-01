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
//creamos un nodo circular simple para ingresar datos de tipo entero
public class NodoPremios {

    int Premio;
    NodoPremios siguiente1;

    public NodoPremios(int Premio) {

        this.Premio = Premio;
        siguiente1 = this;

    }
}
