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
        return "Seno: " + fSeno(angulo) + System.lineSeparator()
        + "Cosseno: " + fCos(angulo) + System.lineSeparator()
        + "Tangente: " + fCos(angulo) + System.lineSeparator()
        + "Cotangente: " + fCotangente(angulo) + System.lineSeparator();
    }
}