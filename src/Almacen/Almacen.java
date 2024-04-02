/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Factory.Cascos;
import Factory.PerifericosCable;
import Factory.PerifericosFactory;
import Factory.PerifericosInalambricos;
import Factory.Raton;
import Ordenador.Ordenador;
import Ordenador.OrdenadorReserva;
import Ordenador.OrdenadorVenta;
import Ordenador.Strategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jairo
 */
public class Almacen implements iAlmacen{

    private List<Strategy> stock;
    private static Almacen instance;
    private PerifericosFactory factoryCable = new PerifericosCable();
    private PerifericosFactory factoryInalambrico = new PerifericosInalambricos();
    private List encargos;

    private Almacen() {
        stock = new ArrayList();
        encargos  = new ArrayList();
        Strategy o= new OrdenadorVenta("Laptop1", 3, 1000);
        Strategy o2= new OrdenadorVenta("Laptop2", 4, 1200);
        Strategy o3 = new OrdenadorReserva("Laptop3", 2, 1300);
        stock.add(o);
        stock.add(o2);
        stock.add(o3);
    }
    //Metodo para patron simpleton
    public static Almacen getInstance() {
        if(instance == null){
            instance = new Almacen();
        }
        return instance;
    }
    //Metodo para comprar ordenadores
    @Override
    public Strategy Comprar(String nombre, int cantidad) {
        Iterator<Strategy> it = Stock();
        Strategy encargo, pedido = null;
        boolean enc = false;
        while(enc == false && it.hasNext()){
            encargo = it.next();
            if(((Ordenador)encargo).getNombre().equals(nombre) && encargo.getStrategy().equals("Venta")){
                pedido = encargo.solicitar(cantidad);
                enc = true;
            }
        }
        return pedido;
    }
    //Metodo para reservar ordenadores
    @Override
    public Strategy Reservar(String nombre, int cantidad) {
        Iterator<Strategy> it = Stock();
        Strategy encargo, pedido = null;
        boolean enc = false;
        while(enc == false && it.hasNext()){
            encargo = it.next();
            if(((Ordenador)encargo).getNombre().equals(nombre) && encargo.getStrategy().equals("Reserva")){
                pedido = encargo.solicitar(cantidad);
                enc = true;
            }
        }
        return pedido;
        
    }
    //Metodo para mostrar stock
    @Override
    public Iterator Stock() {
        return stock.iterator();
    }
    //Metodo para encargar un periferico
    @Override
    public float encargar(int periferico, int tipo, String color) {
        float precio = 0;
        
        switch(periferico){
        //Si periferico es 1, el cliente quiere un raton
            case 1:
                switch(tipo){
                    //Si el tipo es 1, el periferico sera con cable
                    case 1:
                        Raton rc = factoryCable.createRaton(color, 42);
                        encargos.add(rc);
                        precio = rc.getPrecio();
                        
                        break;
                    //Si es 2 sera inalambrico
                    case 2:
                        Raton rcI = factoryInalambrico.createRaton(color, 45);
                        encargos.add(rcI);
                        precio = rcI.getPrecio();
                        break;
                    //Si es 0 el cliente quiere salir
                    case 0:
                        break;
                }
                break;
            //Si periferico es 2 se solicita unos cascos
            case 2:
                switch(tipo){
                    case 1:
                        Cascos cascos = factoryCable.createCasco(color, 100);
                        encargos.add(cascos);
                        precio = cascos.getPrecio();
                        break;
                    case 2:
                        Cascos cascosI = factoryInalambrico.createCasco(color, 115);
                        encargos.add(cascosI);
                        precio = cascosI.getPrecio();
                        break;
                    case 0:
                        break;
                }
                break;
            case 0:
                break;
        }
        //Si se realizo el pedido con exito, se añade a la lista de encargos
       
        return precio;
    }
    
}
