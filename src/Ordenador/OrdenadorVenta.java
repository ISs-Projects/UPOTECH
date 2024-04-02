/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenador;

/**
 *
 * @author jairo
 */
public class OrdenadorVenta implements Ordenador, Strategy {

    private String nombre;
    private int cantidad = 0;
    private int precio;

    public OrdenadorVenta(String nombre, int cantidad, int precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String Nombre) {
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

    public void aumentarCantidad() {
        cantidad++;
    }

    public void reducirCantidad(int cantidad) {
        this.cantidad = this.cantidad - cantidad;
    }

    //Este metodo devuelve un clon con la cantidad que representa los ordenadores que quiere el cliente
    @Override
    public Strategy solicitar(int cantidad) {
        if (cantidad > this.cantidad) {
            return null;
        } else {
            Strategy o = clone(cantidad);
            reducirCantidad(cantidad);
            return o;
        }
    }

    @Override
    public String getStrategy() {
        return "Venta";
    }

    public String toString() {
        return nombre + " \nCantidad en almacen: " + cantidad;
    }

    //Metodo que devuelve un clon y establece el patron prototype
    private Strategy clone(int cantidad) {
        Strategy o = new OrdenadorVenta(this.nombre, cantidad, this.precio);
        return o;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

}
