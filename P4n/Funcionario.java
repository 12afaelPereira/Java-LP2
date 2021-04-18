public class Funcionario{

    protected String nome = "";
    protected String codigoFuncionario = "";
    protected float salario = 0;
    protected float salarioLiquido = 0;


    public Funcionario(String nome, String codigoFuncionario, float salario){
        this.nome = nome;
        this.codigoFuncionario = codigoFuncionario;
        this.salarioLiquido = salario;
        this.salario = salario;
    }


    public double calculaSalario(double desconto){
        double calculoDoDesconto = this.salario * desconto;

        return (this.salario - calculoDoDesconto);
    }

    // Getters
    public String getNome(){
        return this.nome;
    }

    public String getCodigoFuncionario(){
        return this.codigoFuncionario;
    }

    public float getSalario(){
        return this.salario;
    }

    public float getSalarioLiquido(){
        return this.salarioLiquido;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + System.lineSeparator()
        + "Codigo: " + this.codigoFuncionario + System.lineSeparator()
        + "Salario-base: " + String.format("%.2f unidades monetarias", calculaSalario(10)) + System.lineSeparator();
    }
}