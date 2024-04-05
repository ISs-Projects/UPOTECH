/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Almacen;

import Ordenador.IOrdenador;
import java.util.List;

/**
 *
 * @author jairo
 */
public interface AlmacenStrategy {
    
    public float transacion(String nombre, int cantidad, List<IOrdenador> ordenadorRepository);
    
    default IOrdenador findOrdenador(String nombre, List<IOrdenador> ordenadorRepository) {
        IOrdenador ordenador = null;
        for(IOrdenador o: ordenadorRepository) {
            if(o.getNombre().equals(nombre)) {
                ordenador = o;
                break;
            }
        }
        if(ordenador != null) {
            ordenadorRepository.remove(ordenador);
        }
        return ordenador;
    }
}
