public class FuncionarioExct extends FuncCntrd{

    private float gratificacao = 0;

    public FuncionarioExct(String nome, String codigoFuncionario, float salarioBase, int numeroDeDependentes, float gratificacao){
        super(nome, codigoFuncionario, salarioBase, numeroDeDependentes);

        this.gratificacao = gratificacao;
    }

    @Override
    public void calculaSalario(){
        this.salarioLiquido += this.gratificacao;
    }

    // Getters
    public float getGratificacao(){
        return this.gratificacao;
    }

    @Override
    public String toString(){
        return super.toString()
        + "Gratificacao: " + String.format("%.2f unidades monetarias", this.gratificacao) + System.lineSeparator();
        
        // "Nome: " + super.nome + System.lineSeparator()
        // + "Codigo: *" + super.codigoFuncionario + System.lineSeparator()
        // + "Salario-base: " + String.format("%.2f unidades monetarias", this.salarioBase) + System.lineSeparator()
        // + "Salario-liquido: " + String.format("%.2f unidades monetarias", this.salarioLiquido) + System.lineSeparator();
        
    }
}