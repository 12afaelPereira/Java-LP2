package lp2g43.biblioteca;

import java.util.Hashtable;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.IOException;

public class Biblioteca{

    protected Hashtable<Integer, Usuario> cadastroDeUsuarios = null;
    protected Hashtable<String, Livro> cadastroDelivros = null;
    protected ArrayList<String> livrosOrdenados = new ArrayList<String>();
    protected ArrayList<String> usuariosOrdenados = new ArrayList<String>();
    protected Calendar dataDeEmprestimo = null;
    protected Calendar dataDeDevolucao = null;


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
            FileOutputStream streamDoArquivo = new FileOutputStream("./files" + nomeDoArquivo);
            ObjectOutputStream arquivo = new ObjectOutputStream(streamDoArquivo);

            arquivo.writeObject(cadastro);
            arquivo.flush();
            arquivo.close();

            streamDoArquivo.flush();
            streamDoArquivo.close();
            System.out.println("Arquivo salvo com sucesso!");
        }
        catch(IOException e){
            System.out.println("Ocorreu um erro");
        }
    }

    public void leArquivo(String nomeDoArquivo){
        // try{
        //     FileInputStream streamDoArquivo = new FileInputStream("./files" + nomeDoArquivo);
        //     ObjectInputStream arquivo = new ObjectInputStream(streamDoArquivo);

        //     this.
        // }
        // catch(IOException e){
        //     System.out.println("Ocorreu um erro");
        // }
    }

    public void emprestaLivro(Usuario usuario, Livro livro){
    	//dataDeEmprestimo = Calendar.getInstance();
    	dataDeDevolucao = Calendar.getInstance();
    	
    	// adicionando 7 dias a data atual
    	dataDeDevolucao.add(Calendar.DATE, 7);

    	livro.empresta();
    	usuario.addLivroHist(Calendar.DATE, Calendar.MONTH, Calendar.YEAR, 
                            dataDeDevolucao.get(Calendar.DATE), 
                            dataDeDevolucao.get(Calendar.MONTH), 
                            dataDeDevolucao.get(Calendar.YEAR), 
                            livro.getCodigoLivro());
    }

    public void devolveLivro(Usuario usuario, Livro livro){
        livro.devolve();
        
        for(Emprestimo emprestimo : usuario.getHistorico()) {
        	if(emprestimo.codigoDoLivro.contains(livro.getCodigoLivro())) {


        		livro.addUsuarioHist(emprestimo.getDataDoEmprestimo().get(Calendar.DATE), 
                                    emprestimo.getDataDoEmprestimo().get(Calendar.MONTH), 
                                    emprestimo.getDataDoEmprestimo().get(Calendar.YEAR), 
                                    Calendar.DATE, Calendar.MONTH, Calendar.YEAR, 
                                    usuario.getCodigoUsuario());
        	}
        }
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    
    
}