/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Almacen;

import Ordenador.Strategy;
import java.util.Iterator;

/**
 *
 * @author jairo
 */
public interface iAlmacen {
    public Strategy Comprar(String nombre, int cantidad);
    public Strategy Reservar(String nombre, int cantidad);
    public Iterator Stock();
    public float encargar(int periferico, int tipo, String color);
}
