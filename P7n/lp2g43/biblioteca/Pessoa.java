package lp2g43.biblioteca;

import java.io.Serializable;
import java.util.GregorianCalendar;


public class Pessoa implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5397495808057773169L;
	
	
	// *** Atributos ***
    protected String nome = "";
	protected GregorianCalendar dataDeNascimento = null;


    public Pessoa(String nome, int dia, int mes, int ano){
        this.nome = nome;
        this.setDataDeNascimento(dia, mes, ano);
    }

    
    public String getNome() {
		return nome;
	}

	public GregorianCalendar getDataDeNascimento() {
		return dataDeNascimento;
	}

    protected void setDataDeNascimento(int dia, int mes, int ano){
        dataDeNascimento = new GregorianCalendar(ano, mes, dia);
    }


	@Override
	public String toString() {
		return "Nome: " + getNome() + System.lineSeparator()
			+ "Data de Nascimento: " + getDataDeNascimento() + System.lineSeparator();
	}
    
    
}