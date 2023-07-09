/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Televisor {

    private String marca;
    private double precio;
    
    public void establecerMarca(String m){
        marca = m;
    }
    
    public void establecerPrecio(double m){
        precio = m;
    }
    
    public String obtenerMarca(){
        return marca;
    }
    
    public double obtenerPrecio(){
        return precio;
    }
    
    public double totalPrecioTvs(ArrayList<Televisor> t){
        double s = 0;
        for (int i = 0; i < t.size(); i++) {
            s = s + t.get(i).obtenerPrecio();
            
        }
        return s;
    }
    
    public double televisorMasCaro(ArrayList<Televisor> t){
        double s = 0;
        // pass
        return s;
    }
    
    public String listaMarcasVendidas(ArrayList<Televisor> t){
        String s = "";
        for (int i = 0; i < t.size(); i++) {
            s = String.format("%s%s\n", s, t.get(i).obtenerMarca());
        }
        return s;
    }
    
    @Override
    public String toString(){
        return String.format("TV:%s\n%s\n",
                obtenerMarca(),
                obtenerPrecio());
    }
    
    
}
