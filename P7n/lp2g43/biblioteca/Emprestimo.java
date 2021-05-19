package lp2g43.biblioteca;

import java.util.GregorianCalendar;

public class Emprestimo{

    // *** Atributos ***
    protected GregorianCalendar dataDoEmprestimo = null;
    protected GregorianCalendar dataDeDevolucao = null;
    protected String codigoDoLivro = "";


    public Emprestimo(int diaDoEmprestimo, int mesDoEmprestimo, int anoDoEmprestimo, 
                      int diaDaDevolucao, int mesDaDevolucao, int anoDaDevolucao,
                      String codigoDoLivro){

        this.setDataDoEmprestimo(diaDoEmprestimo, mesDoEmprestimo, anoDoEmprestimo);
        this.setDataDaDevolucao(diaDaDevolucao, mesDaDevolucao, anoDaDevolucao);
        this.codigoDoLivro = codigoDoLivro;
    }

    protected void setDataDoEmprestimo(int dia, int mes, int ano){
        dataDoEmprestimo = new GregorianCalendar(ano, mes, dia);
    }

    protected void setDataDaDevolucao(int dia, int mes, int ano){
        dataDeDevolucao = new GregorianCalendar(ano, mes, dia);
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    
}