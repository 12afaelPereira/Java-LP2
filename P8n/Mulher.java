import java.io.Serializable;

public class Mulher extends PessoaIMC implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 779483987560969918L;

	public Mulher(String nome, String dataDeNascimento, double peso, double altura){
        super(nome, dataDeNascimento, peso, altura);
    }

    public String resultIMC(){
        return "" + Math.round(super.calculaIMC(this.peso, this.altura)*100.0)/100.0;
    }

    @Override
    public String toString(){
        return super.toString()
         + "Indice De Massa Corporea: " + this.resultIMC() + " " + super.classificacaoMulher(this.resultIMC());
    }
}