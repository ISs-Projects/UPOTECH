/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Factory;

/**
 *
 * @author jairo
 */
public interface PerifericosFactory {
    public Raton createRaton(String color, float precio);
    public Cascos createCasco(String color, float precio);
}
