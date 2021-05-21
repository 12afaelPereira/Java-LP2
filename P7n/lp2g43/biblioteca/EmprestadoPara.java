package lp2g43.biblioteca;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmprestadoPara{

    protected GregorianCalendar dataDoEmprestimo = null;
    protected GregorianCalendar dataDeDevolucao = null;
    protected int codigoDoUsuario = 0;


    public EmprestadoPara(int diaDoEmprestimo, int mesDoEmprestimo, int anoDoEmprestimo, 
                      int diaDaDevolucao, int mesDaDevolucao, int anoDaDevolucao,
                      int codigoDoUsuario){

        this.setDataDoEmprestimo(diaDoEmprestimo, mesDoEmprestimo, anoDoEmprestimo);
        this.setDataDaDevolucao(diaDaDevolucao, mesDaDevolucao, anoDaDevolucao);
        this.codigoDoUsuario = codigoDoUsuario;
    }


    protected void setDataDoEmprestimo(int dia, int mes, int ano){
        dataDoEmprestimo = new GregorianCalendar(ano, mes, dia);
    }

    
    protected void setDataDaDevolucao(int dia, int mes, int ano){
        dataDeDevolucao = new GregorianCalendar(ano, mes, dia);
    }

    
	public GregorianCalendar getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}


	public GregorianCalendar getDataDeDevolucao() {
		return dataDeDevolucao;
	}


	public int getCodigoDoUsuario() {
		return codigoDoUsuario;
	}


	@Override
	public String toString() {
		return "Codigo do usuario: " + getCodigoDoUsuario() + System.lineSeparator()
			+ "Data do emprestimo: " + getDataDoEmprestimo().get(Calendar.DATE) + "/" 
									+ (getDataDoEmprestimo().get(Calendar.MONTH)+1) + "/" 
									+ getDataDoEmprestimo().get(Calendar.YEAR) + System.lineSeparator()
			+ "Data da devolucao: " + getDataDeDevolucao().get(Calendar.DATE) + "/"
									+ (getDataDeDevolucao().get(Calendar.MONTH)+1) + "/"
									+ getDataDeDevolucao().get(Calendar.YEAR) + System.lineSeparator();
	}
}