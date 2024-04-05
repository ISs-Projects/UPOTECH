/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Upotech;

import Ordenador.IOrdenador;
import Ordenador.Strategy;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author jairo
 */
class Pantalla {
      //comprar, reservar, encargar periferico

    private Scanner sc;
    Controladora c;

    public Pantalla() {
        sc = new Scanner(System.in);
        c = new Controladora();
    }

    public void comprarOrdenador() {
        boolean exit = false;
        int cantidad = -1;
        String nombre = "";
        while (!exit) {
            System.out.println("Introduce el nombre del Ordenador(SALIR para salir):");
            nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("SALIR")) {
                exit = true;
            }
            while (cantidad < 0 && !exit) {
                System.out.println("Introduce la cantidad de ordenadores(0 para salir):");
                cantidad = sc.nextInt();
                if (cantidad == 0) {
                    exit = true;
                    sc.nextLine();
                }
            }
            if (cantidad > 0 && nombre != "") {
                float total = c.comprarOrdenador(nombre, cantidad);
                sc.nextLine();
                if (total == -2) {
                    System.out.println("El ordenador introducido no existe o la cantidad no es suficiente");
                    cantidad = -1;
                } else {
                    System.out.println("La compra del ordenador " + nombre + " " + cantidad + " veces ha sido de " + total + "€.");
                    exit = true;
                }
            }

        }
    }

    public void reservarOrdenador() {
        boolean exit = false;
        int cantidad = -1;
        String nombre = "";
        while (!exit) {
            System.out.println("Introduce el nombre del Ordenador(SALIR para salir):");
            nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("SALIR")) {
                exit = true;
            }
            while (cantidad < 0 && !exit) {
                System.out.println("Introduce la cantidad de dias(0 para salir):");
                cantidad = sc.nextInt();
                if (cantidad == 0) {
                    exit = true;
                }
            }
            if (cantidad > 0) {
                sc.nextLine();
                float total = c.reservarOrdenador(nombre, cantidad);
                if (total == -2) {
                    System.out.println("El ordenador introducido no existe o la cantidad no es suficiente");
                    cantidad = -1;
                } else {
                    System.out.println("La reserva del ordenador " + nombre + " durante" + cantidad + " dias ha sido de " + total + "€.");
                    exit = true;
                }
            }

        }
    }

    public void encargarPeriferico() {
        boolean exit = false;
        int periferico = -1, tipo = -1;
        String color = "rojo";
        while (periferico == -1 && !exit) {
            System.out.println("Elige periférico( 1 Ratón, 2 Cascos, 0 Salida):");
            periferico = sc.nextInt();
            if (periferico > 2) {
                periferico = -1;
            } else if (periferico == 0) {
                exit = true;
            } else {
                while (!exit && tipo == -1) {
                    System.out.println("Introduce el tipo de periférico(1 Cableado, 2 Sin Cable, 0 Salida):");
                    tipo = sc.nextInt();
                    if (tipo == 0) {
                        exit = true;
                    } else if (tipo > 2) {
                        tipo = -1;
                    }
                }
            }
        }
        if (exit == false) {
            float total = c.encargarPeriferico(periferico, tipo, color);
            if (total == -2) {
                System.out.println("El periferico introducido no existe");
            } else {
                System.out.println("El encargo del periferico ha sido de " + total + "€.");
            }
        }

    }

    public void mostrarStock() {
        Iterator it = c.mostrarStock();
        Strategy o;
        System.out.println("**********************\nSTOCK DE ORDENADORES");
        /*while (it.hasNext()) {
            o = (Strategy) it.next();
            System.out.println(o);
        }*/
        while (it.hasNext()) {
            System.out.println("--------------");
            IOrdenador or = (IOrdenador) it.next();
            System.out.println(or);
        }
        System.out.println("**********************");
    }

}
