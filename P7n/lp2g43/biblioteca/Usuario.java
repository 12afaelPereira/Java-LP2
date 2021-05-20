package lp2g43.biblioteca;

import java.util.ArrayList;

public class Usuario extends Pessoa{

    // *** Atributos ***
    protected String endereco = "";
    protected int codigoUsuario = 0;
	protected ArrayList<Emprestimo> historico = new ArrayList<Emprestimo>();


    public Usuario(String nome, int dia, int mes, int ano, String endereco, int codigoUsuario, ArrayList<Emprestimo> historico){
        super(nome, dia, mes, ano);

        this.endereco = endereco;
        this.codigoUsuario = codigoUsuario;
        this.historico = historico;
    }


    public void addLivroHist(int diaDoEmprestimo, 
                      int mesDoEmprestimo, 
                      int anoDoEmprestimo, 
                      int diaDaDevolucao, 
                      int mesDaDevolucao, 
                      int anoDaDevolucao,
                      String codigoDoLivro){

        historico.add(new Emprestimo(diaDoEmprestimo, mesDoEmprestimo, anoDoEmprestimo, 
                                    diaDaDevolucao, mesDaDevolucao, anoDaDevolucao, codigoDoLivro));
    }

    public int getCodigoUsuario(){
        return codigoUsuario;
    }
    
    public String getEndereco() {
		return endereco;
	}

	public ArrayList<Emprestimo> getHistorico() {
		return historico;
	}


	@Override
	public String toString() {
        return super.toString() 
        		+ "Codigo do usuario: "  + getCodigoUsuario() + System.lineSeparator()
        		+ "Endereco: " + getEndereco()
        		+ "Historico: " + getHistorico().toString();
	}
}