import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import lp2g43.biblioteca.Biblioteca;
import lp2g43.biblioteca.Emprestimo;
import lp2g43.biblioteca.Livro;
import lp2g43.biblioteca.Usuario;

public class P7nX {

	static Scanner entrada = new Scanner(System.in);
	static String entradaMenu = "";
	static String entradaCadastro = "";
	
	static String nomeUsuario = "";
	static String enderecoUsuario = "";
	static int codigoUsuario = 0;
	static int dia = 0;
	static int mes = 0;
	static int ano = 0;
	
	static ArrayList<Emprestimo> historicoUsuario = new ArrayList<Emprestimo>();
	static Hashtable<Integer, Usuario> cadastroDeUsuarios = new Hashtable<Integer, Usuario>();
	static Hashtable<String, Livro> cadastroDelivros = new Hashtable<String, Livro>();
	
	static Biblioteca biblioteca = new Biblioteca(cadastroDeUsuarios, cadastroDelivros);

	public static void main(String[] args) {

		while (true) {
			switch (menu()) {
			case "1":
				// Manutencao
				System.out.println("-- Manutencao");
				break;
			case "2":
				// Cadastro
				cadastro();
				break;
			case "3":
				// Emprestimo
				System.out.println("-- Emprestimos");
				break;
			case "4":
				// Relatorio
				System.out.println("-- Relatorios");
				break;

			default:
				System.out.println("Digite uma opcao valida!");
				break;
			}
		}

	}

	public static String menu() {
		entradaMenu = "";

		System.out.println("--- Biblioteca Digital - V1.0 ---");
		System.out.println("Bem vindo! - Digite uma das opcoes do menu");

		System.out.println("  *******************");
		System.out.println("  * 1 - Manutencao  *");
		System.out.println("  * 2 - Cadastros   *");
		System.out.println("  * 3 - Emprestimos *");
		System.out.println("  * 4 - Relatorios  *");
		System.out.println("  *******************");
		entradaMenu = entrada.nextLine();

		return entradaMenu;
	}

	public static void cadastro() {
		entradaCadastro = "";

		System.out.println("-- Cadastro");
		System.out.println("    *******************");
		System.out.println("  * 1 - Cadastrar Usuario *");
		System.out.println("  * 2 - Cadastrar Livro   *");
		System.out.println("  * 3 - Salvar            *");
		System.out.println("  * 4 - Voltar            *");
		System.out.println("    *******************");

		entradaCadastro = entrada.nextLine();
		
		switch (entradaCadastro) {
		case "1":
			System.out.println("-- Cadastrar Usuario");
			cadastrarUsuario();
			break;
		case "2":
			System.out.println("-- Cadastrar Livro");
			
			break;
		case "3":
			System.out.println("-- Salvar");
			break;
		case "4":
			System.out.println("-- Voltar");
			break;
		default:
			System.out.println("Digite uma opcao valida!");
			break;
		}
	}
	
	public static void cadastrarUsuario() {
		//boolean continuar = true;
		
		//while(continuar) {
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
			
			biblioteca.cadastraUsuario(new Usuario(nomeUsuario, dia, mes, ano, enderecoUsuario, codigoUsuario, historicoUsuario));
			
			System.out.println("Usuario cadastrado!");

			System.out.println("Deseja cadastrar outro usuario? (s/n)");
		//}
		
	}

}