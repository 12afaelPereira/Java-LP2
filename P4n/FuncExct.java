public class FuncExct extends FuncCntrd{

    private float gratificacao = 0;

    public FuncExct(String nome, String codigoFuncionario, float salario, int numeroDeDependentes, float gratificacao){
        super(nome, codigoFuncionario, salario, numeroDeDependentes);

        this.gratificacao = gratificacao;
    }

    
    public float calculaSalario(){
        this.salarioLiquido = super.calculaSalario(ALIQUOTA) + this.gratificacao;
        
        return salarioLiquido;
    }

    // Getters
    public float getGratificacao(){
        return this.gratificacao;
    }

    @Override
    public String toString(){
        return super.toString()
        // + "Salario-liquido: " + String.format("%.2f ", this.calculaSalario()) + System.lineSeparator()
        + "Gratificacao: " + String.format("%.2f ", this.gratificacao) + System.lineSeparator();
    }
}