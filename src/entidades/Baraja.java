/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

public class Baraja {
    private final int CANTIDAD = 40;
    private int siguienteCarta;
    private List<Carta> cartas;

    public Baraja() {
        
    }

    public Baraja(List<Carta> cartas) {
        this.cartas = cartas;
        this.siguienteCarta = 0;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getSiguienteCarta() {
        return siguienteCarta;
    }

    public void setSiguienteCarta(int siguienteCarta) {
        this.siguienteCarta = siguienteCarta;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }
}
