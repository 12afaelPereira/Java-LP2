package lp243.biblioteca;

import java.util.Hashtable;
import lp243.biblioteca.Livro;

public class Biblioteca{

    protected Hashtable cadastroDeUsuarios = null;
    protected Hashtable cadastroDelivros = null;

    public Biblioteca(Hashtable cadastroDeUsuarios, Hashtable cadastroDelivros){

        this.cadastroDeUsuarios = cadastroDeUsuarios;
        this.cadastroDelivros = cadastroDelivros;

    }
    

    public void cadastraUsuario(){
    }

    public void cadastraLivro(){
    }

    public void salvaArquivo(){
    }

    public void leArquivo(){
    }

    public void emprestaLivro(){
    }

    public void devolveLivro(){
    }

    public String imprimeLivros(){
        return "";
    }

    public String imprimeUsuarios(){
        return "";
    }

    // public Livro getLivro(String codigoDoLivro){
    // }

}