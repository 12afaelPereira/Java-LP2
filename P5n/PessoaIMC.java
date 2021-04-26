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

    public double CalculaIMC(double peso, double altura){
        double indiceDeMassaCorporal = peso/Math.pow(altura, 2);

        return indiceDeMassaCorporal;
    }
}