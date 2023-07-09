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
public class PagoAguaPotable {
    public double calcularPago(String tipo){
        double pago = 0;
        if(tipo.equals("comercial")){
            double tarifaFija = 2.20;
            double metrosCubicosConsumo = 100.2;
            double costoConsumoCubicos = 0.2;
            pago = tarifaFija + (metrosCubicosConsumo * costoConsumoCubicos) + 15;
        }else{
            double tarifaFija = 2.20;
            double metrosCubicosConsumo = 100.2;
            double costoConsumoCubicos = 0.2;
            pago = tarifaFija + (metrosCubicosConsumo * costoConsumoCubicos);
        }
        
        return pago;
    }
}
