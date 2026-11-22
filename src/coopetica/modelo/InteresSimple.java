package coopetica.modelo;

public class InteresSimple implements PoliticaInteres {

    @Override
    public double calcularInteres(double monto, double tasa, int meses) {
        return monto * (tasa / 100) * meses / 12;
    }

}
