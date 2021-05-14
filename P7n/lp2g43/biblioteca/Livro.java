package lp243.biblioteca;

import java.util.ArrayList;
import lp243.biblioteca.CopiaNaoDisponivelEx;
import lp243.biblioteca.NenhumaCopiaEmprestadaEx;

public class Livro{

    // *** Atributos ***
    protected String codigoDoLivro = "";
    protected String titulo = "";
    protected String categoria = "";
    protected int quantidade = 0;
    protected int emprestados = 0;
    protected ArrayList historico = new ArrayList();


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


    protected void empresta(){
        if(emprestados == quantidade){
            throw new CopiaNaoDisponivelEx("Todas as copias estao emprestadas");
        }
        else{
            emprestados++;
        }
    }

    protected void devolve(){

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

}