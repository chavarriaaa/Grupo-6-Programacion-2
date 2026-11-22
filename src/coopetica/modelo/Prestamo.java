package coopetica.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {

    private double monto;
    private double tasa;
    private int meses;
    private PoliticaInteres politicaInteres;
    private boolean activo;
    private ArrayList<Cuota> cuotas;

    public Prestamo(double monto, double tasa, int meses,
                    PoliticaInteres politicaInteres) {

        if (monto <= 0 || tasa < 0 || meses <= 0) {
            throw new IllegalArgumentException("Datos del prestamo invalidos");
        }

        if (politicaInteres == null) {
            throw new IllegalArgumentException("Politica de interes requerida");
        }

        this.monto = monto;
        this.tasa = tasa;
        this.meses = meses;
        this.politicaInteres = politicaInteres;
        this.activo = true;
        this.cuotas = new ArrayList<>();
    }

    public double calcularInteres() {
        return politicaInteres.calcularInteres(monto, tasa, meses);
    }

    public double calcularTotal() {
        return monto + calcularInteres();
    }

    public void generarCuotas() {
        if (!cuotas.isEmpty()) {
            throw new IllegalStateException("Las cuotas ya fueron generadas");
        }

        double montoCuota = calcularTotal() / meses;

        for (int i = 1; i <= meses; i++) {
            LocalDate fecha = LocalDate.now().plusMonths(i);

            Cuota cuota = new Cuota(i, montoCuota, fecha);
            cuotas.add(cuota);
        }
    }

    public void anular() {
        activo = false;

        for (Cuota cuota : cuotas) {
            cuota.anular();
        }
    }

    public ArrayList<Cuota> getCuotas() {
        return new ArrayList<>(cuotas);
    }

    public boolean isActivo() {
        return activo;
    }

    public double getMonto() {
        return monto;
    }

    public int getMeses() {
        return meses;
    }
}