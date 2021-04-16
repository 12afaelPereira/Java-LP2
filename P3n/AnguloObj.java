public class AnguloObj{
    private double arcoRad = 0;

    // Constructor
    public AnguloObj(double graus){
        this.converteAngulo(graus);
    }

    // Methods
    private void converteAngulo(double graus){
        this.arcoRad = Math.toRadians(graus);
    }

    private double funcaoSeno(){
        return Math.sin(arcoRad);
    }

    private double funcaoCos(){
        return Math.cos(arcoRad);
    }

    private double funcaoTangente(){
        return Math.tan(arcoRad);
    }

    private double funcaoCotangente(){
        double cotangente = 1/funcaoTangente();
        
        return cotangente;
    }

    @Override
    public String toString(){
        return "Arco: " + String.format("%.2f rad", this.arcoRad) + System.lineSeparator()
        + "Seno: " + String.format("%.2f", funcaoSeno()) + System.lineSeparator()
        + "Cosseno: " + String.format("%.2f", funcaoCos()) + System.lineSeparator()
        + "Tangente: " + String.format("%.2f", funcaoTangente()) + System.lineSeparator()
        + "Cotangente: " + String.format("%.2f", funcaoCotangente()) + System.lineSeparator(); 
    }
    
}