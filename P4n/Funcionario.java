public class Funcionario{

    protected String nome = "";
    protected String codigoFuncionario = "";
    protected float salario = 0;
    protected float salarioLiquido = 0;


    public Funcionario(String nome, String codigoFuncionario, float salario){
        this.nome = nome;
        this.codigoFuncionario = codigoFuncionario;
        this.salario = salario;
        this.salarioLiquido = salario;
    }


    public float calculaSalario(float desconto){
        float calculoDoDesconto = this.salario * desconto;
        
        this.salarioLiquido = (this.salario - calculoDoDesconto);

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
        return this.salario;
    }

    public float getSalarioLiquido(){
        return this.salarioLiquido;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() + System.lineSeparator()
        + "Codigo: " + this.getCodigoFuncionario() + System.lineSeparator()
        + "Salario: " + String.format("%.2f ", this.getSalario()) + System.lineSeparator();
    }
}