import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import lp2g43.biblioteca.Biblioteca;
import lp2g43.biblioteca.EmprestadoPara;
import lp2g43.biblioteca.Emprestimo;
import lp2g43.biblioteca.Livro;
import lp2g43.biblioteca.LivroNaoCadastradoEx;
import lp2g43.biblioteca.Usuario;
import lp2g43.biblioteca.UsuarioNaoCadastradoEx;

public class P7nX {
	static Scanner entrada = new Scanner(System.in);

	static String nomeUsuario = "";
	static String enderecoUsuario = "";
	static int codigoUsuario = 0;
	static int dia = 0;
	static int mes = 0;
	static int ano = 0;
	static ArrayList<Emprestimo> historicoUsuario = new ArrayList<Emprestimo>();

	static String codigoLivro = "";
	static String tituloLivro = "";
	static String categoriaLivro = "";
	static int quantidadeLivro = 0;
	static int livrosEmprestados = 0;
	static ArrayList<EmprestadoPara> historicoLivro = new ArrayList<EmprestadoPara>();

	static FileInputStream streamDoArquivo = null;
	static ObjectInputStream arquivo = null;
	
	static File usuariosCadastrados = null;
	static File livrosCadastrados = null;
	
	static String arquivoCadastroDeUsuarios =  "cadastroDeUsuarios";
	static String arquivoCadastroDeLivros =  "cadastroDeLivros";
	
	static Hashtable<Integer, Usuario> cadastroDeUsuarios = null;
	static Hashtable<String, Livro> cadastroDeLivros = null;
	static Biblioteca biblioteca = null;

	public static void main(String[] args) {
		checkFile();

		boolean sair = false;

		while (!sair) {

			switch (menu()) {
			case "1":
				// Manutencao
				System.out.println("-- Manutencao");
				manutencao();
				break;
			case "2":
				// Cadastro
				System.out.println("-- Cadastro");
				cadastro();
				break;
			case "3":
				// Emprestimo
				System.out.println("-- Emprestimos");
				emprestimo();
				break;
			case "4":
				// Relatorio
				System.out.println("-- Relatorios");
				relatorio();
				break;
			case "5":
				// Sair
				System.out.println("-- Fechando programa!");
				sair = true;
				break;
			default:
				System.out.println("Digite uma opcao valida!");
				break;
			}
		}

	}

	private static void manutencao() {
		String entradaManutencao = "";

		System.out.println("  ***********************");
		System.out.println("  * 1 - Criar arquivos  *");
		System.out.println("  * 2 - Abrir arquivos  *");
		System.out.println("  * 3 - Salvar arquivos *");
		System.out.println("  * 4 - Voltar ao menu  *");
		System.out.println("  ***********************");

		entradaManutencao = entrada.nextLine();

		switch (entradaManutencao) {
		case "1":
			System.out.println("-- Criar Arquivos");
			criarArquivos();
			break;
		case "2":
			System.out.println("-- Abrir arquivos");
			abrirArquivos();
			break;
		case "3":
			System.out.println("-- Salvar arquivos");
			salvarArquivos();
			break;
		case "4":
			System.out.println("-- Voltar");
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			cadastro();
			break;
		}
		
	}


	private static void criarArquivos() {
		String arquivoCadastroDeUsuarios =  "";
		String arquivoCadastroDeLivros =  "";
		
		System.out.println("Digite o nome do arquivo para guardar o cadastro de usuarios: ");
		arquivoCadastroDeUsuarios = entrada.nextLine();
		
		System.out.println("Digite o nome do arquivo para guardar o cadastro de livros: ");
		arquivoCadastroDeLivros = entrada.nextLine();
		
		System.out.println("Arquivo criado!");
		
		cadastroDeLivros = new Hashtable<String, Livro>();
		cadastroDeUsuarios = new Hashtable<Integer, Usuario>();
		
		biblioteca.salvaArquivo(cadastroDeUsuarios, arquivoCadastroDeUsuarios);
		biblioteca.salvaArquivo(cadastroDeLivros, arquivoCadastroDeLivros);
		
		System.out.println("\n");
		
		biblioteca = new Biblioteca(cadastroDeUsuarios, cadastroDeLivros);
		
		System.out.println("Agora voce esta trabalhando com os arquivos '"+ arquivoCadastroDeUsuarios +"' e '"+ arquivoCadastroDeLivros +"' \n");
	}
	
	private static void abrirArquivos() {
		
		System.out.println("Digite o nome do arquivo de cadastro de usuarios para abrir: ");
		arquivoCadastroDeUsuarios = entrada.nextLine();
		
		System.out.println("Digite o nome do arquivo de cadastro de livros para abrir: ");
		arquivoCadastroDeLivros = entrada.nextLine();
		
		usuariosCadastrados = new File(arquivoCadastroDeUsuarios);
		livrosCadastrados = new File(arquivoCadastroDeLivros);
		
		if (usuariosCadastrados.exists() && livrosCadastrados.exists()) {
			
			try{
	            streamDoArquivo = new FileInputStream(arquivoCadastroDeUsuarios);
	            arquivo = new ObjectInputStream(streamDoArquivo);

	        	cadastroDeUsuarios = (Hashtable<Integer, Usuario>) arquivo.readObject();
	        	
	        	arquivo.close();
	        	streamDoArquivo.close();
	            
	        	
	        	streamDoArquivo = new FileInputStream(arquivoCadastroDeLivros);
	            arquivo = new ObjectInputStream(streamDoArquivo);
	            
	        	cadastroDeLivros = (Hashtable<String, Livro>) arquivo.readObject();
	        	
	        	arquivo.close();
	        	streamDoArquivo.close();
	            
	        	
	        	biblioteca = new Biblioteca(cadastroDeUsuarios, cadastroDeLivros);
	        	
	        	System.out.println("Arquivos Carregados!  \n");
	        }
	        catch(IOException | ClassNotFoundException e){
	            System.out.println("Ocorreu um erro");
	            e.printStackTrace();
	        }
			
		}
		else {
			System.out.println("Arquivo inexistente! verifique se o arquivo foi criado ou se esta no diretorio correto. ");
		}
		
	}
	
	private static void salvarArquivos() {
		String entradaSalvarArquivos = "";
		
		System.out.println("\n-------------------------- ATENCAO --------------------------");
		System.out.println("| Cuiado para nao sobrescrever sem querer os arquivos atuais ! |");
		System.out.println("--------------------------------------------------------------- \n");
		
		
		while(!entradaSalvarArquivos.toLowerCase().equals("s") && !entradaSalvarArquivos.toLowerCase().equals("n")) {
			System.out.println("Deseja salvar os arquivos atuais ("+ arquivoCadastroDeUsuarios +" e " + arquivoCadastroDeLivros + ")? (s/n)");
			entradaSalvarArquivos = entrada.nextLine();
		}
		
		if(entradaSalvarArquivos.toLowerCase().equals("s")) {
			biblioteca.salvaArquivo(cadastroDeUsuarios, arquivoCadastroDeUsuarios);
			biblioteca.salvaArquivo(cadastroDeLivros, arquivoCadastroDeLivros);
			
			System.out.println("Salvando...");			
		}
		System.out.println("\n");
	}


	public static void checkFile() {
		// Se os arquivos existirem carrega nos hashtables - senao cria hashtables
		// zerados

		usuariosCadastrados = new File("CadastroDeUsuarios");
		livrosCadastrados = new File("CadastroDeLivros");

		if (usuariosCadastrados.exists() && livrosCadastrados.exists()) {
			biblioteca = new Biblioteca("CadastroDeUsuarios", "CadastroDeLivros");
			cadastroDeLivros = biblioteca.getCadastroDelivros();
			cadastroDeUsuarios = biblioteca.getCadastroDeUsuarios();
			
			System.out.println("\n---------------------- ATENCAO ----------------------");
			System.out.println("| Arquivos padrao carregados ('CadastroDeUsuarios' e 'CadastroDeLivros')");
			System.out.println("| Carregue novos arquivos na secao 'Manutencao'");
			System.out.println("------------------------------------------------------- \n");
		} else {
			cadastroDeLivros = new Hashtable<String, Livro>();
			cadastroDeUsuarios = new Hashtable<Integer, Usuario>();
			biblioteca = new Biblioteca(cadastroDeUsuarios, cadastroDeLivros);
		}

	}

	public static String menu() {
		String entradaMenu = "";

		System.out.println("--- Biblioteca Digital - V1.0 ---");
		System.out.println("Bem vindo! - Digite uma das opcoes do menu");

		System.out.println("  *******************");
		System.out.println("  * 1 - Manutencao  *");
		System.out.println("  * 2 - Cadastros   *");
		System.out.println("  * 3 - Emprestimos *");
		System.out.println("  * 4 - Relatorios  *");
		System.out.println("  * 5 - Sair        *");
		System.out.println("  *******************");
		entradaMenu = entrada.nextLine();

		return entradaMenu;
	}

	public static void cadastro() {
		String entradaCadastro = "";

		System.out.println("  *************************");
		System.out.println("  * 1 - Cadastrar Usuario *");
		System.out.println("  * 2 - Cadastrar Livro   *");
		System.out.println("  * 3 - Salvar            *");
		System.out.println("  * 4 - Voltar ao menu    *");
		System.out.println("  *************************");

		entradaCadastro = entrada.nextLine();

		switch (entradaCadastro) {
		case "1":
			System.out.println("-- Cadastrar Usuario");
			cadastrarUsuario();
			break;
		case "2":
			System.out.println("-- Cadastrar Livro");
			cadastrarLivro();
			break;
		case "3":
			System.out.println("-- Salvar cadastro");
			salvarCadastro();
			break;
		case "4":
			System.out.println("-- Voltar");
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			cadastro();
			break;
		}
	}

	public static void cadastrarUsuario() {
		String continuar = "s";

		while (continuar.toLowerCase().equals("s")) {
			System.out.println("Digite o nome do usuario: ");
			nomeUsuario = entrada.nextLine();

			System.out.println("Dia do nascimento: ");
			dia = Integer.parseInt(entrada.nextLine());

			System.out.println("Mes do nascimento: ");
			mes = Integer.parseInt(entrada.nextLine());

			System.out.println("Ano do nascimento: ");
			ano = Integer.parseInt(entrada.nextLine());

			System.out.println("Endereco do usuario: ");
			enderecoUsuario = entrada.nextLine();

			System.out.println("Digite um codigo para o usuario: (inteiro)");
			codigoUsuario = Integer.parseInt(entrada.nextLine());

			biblioteca.cadastraUsuario(
					new Usuario(nomeUsuario, dia, mes, ano, enderecoUsuario, codigoUsuario, historicoUsuario));

			System.out.println("Usuario cadastrado!");

			System.out.println("Deseja cadastrar outro usuario? (s/n)");
			continuar = entrada.nextLine();
		}

	}

	public static void cadastrarLivro() {
		String continuar = "s";

		while (continuar.toLowerCase().equals("s")) {
			System.out.println("Titulo do livro: ");
			tituloLivro = entrada.nextLine();

			System.out.println("Digite o codigo do livro: (string) ");
			codigoLivro = entrada.nextLine();

			System.out.println("Categoria: ");
			categoriaLivro = entrada.nextLine();

			System.out.println("Quantidade de exemplares: ");
			quantidadeLivro = Integer.parseInt(entrada.nextLine());

			// System.out.println("Livros emprestados: ");
			// livrosEmprestados = Integer.parseInt(entrada.nextLine());

			biblioteca.cadastraLivro(new Livro(codigoLivro, tituloLivro, categoriaLivro, quantidadeLivro, 0));

			System.out.println("Livro cadastrado!");

			System.out.println("Deseja cadastrar outro Livro? (s/n)");
			continuar = entrada.nextLine();
		}

	}

	public static void salvarCadastro() {
		String entradaSalvarCadastro = "";

		System.out.println("  **********************************");
		System.out.println("  * 1 - Salvar cadastro de usuario *");
		System.out.println("  * 2 - Salvar cadastro de livro   *");
		System.out.println("  * 3 - Voltar ao Menu             *");
		System.out.println("  **********************************");

		entradaSalvarCadastro = entrada.nextLine();

		switch (entradaSalvarCadastro) {
		case "1":
			System.out.println("-- Salvando cadastro de usuario");
			biblioteca.salvaArquivo(cadastroDeUsuarios, "CadastroDeUsuarios");

			break;
		case "2":
			System.out.println("-- Salvando cadastro de livro");
			biblioteca.salvaArquivo(cadastroDeLivros, "CadastroDeLivros");

			break;
		case "3":
			System.out.println("-- Voltando pro menu");
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			salvarCadastro();
			break;
		}
	}

	public static void emprestimo() {
		String entradaEmprestimo = "";

		System.out.println("  **********************************");
		System.out.println("  * 1 - Exibir cadastro de livros  *");
		System.out.println("  * 2 - Fazer emprestimo           *");
		System.out.println("  * 3 - Devolucao                  *");
		System.out.println("  * 4 - Voltar ao menu             *");
		System.out.println("  **********************************");

		entradaEmprestimo = entrada.nextLine();

		switch (entradaEmprestimo) {
		case "1":
			System.out.println("-- Acervo de livros");

			for (Map.Entry<String, Livro> livro : biblioteca.getCadastroDelivros().entrySet()) {

				System.out.println("----------- Livro -----------");
				System.out.println(livro.getValue());
			}

			break;
		case "2":
			System.out.println("-- Fazer emprestimo");
			fazerEmprestimo();

			break;
		case "3":
			System.out.println("-- Devolucao");
			devolucao();
			break;
		case "4":
			System.out.println("-- Voltando pro menu");
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			emprestimo();
			break;
		}

	}


	public static void fazerEmprestimo() {

		String codLivro = "";
		int codUsuario = 0;

		while (true) {
			System.out.println("Codigo do livro a ser emprestado: ");
			codLivro = entrada.nextLine();

			try {
				biblioteca.getLivro(codLivro);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		while (true) {
			System.out.println("Codigo do usuario para quem sera emprestado: ");
			codUsuario = Integer.parseInt(entrada.nextLine());

			try {
				biblioteca.getUsuario(codUsuario);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			biblioteca.emprestaLivro(biblioteca.getUsuario(codUsuario), biblioteca.getLivro(codLivro));
		} catch (UsuarioNaoCadastradoEx | LivroNaoCadastradoEx e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void devolucao() {
		String codLivro = "";
		int codUsuario = 0;

		while (true) {
			System.out.println("Codigo do livro a ser devolvido: ");
			codLivro = entrada.nextLine();

			try {
				biblioteca.getLivro(codLivro);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		while (true) {
			System.out.println("Codigo do usuario a devolver o livro: ");
			codUsuario = Integer.parseInt(entrada.nextLine());

			try {
				biblioteca.getUsuario(codUsuario);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		try {
			biblioteca.devolveLivro(biblioteca.getUsuario(codUsuario), biblioteca.getLivro(codLivro));
		} catch (UsuarioNaoCadastradoEx | LivroNaoCadastradoEx e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	private static void relatorio() {
		String entradaRelatorio = "";

		System.out.println("  *****************************");
		System.out.println("  * 1 - Acervo de livros      *");
		System.out.println("  * 2 - Usuarios cadastrados  *");
		System.out.println("  * 3 - Detalhes de Usuario   *");
		System.out.println("  * 4 - Detalhes de livro     *");
		System.out.println("  * 5 - Voltar ao menu        *");
		System.out.println("  *****************************");

		entradaRelatorio = entrada.nextLine();

		switch (entradaRelatorio) {
		case "1":
			System.out.println("-- Acervo de livros");

			System.out.println(biblioteca.imprimeLivros());
			break;
		case "2":
			System.out.println("-- Cadastro de usuarios");

			System.out.println(biblioteca.imprimeUsuarios());
			break;
		case "3":
			System.out.println("-- Usuario - Detalhes");
			detalhesUsuario();
			break;
		case "4":
			System.out.println("-- Livro - Detalhes");
			detalhesLivro();
			break;
		case "5":
			System.out.println("-- Voltando pro menu");
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			relatorio();
			break;
		}
	}
	
	public static void detalhesUsuario() {
		String entradaDetalhesUsuario = "";

		System.out.println("  *****************************");
		System.out.println("  * 1 - listar pelo codigo    *");
		System.out.println("  * 2 - Listar pelo nome      *");
		System.out.println("  * 3 - Voltar                *");
		System.out.println("  *****************************");

		entradaDetalhesUsuario = entrada.nextLine();

		switch (entradaDetalhesUsuario) {
		case "1":
			System.out.println("-- Lista pelo codigo");

			int codUsuario = 0;

			System.out.println("Digite o codigo do usuario (inteiro)");

			try {
				codUsuario = Integer.parseInt(entrada.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Digite um numero inteiro!");
			}


			try {
				System.out.println("---------- Usuario ----------");
				System.out.println(biblioteca.getUsuario(codUsuario));
				System.out.println("-----------------------------");
				
			} catch (UsuarioNaoCadastradoEx e) {
				System.out.println(e.getMessage());
			}
			

			break;
		case "2":
			System.out.println("-- Lista pelo nome");

			String nomeUsuario = "";

			System.out.println("Digite o nome do usuario");
			nomeUsuario = entrada.nextLine();

			for (Entry<Integer, Usuario> usuario : biblioteca.getCadastroDeUsuarios().entrySet()) {

				if (usuario.getValue().getNome().toLowerCase().equals(nomeUsuario.toLowerCase())) {
					System.out.println("---------- Usuario ----------");
					System.out.println(usuario.getValue());
					System.out.println("-----------------------------");
				}
			}
			break;
		case "3":
			System.out.println("-- Relatorios ");
			relatorio();
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			detalhesUsuario();
			break;
		}

	}

	public static void detalhesLivro() {
		String entradaDetalhesLivro = "";

		System.out.println("  *****************************");
		System.out.println("  * 1 - listar pelo codigo    *");
		System.out.println("  * 2 - Listar pelo titulo    *");
		System.out.println("  * 3 - Voltar                *");
		System.out.println("  *****************************");

		entradaDetalhesLivro = entrada.nextLine();

		switch (entradaDetalhesLivro) {
		case "1":
			System.out.println("-- Lista pelo codigo");

			String codLivro = "";

			System.out.println("Digite o codigo do livro");
			codLivro = entrada.nextLine();

			try {
				System.out.println("----------- Livro -----------");
				System.out.println(biblioteca.getLivro(codLivro));
				System.out.println("-----------------------------");
				
			} catch (LivroNaoCadastradoEx e) {
				System.out.println(e.getMessage());
			}

			break;
		case "2":
			System.out.println("-- Lista pelo titulo");

			String tituloLivro = "";

			System.out.println("Digite o titulo do livro");
			tituloLivro = entrada.nextLine();

			for (Map.Entry<String, Livro> livro : biblioteca.getCadastroDelivros().entrySet()) {

				if (livro.getValue().getTitulo().toLowerCase().equals(tituloLivro.toLowerCase())) {
					System.out.println("----------- Livro -----------");
					System.out.println(livro.getValue());
					System.out.println("-----------------------------");
				}
			}

			break;
		case "3":
			System.out.println("-- Relatorios ");
			relatorio();
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			detalhesLivro();
			break;
		}

	}

	

}