package Deber.Problema2;

import java.util.ArrayList;
import java.util.Scanner;

class Televisor {

    private String marca;
    private double precio;

    public void establecerMarca(String m) {
        marca = m;
    }

    public void establecerPrecio(double p) {
        precio = p;
    }

    public String obtenerMarca() {
        return marca;
    }

    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("TV:%s\n%s\n",
                obtenerMarca(),
                obtenerPrecio());
    }
}

class CalculadoraVentas {
    public double calcularPrecioTotal(ArrayList<Televisor> televisores) {
        double precioTotal = 0;
        for (Televisor televisor : televisores) {
            precioTotal += televisor.obtenerPrecio();
        }
        return precioTotal;
    }

    public double televisorMasCaro(ArrayList<Televisor> televisores) {
        double precioMasCaro = Double.MIN_VALUE;// Inicializa el precio más caro con el valor mínimo posible para un double
        for (Televisor televisor : televisores) {
            if (televisor.obtenerPrecio() > precioMasCaro) {
                precioMasCaro = televisor.obtenerPrecio();
            }
        }
        return precioMasCaro;
    }

    public String listaMarcasVendidas(ArrayList<Televisor> t){
        String s = "";
        for (int i = 0; i < t.size(); i++) {
            s = String.format("%s%s\n", s, t.get(i).obtenerMarca());
        }
        return s;
    }
}
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Televisor> tvs = new ArrayList<>();
        System.out.println("Ingrese número de televisores: ");
        int numTV = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numTV; i++) {
            System.out.println("Ingrese los datos del televisor " + i + ":");
            Televisor televisor = new Televisor();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            televisor.establecerMarca(marca);

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            televisor.establecerPrecio(precio);

            tvs.add(televisor);
            System.out.println();
        }

        CalculadoraVentas calculadora = new CalculadoraVentas();
        double precioTotal = calculadora.calcularPrecioTotal(tvs);
        System.out.println("Precio total de los televisores: " + precioTotal);

        double precioMasCaro = calculadora.televisorMasCaro(tvs);
        System.out.println("Precio del televisor más caro: " + precioMasCaro);

        String marcasVendidas = calculadora.listaMarcasVendidas(tvs);
        System.out.println("Marcas vendidas:\n" + marcasVendidas);

        scanner.close();
    }
}
