package lp243.biblioteca;

import lp243.biblioteca.Pessoa;
import lp243.biblioteca.Emprestimo;
import java.util.ArrayList;

public class Usuario extends Pessoa{

    // *** Atributos ***
    protected String endereco = "";
    protected int codigoUsuario = 0;
    protected ArrayList historico = new ArrayList();


    public Usuario(String nome, int dia, int mes, int ano, String endereco, int codigoUsuario, ArrayList historico){
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
                      int codigoDoLivro){

        historico.add(new Emprestimo(diaDoEmprestimo, mesDoEmprestimo, anoDoEmprestimo, 
                                    diaDaDevolucao, mesDaDevolucao, anoDaDevolucao, codigoDoLivro));
    }



}