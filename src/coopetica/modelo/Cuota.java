package coopetica.modelo;

import java.time.LocalDate;

public class Cuota {

    private int numero;
    private double monto;
    private LocalDate fechaVencimiento;
    private boolean pagada;
    private boolean anulada;

    public Cuota(int numero, double monto, LocalDate fechaVencimiento) {
        this.numero = numero;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = false;
        this.anulada = false;
    }

    public void marcarComoPagada() {
        if (anulada) {
            throw new IllegalStateException("La cuota esta anulada");
        }
        pagada = true;
    }

    public void anular() {
        if (!pagada) {
            anulada = true;
        }
    }

    public int getNumero() {
        return numero;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean isPagada() {
        return pagada;
    }

    public boolean isAnulada() {
        return anulada;
    }
}