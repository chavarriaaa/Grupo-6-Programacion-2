package coopetica.modelo;

public class CuentaCorriente extends Cuenta {

    private double comision;

    public CuentaCorriente(double saldoInicial, double comision) {
        super(saldoInicial);
        this.comision = comision;
    }

    @Override
    public void cobrarComisiones() {
        if (getSaldo() >= comision) {
            retirar(comision);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    @Override
    public String toString() {
        return "Cuenta Corriente: " + super.toString()
                + " Comision: " + comision;
    }
}