public class Funcionario{

    protected String nome = "";
    protected String codigoFuncionario = "";
    protected float salarioBase = 0;
    protected float salarioLiquido = 0;


    public Funcionario(String nome, String codigoFuncionario, float salarioBase){
        this.nome = nome;
        this.codigoFuncionario = codigoFuncionario;
        this.salarioLiquido = salarioBase;
        this.salarioBase = salarioBase;
    }


    public double calculaSalario(double desconto){
        double calculoDoDesconto = this.salarioBase * desconto;
        
        this.salarioLiquido = (float)(this.salarioBase - calculoDoDesconto);

        return salarioLiquido;
    }

    // Getters
    public String getNome(){
        return this.nome;
    }

    public String getCodigoFuncionario(){
        return this.codigoFuncionario;
    }

    public float getSalario(){
        return this.salarioBase;
    }

    public float getSalarioLiquido(){
        return this.salarioLiquido;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + System.lineSeparator()
        + "Codigo: " + this.codigoFuncionario + System.lineSeparator()
        + "Salario-base: " + String.format("%.2f unidades monetarias", this.salarioBase) + System.lineSeparator();
    }
}