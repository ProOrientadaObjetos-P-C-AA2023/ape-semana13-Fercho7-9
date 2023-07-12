package Deber.Problema3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Matricula {
    protected double tarifa;


    public double obtenerTarifa() {
        return tarifa;
    }

    public abstract void calcularTarifa();
}

class MatriculaCampamento extends Matricula {
    public double costotransporte;
    public double costocomida;
    public double costoinstructores;

    public MatriculaCampamento(double costotransporte, double costocomida, double costoinstructores) {
        super();
        this.costotransporte = costotransporte;
        this.costocomida = costocomida;
        this.costoinstructores = costoinstructores;
        calcularTarifa();
    }

    @Override
    public void calcularTarifa() {
        tarifa = costotransporte + costocomida + costoinstructores;
    }
}

class MatriculaColegio extends Matricula {
    public double costodeportes;
    public double costofolletos;
    public double  costouniformes;
    public double costolaboratorios;

    public MatriculaColegio(double costodeportes, double costofolletos, double costouniformes, double costolaboratorios) {
        super();
        this.costodeportes = costodeportes;
        this.costofolletos = costofolletos;
        this.costouniformes = costouniformes;
        this.costolaboratorios = costolaboratorios;
        calcularTarifa();
    }

    @Override
    public void calcularTarifa() {
        tarifa = costodeportes + costofolletos + costouniformes + costolaboratorios;
    }
}

class MatriculaEscuela extends Matricula {
    public double costolibros;
    public double costodeportes;
    public double costofolletos;
    public double costouniformes;

    public MatriculaEscuela(double costolibros, double costodeportes, double costofolletos, double costouniformes) {
        super();
        this.costolibros = costolibros;
        this.costodeportes = costodeportes;
        this.costofolletos = costofolletos;
        this.costouniformes = costouniformes;
        calcularTarifa();
    }

    @Override
    public void calcularTarifa() {
        tarifa = costolibros + costodeportes + costofolletos + costouniformes;
    }
}

class MatriculaJardin extends Matricula {
    public double costodesayunos;
    public double costolibros;
    public double costopaseos;

    public MatriculaJardin(double costodesayunos, double costolibros, double costopaseos) {
        super();
        this.costodesayunos = costodesayunos;
        this.costolibros = costolibros;
        this.costopaseos = costopaseos;
        calcularTarifa();
    }

    @Override
    public void calcularTarifa() {
        tarifa = costodesayunos + costolibros + costopaseos;
    }
}

class MatriculaMaternal extends Matricula {
    public double costodesayunos;
    public double costoalmuerzo;
    public double costomedico;

    public MatriculaMaternal(double costodesayunos, double costoalmuerzo, double costomedico) {
        super();
        this.costodesayunos = costodesayunos;
        this.costoalmuerzo = costoalmuerzo;
        this.costomedico = costomedico;
        calcularTarifa();
    }

    @Override
    public void calcularTarifa() {
        tarifa = costodesayunos + costoalmuerzo + costomedico;
    }
}

class TipoMatricula {
    private double promedioMatriculas;
    private List<Matricula> matriculas;

    public TipoMatricula() {
        matriculas = new ArrayList<>();
    }

    public void agregarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public double getPromedioMatriculas() {
        return promedioMatriculas;
    }

    public void calcularPromedioTarifas() {
        double sumaTarifas = 0;
        for (Matricula matricula : matriculas) {
            sumaTarifas += matricula.obtenerTarifa();
        }
        promedioMatriculas = sumaTarifas / matriculas.size();
    }
}

public class Principal {
    public static void main(String[] args) {
        TipoMatricula tipos = new TipoMatricula();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos de la Matricula Campamento:");
        System.out.print("Costo de transporte: ");
        double costoTransporte = scanner.nextDouble();
        System.out.print("Costo de comida: ");
        double costoComida = scanner.nextDouble();
        System.out.print("Costo de instructores: ");
        double costoInstructores = scanner.nextDouble();

        MatriculaCampamento mcamp = new MatriculaCampamento(costoTransporte, costoComida, costoInstructores);

        System.out.println("Ingrese los datos de la Matricula Colegio:");
        System.out.print("Costo de deportes: ");
        double costoDeportes = scanner.nextDouble();
        System.out.print("Costo de folletos: ");
        double costoFolletos = scanner.nextDouble();
        System.out.print("Costo de uniformes: ");
        double costoUniformes = scanner.nextDouble();
        System.out.print("Costo de laboratorios: ");
        double costoLaboratorios = scanner.nextDouble();

        MatriculaColegio mcolegio = new MatriculaColegio(costoDeportes, costoFolletos, costoUniformes, costoLaboratorios);

        // Repite el proceso para las otras matriculas

        tipos.agregarMatricula(mcamp);
        tipos.agregarMatricula(mcolegio);
        // Agrega las otras matriculas

        tipos.calcularPromedioTarifas();
        System.out.printf("Promedio de tarifas: %.2f\n", tipos.getPromedioMatriculas());

        scanner.close();
    }
}
