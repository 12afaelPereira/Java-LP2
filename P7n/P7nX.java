import java.util.Scanner;

public class P7nX {

	static Scanner entrada = new Scanner(System.in);
	static String entradaMenu = "";
	static String entradaCadastro = "";

	public static void main(String[] args) {

		while (true) {
			switch (menu()) {
			case "1":
				// Manutencao
				System.out.println("-- Manutencao");
				break;
			case "2":
				// Cadastro
				switch (Cadastro()) {
				case "1":
					System.out.println("-- Cadastrar Usuario");
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

	public static String Cadastro() {
		entradaCadastro = "";

		System.out.println("-- Cadastro");
		System.out.println("    *******************");
		System.out.println("  * 1 - Cadastrar Usuario *");
		System.out.println("  * 2 - Cadastrar Livro   *");
		System.out.println("  * 3 - Salvar            *");
		System.out.println("  * 4 - Voltar            *");
		System.out.println("    *******************");

		return entradaCadastro = entrada.nextLine();
	}

}