package lp2g43.biblioteca;

import java.util.GregorianCalendar;


public class Pessoa{

    // *** Atributos ***
    protected String nome = "";
    protected GregorianCalendar dataDeNascimento = null;


    public Pessoa(String nome, int dia, int mes, int ano){
        this.nome = nome;
        this.setDataDeNascimento(dia, mes, ano);
    }


    protected void setDataDeNascimento(int dia, int mes, int ano){
        dataDeNascimento = new GregorianCalendar(ano, mes, dia);
    }
}