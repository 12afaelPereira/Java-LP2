public class FuncionarioExct extends FuncCntrd{

    private float gratificacao = 0;

    public FuncionarioExct(String nome, String codigoFuncionario, float salario, int numeroDeDeDependentes, float gratificacao){
        super(nome, codigoFuncionario, salario, numeroDeDeDependentes);

        this.gratificacao = gratificacao;
    }

    public void calculaSalario(){
        this.salario = this.salarioLiquido + this.gratificacao;
    }

    // Getters
    public float getGratificacao(){
        return this.gratificacao;
    }

    @Override
    public String toString(){
        return "Nome: " + super.nome + System.lineSeparator()
        + "Codigo: *" + super.codigoFuncionario + System.lineSeparator()
        + "Salario-base: " + String.format("%.2f unidades monetarias", this.salario) + System.lineSeparator()
        + "Salario-liquido: " + String.format("%.2f unidades monetarias", this.salarioLiquido) + System.lineSeparator();
        
    }
}