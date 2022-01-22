/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Baraja;
import entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicioBaraja {
    private ServicioCarta servicioCarta = new ServicioCarta();
    
    public Baraja crearBaraja(){
        Baraja baraja;
        String []palos = {"Espada", "Basto", "Oro", "Copa"};
        List<Carta> barajaAux = new ArrayList();
        
        // Se crean las cartas y se guardan en la lista auxiliar
        for(int i = 0; i < palos.length; i++){ // Recorre el array de palos
            for(int j = 1; j <= 12; j++){ // Asigna el número a las cartas
                if(!(j == 8 || j == 9)){
                    barajaAux.add(servicioCarta.crearCarta(palos[i], j));
                }
            }
        }
        
        baraja = new Baraja(barajaAux);
        
        return baraja;
    }
    
    // Mezcla la baraja de cartas
    public void barajar(Baraja baraja){
        // El metodo shuffle permite mezclar aleatoriamente una lista
        // especificada por parametro
        Collections.shuffle(baraja.getCartas());
        baraja.setSiguienteCarta(0);
    }
    
    // Muestra la siguiente carta que está en la baraja
    public void siguienteCarta(Baraja baraja){
        int cartaActual = baraja.getSiguienteCarta();
        
        if(cartaActual < baraja.getCANTIDAD()){
            System.out.println(baraja.getCartas().get(cartaActual));
            baraja.setSiguienteCarta(cartaActual + 1);
            
        }else{
            System.out.println("No hay más cartas en la baraja");
        }
    }
    
    // Muestra el numero de cartas disponibles en la baraja
    public int cartasDisponibles(Baraja baraja){
        return baraja.getCANTIDAD() - baraja.getSiguienteCarta();
    }
    
    // Muestra la cantidad de cartas pedida
    public void darCartas(Baraja baraja, int cantidad){
        if(cantidad > baraja.getCANTIDAD()){
            System.out.println("No se pueden dar más de 40 cartas");
            
        }else if(baraja.getSiguienteCarta() + cantidad > baraja.getCANTIDAD()){
            System.out.println("No hay cartas suficientes en la baraja");   
            
        }else{
            for(int i = 0; i < cantidad; i++){
                System.out.println(baraja.getCartas().get(baraja.getSiguienteCarta()));
                baraja.setSiguienteCarta(baraja.getSiguienteCarta() + 1);
            }
        }
    }
    
    // Muestra las cartas restantes que hay en la baraja
    // Por ejemplo: si pide una carta y luego se muestra la baraja
    // no se debería de mostrar la carta que se pidió anteriormente
    public void mostrarCartas(Baraja baraja){
        if(baraja.getSiguienteCarta() >= baraja.getCANTIDAD()){
            System.out.println("No hay cartas que mostrar");
        }else{
            for(int i = baraja.getSiguienteCarta(); i < baraja.getCANTIDAD(); i++){
                System.out.println(baraja.getCartas().get(i));
            }
        }
    }
    
    // Muestra las cartas que ya salieron de la baraja
    public void cartasDelMonton(Baraja baraja){
        if(baraja.getSiguienteCarta() == 0){
            System.out.println("No ha salido ninguna carta de la baraja");
        }else{
            for(int i = baraja.getSiguienteCarta() - 1; i >= 0; i--){
                System.out.println(baraja.getCartas().get(i));
            }
        }
    }
}
