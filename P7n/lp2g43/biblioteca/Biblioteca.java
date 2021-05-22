package lp2g43.biblioteca;

import java.util.Hashtable;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
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
    protected Calendar dataPrevistaDeDevolucao = null;
    protected long milliseconds = 0;
    protected int diasComOLivro = 2;


    public Biblioteca(Hashtable<Integer, Usuario> cadastroDeUsuarios, Hashtable<String, Livro> cadastroDelivros){

        this.cadastroDeUsuarios = cadastroDeUsuarios;
        this.cadastroDelivros = cadastroDelivros;
    }

    public Biblioteca(String cadastroDeUsuarios, String cadastroDelivros){

        this.leArquivo(cadastroDeUsuarios);
        this.leArquivo(cadastroDelivros);
    }


    public void cadastraUsuario(Usuario usuario){
        cadastroDeUsuarios.put(usuario.getCodigoUsuario(), usuario);
    }

    public void cadastraLivro(Livro livro){
        cadastroDelivros.put(livro.getCodigoLivro(), livro);
    }

    public void salvaArquivo(Hashtable cadastro, String nomeDoArquivo){
        try{
            FileOutputStream streamDoArquivo = new FileOutputStream(nomeDoArquivo);
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
            e.printStackTrace();
        }
    }

    public void leArquivo(String nomeDoArquivo){
        try{
            FileInputStream streamDoArquivo = new FileInputStream(nomeDoArquivo);
            ObjectInputStream arquivo = new ObjectInputStream(streamDoArquivo);

            if(nomeDoArquivo.equals("CadastroDeUsuarios")) {
            	cadastroDeUsuarios = (Hashtable<Integer, Usuario>) arquivo.readObject();
            	
            	arquivo.close();
            	streamDoArquivo.close();
            }
            
            else if(nomeDoArquivo.equals("CadastroDeLivros")) {
            	cadastroDelivros = (Hashtable<String, Livro>) arquivo.readObject();
            	
            	arquivo.close();
            	streamDoArquivo.close();
            }
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }

    public void emprestaLivro(Usuario usuario, Livro livro){
    	dataDeEmprestimo = Calendar.getInstance();
    	dataPrevistaDeDevolucao = Calendar.getInstance();
    	
    	// adicionando 7 dias a data atual
    	dataPrevistaDeDevolucao.add(Calendar.DATE, 7);

    	try {
			livro.empresta();
			
			livro.addUsuarioHist(dataDeEmprestimo.get(Calendar.DATE), 
					dataDeEmprestimo.get(Calendar.MONTH), 
					dataDeEmprestimo.get(Calendar.YEAR), 
					dataPrevistaDeDevolucao.get(Calendar.DATE), 
                    dataPrevistaDeDevolucao.get(Calendar.MONTH), 
                    dataPrevistaDeDevolucao.get(Calendar.YEAR), 
                    usuario.getCodigoUsuario());

			usuario.addLivroHist(dataDeEmprestimo.get(Calendar.DATE), 
					dataDeEmprestimo.get(Calendar.MONTH), 
					dataDeEmprestimo.get(Calendar.YEAR), 
                    dataPrevistaDeDevolucao.get(Calendar.DATE), 
                    dataPrevistaDeDevolucao.get(Calendar.MONTH), 
                    dataPrevistaDeDevolucao.get(Calendar.YEAR), 
                    livro.getCodigoLivro());
			
			System.out.println("Emprestimo feito! \n");
		} 
    	catch (CopiaNaoDisponivelEx e) {
			System.out.println(e.getMessage());
		}
    	
    	
    }

    public void devolveLivro(Usuario usuario, Livro livro){
        dataDeDevolucao = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        String dDevolucao = null;
		String dEmprestimo = null;
    	
    	try {
			livro.devolve();
			
			for(Emprestimo emprestimo : usuario.getHistorico()) {
				if(emprestimo.codigoDoLivro.contains(livro.getCodigoLivro())) {
					
					//
					dDevolucao = df.format(dataDeDevolucao.getTime());
					dEmprestimo = df.format(emprestimo.getDataDoEmprestimo().getTime());
					//
					 
					milliseconds = dataDeDevolucao.getTimeInMillis() - emprestimo.getDataDoEmprestimo().getTimeInMillis();
					diasComOLivro = (int)(milliseconds / (1000*60*60*24));

					
					livro.addUsuarioHist(emprestimo.getDataDoEmprestimo().get(Calendar.DATE), 
							emprestimo.getDataDoEmprestimo().get(Calendar.MONTH), 
							emprestimo.getDataDoEmprestimo().get(Calendar.YEAR), 
							dataDeDevolucao.get(Calendar.DATE), 
							dataDeDevolucao.get(Calendar.MONTH), 
							dataDeDevolucao.get(Calendar.YEAR),
							usuario.getCodigoUsuario());
				}
			}
			
			//Se o usuario for o correto a devolver o livro
			if(dDevolucao != null && dEmprestimo !=null) {
				System.out.println("------------------------------------");
				System.out.println("Data de devolucao: " + dDevolucao);
				System.out.println("Data de Emprestimo: " + dEmprestimo);
				System.out.println("Dias com o livro: " + diasComOLivro);
				System.out.println("------------------------------------");				

				if(diasComOLivro > 7) {
					System.out.println("Livro devolvido! <<Atencao!!>> Multa por atraso!");
					System.out.println("------------------------------------------------");
				}
				else {
					System.out.println("Devolvido! \n");
				}
			}
			else {
				System.out.println("<<Atencao!!>> Usuario incorreto. Este usuario nao pegou este livro");
			}
		} 
    	catch (NenhumaCopiaEmprestadaEx e) {
    		System.out.println(e.getMessage());
		}
        
    }

    public String imprimeLivros(){
        for (Map.Entry<String, Livro> e : cadastroDelivros.entrySet()){
            livrosOrdenados.add(e.getValue().getTitulo());
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
            usuariosOrdenados.add(e.getValue().getNome());
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

	public Hashtable<Integer, Usuario> getCadastroDeUsuarios() {
		return cadastroDeUsuarios;
	}

	public Hashtable<String, Livro> getCadastroDelivros() {
		return cadastroDelivros;
	}

	public int getDiasComOLivro() {
		return diasComOLivro;
	}

	public Calendar getDataDeDevolucao() {
		return dataPrevistaDeDevolucao;
	}
    
    
    
}
