/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Carta;

public class ServicioCarta {
 
    public Carta crearCarta(String palo, int numero){
        Carta carta = carta = new Carta(numero, palo);
        
        return carta;
    }
}
