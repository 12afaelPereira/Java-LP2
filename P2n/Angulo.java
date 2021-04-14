public class Angulo{
    private double radianos = 0.0;

    private double cvtAngulo(double graus){
        return Math.toRadians(graus);
    }

    private double fSeno(double angulo){
        radianos = cvtAngulo(angulo);

        return Math.sin(radianos);
    }

    private double fCos(double angulo){
        radianos = cvtAngulo(angulo);

        return Math.cos(radianos);
    }

    private double fTangente(double angulo){
        radianos = cvtAngulo(angulo);

        return Math.tan(radianos);
    }

    private double fCotangente(double angulo){
        radianos = cvtAngulo(angulo);

        double cotangente = fCos(radianos)/fSeno(radianos);
        
        return cotangente;
    }

    public String toString(double angulo){
        return "Angulo em grau: " + angulo + System.lineSeparator()
        + "Angulo em rad: " + String.format("%.2f",cvtAngulo(angulo)) + System.lineSeparator()
        + "Seno: " + fSeno(angulo) + System.lineSeparator()
        + "Seno: " + String.format("%.2f",fSeno(angulo)) + System.lineSeparator()
        + "Cosseno: " + fCos(angulo) + System.lineSeparator()
        + "Cosseno: " + String.format("%.2f",fCos(angulo)) + System.lineSeparator()
        + "Tangente: " + fTangente(angulo) + System.lineSeparator()
        + "Tangente: " + String.format("%.2f",fTangente(angulo)) + System.lineSeparator()
        + "Cotangente: " + fCotangente(angulo) + System.lineSeparator()
        + "Cotangente: " + String.format("%.2f",fCotangente(angulo)) + System.lineSeparator();
    }
}