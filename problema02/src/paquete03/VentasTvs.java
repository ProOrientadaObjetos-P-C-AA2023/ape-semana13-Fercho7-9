/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.util.ArrayList;
import paquete01.Televisor;

/**
 *
 * @author reroes
 */
public class VentasTvs {
    double precioTotal;
    ArrayList<Televisor> televisores;
    String marcasVendidas;
    
    public void establecerTelevisores(ArrayList<Televisor> t){
        televisores = t;
    }
    
    public ArrayList<Televisor> obtenerTelevisores(){
        return televisores;
    }
    
    public void establecerPrecioTotal(){
        double s = 0;
        for (int i = 0; i < televisores.size(); i++) {
            s = s + televisores.get(i).obtenerPrecio();
            
        }
        precioTotal = s;
        
    }
    
    public double obtenerPrecioTotal(){
        return precioTotal;
    }
    
        
    public String obtenerMarcasVendidas(){
        return marcasVendidas;
    }
    
}
