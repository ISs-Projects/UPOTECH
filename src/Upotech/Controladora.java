/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Upotech;

import Almacen.Almacen;
import Almacen.iAlmacen;
import Ordenador.Ordenador;
import Ordenador.OrdenadorReserva;
import Ordenador.Strategy;
import java.util.Iterator;

/**
 *
 * @author jairo
 */
class Controladora {
    
    //comprar, reservar, encargar periferico
    private iAlmacen almacen;

    public Controladora() {
        almacen = Almacen.getInstance(); // creamos el almacén
    }

    public float comprarOrdenador(String nombre, int cantidad) {
        float total = 0;

        Strategy pedido = almacen.Comprar(nombre, cantidad);
        if (pedido != null) {
            Ordenador ordenador = (Ordenador) pedido;
            total += ordenador.getCantidad() * ordenador.getPrecio();
        } else {
            total = -2;
        }

        return total;
    }

    float reservarOrdenador(String nombre, int cantidad) { // cantidad de dias de reserva
        Strategy reserva = almacen.Reservar(nombre, cantidad);
        float total = 0;

        if (reserva != null) {
            Ordenador ordenador = (Ordenador) reserva;
            ((OrdenadorReserva) ordenador).setDias(cantidad);
            total += cantidad * (ordenador.getPrecio() / 15);
        } else {
            total = -2;
        }

        return total;

    }

    float encargarPeriferico(int periferico, int tipo, String color) {
        float encargo = almacen.encargar(periferico, tipo, color);

        return encargo;
    }

    Iterator mostrarStock() {
        return almacen.Stock();
    }
}
