public class FuncCntrd extends Funcionario{
    
    public FuncCntrd(String nome, String codigoFuncionario, float salario){
        super(nome, codigoFuncionario, salario);
    }

    protected int numeroDeDeDependentes = 0;
    protected float salarioFamilia = 0;
    protected static double valorPorDep = 9.58;
    protected static double aliquota = 0.15;

    protected void calculaSalario(){
        
    }

    @Override
    public String toString(){
        return "Nome: " + super.nome + System.lineSeparator()
        + "Codigo: " + super.codigoFuncionario + System.lineSeparator()
        + "Salario-base: " + String.format("%.2f unidades monetarias", super.calculaSalario(10)) + System.lineSeparator()
        + "Salario-liquido: " + String.format("%.2f unidades monetarias", super.calculaSalario(10)) + System.lineSeparator();
    }

}