package lp2g43.biblioteca;

import java.util.Hashtable;
import lp2g43.biblioteca.Livro;
import lp2g43.biblioteca.Usuario;
import lp2g43.biblioteca.*;

public class Biblioteca{

    protected Hashtable<Integer, Integer> cadastroDeUsuarios = null;
    protected Hashtable<String, Integer> cadastroDelivros = null;
    protected Usuario usuario = null;

    public Biblioteca(Hashtable<Integer, Integer> cadastroDeUsuarios, Hashtable<String, Integer> cadastroDelivros){

        this.cadastroDeUsuarios = cadastroDeUsuarios;
        this.cadastroDelivros = cadastroDelivros;
    }

    // public Biblioteca(String cadastroDeUsuarios, String cadastroDelivros){

    //     this.cadastroDeUsuarios = cadastroDeUsuarios;
    //     this.cadastroDelivros = cadastroDelivros;
    // }


    public void cadastraUsuario(Usuario usuario){
        // this.usuario = usuario;

        cadastroDeUsuarios.put(1, usuario.getCodigoUsuario());
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

    // public Livro getUsuario(int codigoDoUsuario){
    // }
}