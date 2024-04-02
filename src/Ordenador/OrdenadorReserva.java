/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenador;

/**
 *
 * @author jairo
 */
public class OrdenadorReserva implements Ordenador, Strategy {

    private String nombre;
    private int cantidad = 0;
    private int precio;
    private int dias;

    public OrdenadorReserva(String nombre, int cantidad, int precio) {
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

    public void reducirCantidad(int cantidad) {
        this.cantidad = this.cantidad - cantidad;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    @Override
    public Strategy solicitar(int dias) {
        Strategy o = clone(dias);
        reducirCantidad(1);
        return o;
    }

    @Override
    public String getStrategy() {
        return "Reserva";
    }

    public String toString() {
        return nombre + " \nOrdenador Reserva\nCantidad: " + cantidad + "\nPrecio:" + precio;
    }

    //Metodo que devuelve un clon y establece el patron prototype
    private Strategy clone(int dias) {
        Strategy o = new OrdenadorReserva(this.nombre, 1, this.precio);
        ((OrdenadorReserva) o).setDias(dias);
        return o;
    }
}
