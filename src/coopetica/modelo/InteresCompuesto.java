package coopetica.modelo;

public class InteresCompuesto implements PoliticaInteres {

    @Override
    public double calcularInteres(double monto, double tasa, int meses) {
        double tasaMensual = (tasa / 100) / 12;
        return monto * Math.pow(1 + tasaMensual, meses) - monto;
    }

}