public class FuncCntrd extends Funcionario{
    
    protected int numeroDeDependentes = 0;
    protected float salarioFamilia = 0;
    protected float salarioBase = 0;
    protected final float VALOR_POR_DEP = (float) 9.58;
    protected final float ALIQUOTA = (float) 0.15;


    public FuncCntrd(String nome, String codigoFuncionario, float salario, int numeroDeDependentes){
        super(nome, codigoFuncionario, salario);
        
        this.numeroDeDependentes = numeroDeDependentes;
    }

    public float calculaSalario(){
        this.salarioLiquido = super.calculaSalario(ALIQUOTA);
        
        return salarioLiquido;
    }

    public float calculaSalario(int numeroDeDependentes){
        this.salarioFamilia = (numeroDeDependentes * VALOR_POR_DEP);
        this.salarioBase = this.salario + salarioFamilia;

        this.salarioLiquido = this.calculaSalario();

        return salarioLiquido;
    }

    // Getters
    public int getNumeroDeDependentes(){
        return this.numeroDeDependentes;
    }
    
    public float getSalarioFamilia(){
        return this.salarioFamilia;
    }

    public double getValorPorDep(){
        return this.VALOR_POR_DEP;
    }

    public double getAliquota(){
        return this.ALIQUOTA;
    }

    @Override
    public String toString(){
        return super.toString()
        + "Salario-liquido: " + String.format("%.2f ", this.calculaSalario(this.numeroDeDependentes)) + System.lineSeparator();
    }

}