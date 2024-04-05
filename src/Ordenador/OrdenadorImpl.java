/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenador;

/**
 *
 * @author mamisho
 */
public class OrdenadorImpl implements IOrdenador {
    
    private String nombre;
    private int cantidad = 0;
    private float precio;
    
    public OrdenadorImpl(String nombre, int cantidad, float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " \nOrdenador \nCantidad: " + cantidad + "\nPrecio:" + precio;
    }
    
    
}
