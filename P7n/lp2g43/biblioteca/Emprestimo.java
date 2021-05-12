package lp243.biblioteca;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Emprestimo{

    // *** Atributos ***
    protected GregorianCalendar dataDoEmprestimo = null;
    protected GregorianCalendar dataDeDevolucao = null;
    protected int codigoDoLivro = 0;


    public Emprestimo(int diaDoEmprestimo, int mesDoEmprestimo, int anoDoEmprestimo, 
                      int diaDaDevolucao, int mesDaDevolucao, int anoDaDevolucao,
                      int codigoDoLivro){

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
}