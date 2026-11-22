package coopetica.modelo;

public class CuentaAhorro extends Cuenta {

    private double comision;

    public CuentaAhorro(double saldoInicial, double comision) {
        super(saldoInicial);

        if (comision < 0) {
            throw new IllegalArgumentException("Comision invalida");
        }

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
        return "Cuenta de Ahorro: " + super.toString()
                + " Comision: " + comision;
    }
}