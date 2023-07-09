/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete004;

import paquete001.Persona;

/**
 *
 * @author reroes
 */
public class PagoTelefonoConvencional {
    
    public double calcularPago(){
        double tarifa = 6.20;
        double minutosConsumidos = 100;
        double costoMinuto = 0.2;
        double pago = tarifa + (minutosConsumidos * costoMinuto);
        return pago;
    }
}
