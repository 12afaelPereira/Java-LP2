public class FuncCntrd extends Funcionario{
    
    protected int numeroDeDeDependentes = 0;
    protected float salarioFamilia = 0;
    protected static double valorPorDep = 9.58;
    protected static double aliquota = 0.15;


    public FuncCntrd(String nome, String codigoFuncionario, float salario, int numeroDeDeDependentes){
        super(nome, codigoFuncionario, salario);
        
        this.numeroDeDeDependentes = numeroDeDeDependentes;
    }

    public void calculaSalario(){
        float desconto = (float)(this.salario * this.aliquota);

        this.salarioLiquido =  this.salarioLiquido - desconto;
    }

    public void calculaSalario(int numeroDeDeDependentes){
        this.salarioFamilia = (float)(numeroDeDeDependentes * valorPorDep);
        
        this.salarioLiquido += salarioFamilia;
        this.calculaSalario();
    }

    @Override
    public String toString(){
        return "Nome: " + super.nome + System.lineSeparator()
        + "Codigo: " + super.codigoFuncionario + System.lineSeparator()
        + "Salario-base: " + String.format("%.2f unidades monetarias", this.salario) + System.lineSeparator()
        + "Salario-liquido: " + String.format("%.2f unidades monetarias", this.salarioLiquido) + System.lineSeparator();
    }

}