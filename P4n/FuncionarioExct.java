public class FuncionarioExct extends FuncCntrd{

    private float gratificacao = 0;

    public FuncionarioExct(String nome, String codigoFuncionario, float salario, int numeroDeDeDependentes, float gratificacao){
        super(nome, codigoFuncionario, salario, numeroDeDeDependentes);

    }

    void calculaSalario(){
        this.salarioLiquido + this.gratificacao;
    }
}