import java.io.Serializable;

public class Pessoa implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 9138852946853441247L;
	
	
	protected String nome = "";
    protected String dataDeNascimento = "";


    public Pessoa(String nome, String dataDeNascimento){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDataDeNascimento(){
        return this.dataDeNascimento;
    }

    @Override
    public String toString(){
        return "Nome: <" + this.getNome() + ">" + System.lineSeparator()
            +  "Data de Nascimento: <" + this.getDataDeNascimento() + ">" + System.lineSeparator();
    }
}