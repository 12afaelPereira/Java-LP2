public class Angulo{
    private static double radianos = 0.0;

    public static double cvtAngulo(double graus){
        return Math.toRadians(graus);
    }

    public static double fSeno(double angulo){
        radianos = cvtAngulo(angulo);

        return Math.sin(radianos);
    }

    public static double fCos(double angulo){
        radianos = cvtAngulo(angulo);

        return Math.cos(radianos);
    }

    public static double fTangente(double angulo){
        radianos = cvtAngulo(angulo);

        return Math.tan(radianos);
    }

    public static double fCotangente(double angulo){
        radianos = cvtAngulo(angulo);

        double cotangente = 1/fTangente(angulo);
        
        return cotangente;
    }
}