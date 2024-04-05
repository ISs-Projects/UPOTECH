/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Upotech;

import Almacen.Almacen;
import Almacen.AlmacenContext;
import Almacen.AlmacenReservaStrategy;
import Almacen.AlmacenStrategy;
import Almacen.AlmacenVentaStrategy;
import Almacen.iAlmacen;
import java.util.Iterator;

/**
 *
 * @author jairo
 */
class Controladora {
    
    //comprar, reservar, encargar periferico
    private iAlmacen almacen;
    private AlmacenContext almacenContext;

    public Controladora() {
        almacen = Almacen.getInstance(); // creamos el almacén
        almacenContext = AlmacenContext.getInstance();
    }

    public float comprarOrdenador(String nombre, int cantidad) {
        /*float total = 0;

        Strategy pedido = almacen.Comprar(nombre, cantidad);
        if (pedido != null) {
            Ordenador ordenador = (Ordenador) pedido;
            total += ordenador.getCantidad() * ordenador.getPrecio();
        } else {
            total = -2;
        }

        return total;*/
        AlmacenStrategy strategy = new  AlmacenVentaStrategy();
        almacenContext.setStrategy(strategy);
        return almacenContext.hacerTransaccion(nombre, cantidad);
    }

    float reservarOrdenador(String nombre, int cantidad) { // cantidad de dias de reserva
        /*Strategy reserva = almacen.Reservar(nombre, cantidad);
        float total = 0;

        if (reserva != null) {
            Ordenador ordenador = (Ordenador) reserva;
            ((OrdenadorReserva) ordenador).setDias(cantidad);
            total += cantidad * (ordenador.getPrecio() / 15);
        } else {
            total = -2;
        }

        return total;
        */
        AlmacenStrategy strategy = new  AlmacenReservaStrategy();
        almacenContext.setStrategy(strategy);
        return almacenContext.hacerTransaccion(nombre, cantidad);
    }

    float encargarPeriferico(int periferico, int tipo, String color) {
        float encargo = almacen.encargar(periferico, tipo, color);

        return encargo;
    }

    Iterator mostrarStock() {
        // return almacen.Stock();
        return almacenContext.repository();
    }
}
