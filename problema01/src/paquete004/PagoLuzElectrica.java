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
public class PagoLuzElectrica {

    public double calcularPago() {
        double pago = 0;
        double tarifaBase = 10.20;
        double kilovatiosConsumidos = 80;
        double costoKilovatio = 0.5;
        String ciudad = "Loja";
        if (ciudad.equals("Loja")) {
            pago = tarifaBase + (kilovatiosConsumidos * costoKilovatio / 2);
        } else {
            pago = tarifaBase + (kilovatiosConsumidos * costoKilovatio);
        }

        return pago;
    }
}
