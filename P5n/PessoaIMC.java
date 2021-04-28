public abstract class PessoaIMC extends Pessoa{

    protected double peso = 0;
    protected double altura = 0;

    public PessoaIMC(String nome, String dataDeNascimento, double peso, double altura){
        super(nome, dataDeNascimento);

        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getAltura(){
        return this.altura;
    }

    public double calculaIMC(double peso, double altura){
        double indiceDeMassaCorporal = peso/Math.pow(altura, 2);

        return indiceDeMassaCorporal;
    }

    public String classificacaoHomem(String indiceDeMassaCorporal){
        double imc = Double.parseDouble(indiceDeMassaCorporal);

        return imc < 20.7? "Abaixo do peso ideal" : 
            imc >26.4? "Acima do peso ideal" : "Peso ideal";
    }

    public String classificacaoMulher(String indiceDeMassaCorporal){
        double imc = Double.parseDouble(indiceDeMassaCorporal);

        return imc < 19? "Abaixo do peso ideal" : 
            imc >25.8? "Acima do peso ideal" : "Peso ideal";
    }

    public abstract String resultIMC();

    @Override
    public String toString(){

        return super.toString()
            + "Peso: <" + peso + ">" +  System.lineSeparator()
            + "Altura: <" + altura + ">" + System.lineSeparator();
    }
}