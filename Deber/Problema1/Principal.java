package Deber.Problema1;
import java.util.ArrayList;
import java.util.List;

abstract class Pago {
    protected double pago;

    public abstract void calcularPago();

    public double getPago() {
        return pago;
    }
}

class PagoAguaPotable extends Pago {
    String tipo;
    double tarifaFija;
    double metrosCubicosConsumo;
    double costoConsumoCubicos;

    public PagoAguaPotable(String tipo, double tarifaFija, double metrosCubicosConsumo, double costoConsumoCubicos) {
        this.tipo = tipo;
        this.tarifaFija = tarifaFija;
        this.metrosCubicosConsumo = metrosCubicosConsumo;
        this.costoConsumoCubicos = costoConsumoCubicos;
    }

    public void calcularPago() {
        if (tipo.equals("CASA")) {
            pago = tarifaFija + (metrosCubicosConsumo * costoConsumoCubicos);
        } else if (tipo.equals("COMERCIAL")) {
            pago = tarifaFija + (metrosCubicosConsumo * costoConsumoCubicos) + 15;
        }
    }

    @Override
    public String toString() {
        return "PagoAguaPotable{" +
                "tipo='" + tipo + '\'' +
                ", tarifaFija=" + tarifaFija +
                ", metrosCubicosConsumo=" + metrosCubicosConsumo +
                ", costoConsumoCubicos=" + costoConsumoCubicos +
                ", pago=" + pago +
                '}';
    }
}

class PagoLuzElectrica extends Pago {
    Ciudad ciudad;
    double tarifaBase;
    double kilovatiosConsumidos;
    double costoKilovatio;

    public PagoLuzElectrica(Ciudad ciudad, double tarifaBase, double kilovatiosConsumidos, double costoKilovatio) {
        this.ciudad = ciudad;
        this.tarifaBase = tarifaBase;
        this.kilovatiosConsumidos = kilovatiosConsumidos;
        this.costoKilovatio = costoKilovatio;
    }

    public void calcularPago() {
        if (ciudad.nombreCiudad.equals("LOJA")) {
            pago = tarifaBase + (kilovatiosConsumidos * costoKilovatio / 2);
        } else {
            pago = tarifaBase + (kilovatiosConsumidos * costoKilovatio);
        }
    }

    @Override
    public String toString() {
        return "PagoLuzElectrica{" +
                "ciudad=" + ciudad +
                ", tarifaBase=" + tarifaBase +
                ", kilovatiosConsumidos=" + kilovatiosConsumidos +
                ", costoKilovatio=" + costoKilovatio +
                ", pago=" + pago +
                '}';
    }
}

class PagoPredial extends Pago {
    double valorPropiedad;
    double porcentaje;

    public PagoPredial(double valorPropiedad, double porcentaje) {
        this.valorPropiedad = valorPropiedad;
        this.porcentaje = porcentaje;
    }

    public void calcularPago() {
        pago = valorPropiedad - ((valorPropiedad * porcentaje) / 100);
    }

    @Override
    public String toString() {
        return "PagoPredial{" +
                "valorPropiedad=" + valorPropiedad +
                ", porcentaje=" + porcentaje +
                ", pago=" + pago +
                '}';
    }
}

class PagoTelefonoConvencional extends Pago {
    double tarifa;
    double minutosConsumidos;
    double costoMinuto;

    public PagoTelefonoConvencional(double tarifa, double minutosConsumidos, double costoMinuto) {
        this.tarifa = tarifa;
        this.minutosConsumidos = minutosConsumidos;
        this.costoMinuto = costoMinuto;
    }

    public void calcularPago() {
        pago = tarifa + (minutosConsumidos * costoMinuto);
    }

    @Override
    public String toString() {
        return "PagoTelefonoConvencional{" +
                "tarifa=" + tarifa +
                ", minutosConsumidos=" + minutosConsumidos +
                ", costoMinuto=" + costoMinuto +
                '}';
    }
}

class Ciudad {
    String nombreCiudad;

    public Ciudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    @Override
    public String toString() {
        return "Ciudad{" +
                "nombreCiudad='" + nombreCiudad + '\'' +
                '}';
    }
}

class Persona {
    String nombre;
    String apellido;
    int edad;
    String cedula;
    Ciudad ciudad;

    public Persona(String nombre, String apellido, int edad, String cedula, Ciudad ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.ciudad = ciudad;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", cedula='" + cedula + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }
}

class BilleteraPagos {
    private Persona persona;
    private double gastoPagos;
    private String mes;
    private List<Pago> pagos;

    public BilleteraPagos(Persona persona, String mes, List<Pago> pagos) {
        this.persona = persona;
        this.mes = mes;
        this.pagos = pagos;
    }

    public void calcularGastoPagos() {
        for (Pago pago : pagos) {
            pago.calcularPago();
            gastoPagos += pago.getPago();
        }
    }

    @Override
    public String toString() {
        return "BilleteraPagos{" +
                "persona=" + persona +
                ", gastoPagos=" + gastoPagos +
                ", mes='" + mes + '\'' +
                ", pagos=" + pagos +
                '}';
    }
}

class DatosAgua {
    public double[][] datosCasas() {
        double[][] informacionCasaAgua = {
                {1.20, 80.2, 0.3},
                {1.30, 90.2, 0.4},
                // Agregar más datos si es necesario
        };
        return informacionCasaAgua;
    }

    public double[][] datosComerciales() {
        double[][] informacionComercialAgua = {
                {2.20, 100.2, 0.2},
                {2.30, 110.2, 0.3},
                // Agregar más datos si es necesario
        };
        return informacionComercialAgua;
    }
}

class DatosLuz {
    public double[][] datosLoja() {
        double[][] informacionLuzCasa = {
                {12.0, 100.2, 0.2},
                {12.1, 110.2, 0.3},
                // Agregar más datos si es necesario
        };
        return informacionLuzCasa;
    }

    public double[][] datosGeneral() {
        double[][] informacionLuzComercio = {
                {11.0, 80.2, 0.3},
                {11.1, 90.2, 0.4},
                // Agregar más datos si es necesario
        };
        return informacionLuzComercio;
    }
}

class DatosPropiedades {
    public double[][] datos() {
        double[][] informacionPropiedades = {
                {150000, 10},
                {200000, 15},
                // Agregar más datos si es necesario
        };
        return informacionPropiedades;
    }
}

class DatosTelefono {
    public double[][] datos() {
        double[][] informacionTelefono = {
                {6.0, 200.2, 0.2},
                {6.1, 210.2, 0.3},
                // Agregar más datos si es necesario
        };
        return informacionTelefono;
    }
}

public class Principal {
    public static void main(String[] args) {
        Ciudad ciudadLoja = new Ciudad("LOJA");
        Persona persona = new Persona("Juan", "Pérez", 30, "1234567890", ciudadLoja);

        ArrayList<Pago> pagos = new ArrayList<>();

        DatosAgua datosAgua = new DatosAgua();
        double[][] informacionCasaAgua = datosAgua.datosCasas();
        for (double[] informacion : informacionCasaAgua) {
            PagoAguaPotable pagoAgua = new PagoAguaPotable("CASA", informacion[0], informacion[1], informacion[2]);
            pagos.add(pagoAgua);
        }

        double[][] informacionComercialAgua = datosAgua.datosComerciales();
        for (double[] informacion : informacionComercialAgua) {
            PagoAguaPotable pagoAguaComercial = new PagoAguaPotable("COMERCIAL", informacion[0], informacion[1], informacion[2]);
            pagos.add(pagoAguaComercial);
        }

        DatosLuz datosLuz = new DatosLuz();
        double[][] informacionLuzCasa = datosLuz.datosLoja();
        for (double[] informacion : informacionLuzCasa) {
            PagoLuzElectrica pagoLuz = new PagoLuzElectrica(ciudadLoja, informacion[0], informacion[1], informacion[2]);
            pagos.add(pagoLuz);
        }

        double[][] informacionLuzComercio = datosLuz.datosGeneral();
        for (double[] informacion : informacionLuzComercio) {
            PagoLuzElectrica pagoLuzComercial = new PagoLuzElectrica(new Ciudad("OTRA"), informacion[0], informacion[1], informacion[2]);
            pagos.add(pagoLuzComercial);
        }

        DatosPropiedades datosPropiedades = new DatosPropiedades();
        double[][] informacionPropiedades = datosPropiedades.datos();
        for (double[] informacion : informacionPropiedades) {
            PagoPredial pagoPredial = new PagoPredial(informacion[0], informacion[1]);
            pagos.add(pagoPredial);
        }

        DatosTelefono datosTelefono = new DatosTelefono();
        double[][] informacionTelefono = datosTelefono.datos();
        for (double[] informacion : informacionTelefono) {
            PagoTelefonoConvencional pagoTelefono = new PagoTelefonoConvencional(informacion[0], informacion[1], informacion[2]);
            pagos.add(pagoTelefono);
        }

        BilleteraPagos billeteraPagos = new BilleteraPagos(persona, "Febrero", pagos);
        billeteraPagos.calcularGastoPagos();

        System.out.println(billeteraPagos);
    }
}

