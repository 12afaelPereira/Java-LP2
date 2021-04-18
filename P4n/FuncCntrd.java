public class FuncCntrd extends Funcionario{
    
    protected int numeroDeDependentes = 0;
    protected float salarioFamilia = 0;
    protected static double valorPorDep = 9.58;
    protected static double aliquota = 0.15;


    public FuncCntrd(String nome, String codigoFuncionario, float salario, int numeroDeDependentes){
        super(nome, codigoFuncionario, salario);
        
        this.numeroDeDependentes = numeroDeDependentes;
    }

    public void calculaSalario(){
        float desconto = (float)(this.salario * this.aliquota);

        this.salarioLiquido =  this.salarioLiquido - desconto;
    }

    public void calculaSalario(int numeroDeDependentes){
        this.salarioFamilia = (float)(numeroDeDependentes * valorPorDep);
        
        this.salarioLiquido += salarioFamilia;
        this.calculaSalario();
    }

    // Getters
    public int getNumeroDeDependentes(){
        return this.numeroDeDependentes;
    }
    
    public float getSalarioFamilia(){
        return this.salarioFamilia;
    }

    public double getValorPorDep(){
        return this.valorPorDep;
    }

    public double getAliquota(){
        return this.aliquota;
    }

    @Override
    public String toString(){
        return "Nome: " + super.nome + System.lineSeparator()
        + "Codigo: " + super.codigoFuncionario + System.lineSeparator()
        + "Salario-base: " + String.format("%.2f unidades monetarias", this.salario) + System.lineSeparator()
        + "Salario-liquido: " + String.format("%.2f unidades monetarias", this.salarioLiquido) + System.lineSeparator();
    }

}