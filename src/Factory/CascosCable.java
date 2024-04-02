/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author jairo
 */
public class CascosCable implements Cascos{
    private String color;
    private float precio;

    public CascosCable(String color, float precio) {
        this.color = color;
        this.precio = precio;
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
    
    @Override
    public float getPrecio(){
        return precio;
    }

    @Override
    public String toString() {
        return "Cascos con conexion por cable" + "\nColor: " + color + "\nPrecio:" + precio;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }//Si son del mismo tipo de perifericos y conexion y tienen el mismo color de devuelve true
        if (getClass() == obj.getClass() && color.equals(((RatonCable)obj).getColor())) {
            return true;
        }
        return false;
    }
}