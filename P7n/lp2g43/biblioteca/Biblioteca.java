package lp2g43.biblioteca;

import java.util.Hashtable;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import lp2g43.biblioteca.Livro;
//import lp2g43.biblioteca.Usuario;
//import lp2g43.biblioteca.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca{

    protected Hashtable<Integer, Usuario> cadastroDeUsuarios = null;
    protected Hashtable<String, Livro> cadastroDelivros = null;
    protected File arquivoCriado = null;
    protected FileWriter arquivoEscrito = null;
    protected ArrayList<String> livrosOrdenados = new ArrayList<String>();
    protected ArrayList<String> usuariosOrdenados = new ArrayList<String>();


    public Biblioteca(Hashtable<Integer, Usuario> cadastroDeUsuarios, Hashtable<String, Livro> cadastroDelivros){

        this.cadastroDeUsuarios = cadastroDeUsuarios;
        this.cadastroDelivros = cadastroDelivros;
    }

    // public Biblioteca(String cadastroDeUsuarios, String cadastroDelivros){

    //     this.cadastroDeUsuarios = cadastroDeUsuarios;
    //     this.cadastroDelivros = cadastroDelivros;
    // }


    public void cadastraUsuario(Usuario usuario){

        cadastroDeUsuarios.put(usuario.getCodigoUsuario(), usuario);
    }

    public void cadastraLivro(Livro livro){

        cadastroDelivros.put(livro.getCodigoLivro(), livro);
    }

    public void salvaArquivo(Hashtable cadastro, String nomeDoArquivo){
        try{
            arquivoCriado = new File(nomeDoArquivo);

            if(arquivoCriado.createNewFile()){
                System.out.println("Arquivo criado:" + arquivoCriado.getName());
            }
            else{
                System.out.println("Arquivo ja existe.");
            }

            // Escrita do arquivo
            arquivoEscrito = new FileWriter(nomeDoArquivo);


            
        }
        catch(IOException e){
            System.out.println("Ocorreu um erro");
        }

    }

    public void leArquivo(){
    }

    public void emprestaLivro(){
    }

    public void devolveLivro(){
    }

    public String imprimeLivros(){
        for (Map.Entry<String, Livro> e : cadastroDelivros.entrySet()){
            livrosOrdenados.add(e.getValue().titulo);
        }

        Collections.sort(livrosOrdenados, new Comparator<String>(){
            @Override
            public int compare(String p1, String p2){
                return p1.compareTo(p2);
            }
        });
        
        return livrosOrdenados.toString();
    }

    public String imprimeUsuarios(){
        for (Map.Entry<Integer, Usuario> e : cadastroDeUsuarios.entrySet()){
            usuariosOrdenados.add(e.getValue().nome);
        }

        Collections.sort(usuariosOrdenados, new Comparator<String>(){
            @Override
            public int compare(String p1, String p2){
                return p1.compareTo(p2);
            }
        });

        return usuariosOrdenados.toString();
    }

    public Livro getLivro(String codigoDoLivro){
        return cadastroDelivros.get(codigoDoLivro);
    }

    public Usuario getUsuario(int codigoDoUsuario){
        return cadastroDeUsuarios.get(codigoDoUsuario);
    }
}