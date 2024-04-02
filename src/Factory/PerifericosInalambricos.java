/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author jairo
 */
public class PerifericosInalambricos implements PerifericosFactory{

    @Override
    public Raton createRaton(String color, float precio) {
        return new RatonInalambrico(color, precio);
    }

    @Override
    public Cascos createCasco(String color, float precio) {
        return new CascosInalambricos(color, precio);
    }
    
}
