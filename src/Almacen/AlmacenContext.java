/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Ordenador.IOrdenador;
import Ordenador.OrdenadorImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jairo
 */
public class AlmacenContext {

    private List<IOrdenador> ordenadorRepository;
    private static AlmacenContext instance;
    private AlmacenStrategy strategy;

    private AlmacenContext() {
        this.populateRepository();
    }
    //Metodo para patron simpleton
    public static AlmacenContext getInstance() {
        if(instance == null){
            instance = new AlmacenContext();
        }
        return instance;
    }
    
    public float hacerTransaccion(String nombre, int cantidad) {
        return this.strategy.transacion(nombre, cantidad, ordenadorRepository);
    }
    
    public void setStrategy(AlmacenStrategy strategy) {
        this.strategy = strategy;
    }
    
    private void populateRepository() {
        this.ordenadorRepository = new ArrayList<IOrdenador>();
        OrdenadorImpl o1 = new OrdenadorImpl("HP", 5, 2000);
        OrdenadorImpl o2 = new OrdenadorImpl("Dell", 3, 1000);
        OrdenadorImpl o3 = new OrdenadorImpl("Apple", 4, 5000);
        ordenadorRepository.add(o2);
        ordenadorRepository.add(o1);
        ordenadorRepository.add(o3);
    }
    
    public Iterator repository() {
        return this.ordenadorRepository.iterator();
    }
    
}
