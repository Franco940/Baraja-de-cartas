/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraja.de.cartas;

import entidades.Baraja;
import java.util.Scanner;
import servicios.ServicioBaraja;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ServicioBaraja servicioBaraja = new ServicioBaraja();
        Baraja baraja = servicioBaraja.crearBaraja();
        boolean fin = true; // Cuando fin sea falso el programa finaliza
        int opcion, cantidadDeCartas;
        
        System.out.println("\nEn la baraja hay 40 cartas");
        System.out.println("Los números de las cartas van del 1 al 12 (el 8 y el 9 NO estan incluidos)");
        System.out.println("Con los palos: espada, basto, oro y espada");
        
        menu();
        
        while(fin){
            System.out.print("\nOpcion (7 para ver el menu): ");
            opcion = input.nextInt();
            switch(opcion){
                case 1:
                    servicioBaraja.barajar(baraja);
                    System.out.println("\n### Cartas mezcladas ###");
                    break;
                    
                case 2:
                    System.out.println("Siguiente carta de la baraja:");
                    servicioBaraja.siguienteCarta(baraja);
                    break;
                    
                case 3:
                    System.out.println("Cartas restantes: " + servicioBaraja.cartasDisponibles(baraja));
                    break;
                    
                case 4:
                    System.out.println("¿Cuántas cartas desea dar?");
                    cantidadDeCartas = input.nextInt();
                    System.out.println("Cartas entregadas:");
                    servicioBaraja.darCartas(baraja, cantidadDeCartas);
                    break;
                    
                case 5:
                    System.out.println("Mostrando cartas del montón");
                    servicioBaraja.cartasDelMonton(baraja);
                    break;
                    
                case 6:
                    System.out.println("Mostrando cartas:");
                    servicioBaraja.mostrarCartas(baraja);
                    break;
                    
                case 7:
                    menu();
                    break;
                    
                case 8:
                    System.out.println("\n\nFinalizando programa...\n¡Qué tenga un buen día!");
                    fin = false;
                    break;
                
                default:
                    System.out.println("Opción invalida. Intente nuevamente");
            }
        }
    }
    
    private static void menu(){
        System.out.println("\n\n¿Qué opción desea realizar?\nDigite el numero que corresponda:\n"
        + "1.Barajar mazo (resetea la baraja)\n2.Siguiente carta\n3.Saber la cantidad de cartas disponibles\n4.Dar cartas\n"
        + "5.Ver las cartas del montón\n6.Mostrar baraja\n7.Ver el menú nuevamente\n8.Salir");
    }
}
