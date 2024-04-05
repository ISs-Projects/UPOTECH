/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Ordenador.IOrdenador;
import java.util.List;

/**
 *
 * @author mamisho
 */
public class AlmacenVentaStrategy implements AlmacenStrategy {

    @Override
    public float transacion(String nombre, int cantidad, List<IOrdenador> ordenadorRepository) {
        IOrdenador ordenadorEncontrado = this.findOrdenador(nombre, ordenadorRepository);
        float total = 0;
        if(ordenadorEncontrado != null) {
            total += cantidad * ordenadorEncontrado.getPrecio();
            ordenadorRepository.remove(ordenadorEncontrado);
            ordenadorEncontrado.setCantidad(ordenadorEncontrado.getCantidad() - cantidad);
            ordenadorRepository.add(ordenadorEncontrado);
        }
        return total;
    }

    
}
