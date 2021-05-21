package lp2g43.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
//import lp2g43.biblioteca.CopiaNaoDisponivelEx;
//import lp2g43.biblioteca.NenhumaCopiaEmprestadaEx;

public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1752019598769239118L;
	
	
	// *** Atributos ***
    protected String codigoDoLivro = "";
    protected String titulo = "";
    protected String categoria = "";
    protected int quantidade = 0;
    protected int emprestados = 0;
    protected ArrayList<EmprestadoPara> historico = new ArrayList<EmprestadoPara>();


    public Livro(String codigoDoLivro, String titulo, String categoria, int quantidade, int emprestados){
        this.codigoDoLivro = codigoDoLivro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.emprestados = emprestados;
    }

    public Livro(String titulo){
        this.titulo = titulo;
    }


    protected void empresta() throws CopiaNaoDisponivelEx{
        if(emprestados == quantidade){
            throw new CopiaNaoDisponivelEx("Todas as copias estao emprestadas");
        }
        else{
            emprestados++;
        }
    }

    protected void devolve() throws NenhumaCopiaEmprestadaEx{

        if(emprestados == 0){
            throw new NenhumaCopiaEmprestadaEx("Nenhuma copia emprestada ainda");
        }
        else{
            emprestados--;
        }
    }

    public void addUsuarioHist(int diaDoEmprestimo, int mesDoEmprestimo, int anoDoEmprestimo, 
                      int diaDaDevolucao, int mesDaDevolucao, int anoDaDevolucao,
                      int codigoDoUsuario){
        
        historico.add(new EmprestadoPara(diaDoEmprestimo, mesDoEmprestimo, anoDoEmprestimo,
                                        diaDaDevolucao, mesDaDevolucao, anoDaDevolucao, codigoDoUsuario));

    }
    
    public String getCodigoLivro(){
        return codigoDoLivro;
    }
    
    public String getTitulo() {
		return titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getEmprestados() {
		return emprestados;
	}

	public ArrayList<EmprestadoPara> getHistorico() {
		return historico;
	}

	@Override
	public String toString() {
		return "Codigo do livro: "  + getCodigoLivro() + System.lineSeparator()
			+ "Titulo: " + getTitulo() + System.lineSeparator()
			+ "Categoria: " + getCategoria() + System.lineSeparator()
			+ "Quantidade: " + getQuantidade() + System.lineSeparator()
			+ "Emprestados: " + getEmprestados() + System.lineSeparator()
			+ "Historico" + getHistorico().toString();
	}
	
}
