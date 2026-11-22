package coopetica.modelo;

public abstract class Cuenta {

    private double saldo;

    public Cuenta(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }

        if (monto > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        saldo -= monto;
    }

    public abstract void cobrarComisiones();

    @Override
    public String toString() {
        return "Saldo: " + saldo;
    }
}