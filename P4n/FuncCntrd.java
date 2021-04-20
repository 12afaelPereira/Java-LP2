public class FuncCntrd extends Funcionario{
    
    protected int numeroDeDependentes = 0;
    protected float salarioFamilia = 0;
    protected final double VALOR_POR_DEP = 9.58;
    protected final double ALIQUOTA = 0.15;


    public FuncCntrd(String nome, String codigoFuncionario, float salarioBase, int numeroDeDependentes){
        super(nome, codigoFuncionario, salarioBase);
        
        this.numeroDeDependentes = numeroDeDependentes;
    }

    public void calculaSalario(){
        super.calculaSalario(ALIQUOTA);
        // float desconto = (float)(this.salarioBase * this.ALIQUOTA);
        // this.salarioLiquido =  this.salarioLiquido - desconto;
    }

    public void calculaSalario(int numeroDeDependentes){
        this.salarioFamilia = (float)(numeroDeDependentes * VALOR_POR_DEP);
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
        return this.VALOR_POR_DEP;
    }

    public double getAliquota(){
        return this.ALIQUOTA;
    }

    @Override
    public String toString(){
        return super.toString() + System.lineSeparator()
        + "Salario-liquido: " + String.format("%.2f unidades monetarias", this.salarioLiquido) + System.lineSeparator();
        
        // "Nome: " + super.nome + System.lineSeparator()
        // + "Codigo: " + super.codigoFuncionario + System.lineSeparator()
        // + "Salario-base: " + String.format("%.2f unidades monetarias", this.salarioBase) + System.lineSeparator()
        // + "Salario-liquido: " + String.format("%.2f unidades monetarias", this.salarioLiquido) + System.lineSeparator();
    }

}