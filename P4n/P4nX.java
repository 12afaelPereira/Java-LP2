import java.util.ArrayList;
import java.util.Scanner;

public class P4nX{

    public static int numeroDeFuncionarios = 0;
    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList funcionarios;

    public static String tipoDeFuncionario = "";
    public static String nome = "";
    public static String codigoFuncionario = "";
    public static float salario = 0;
    public static float gratificacao = 0;
    public static int numeroDeDependentes = 0;
    public static int numeroEspecial = 0;


    public P4nX(int numeroDeFuncionarios){
        this.numeroDeFuncionarios = numeroDeFuncionarios;

        funcionarios = new ArrayList(numeroDeFuncionarios);
    }

    public static void main(String args[]){

        System.out.println("Quantos funcionarios? ");
        numeroDeFuncionarios = Integer.parseInt(entrada.nextLine());
        
        P4nX instanciaDeClasse = new P4nX(numeroDeFuncionarios);

        System.out.println("--- Cadastro de Funcionarios");

        for(int i=0; i<numeroDeFuncionarios; i++){
            entDados();
            System.lineSeparator();
        }

        System.out.println("\n--- Folha Salarial \n");
        
        geraFolha();
        
    }

    public static void entDados(){
        tipoDeFuncionario = "";

        while(!tipoDeFuncionario.equals("c") && !tipoDeFuncionario.equals("e")){
            System.out.print("Contratado ou Executivo (c/e)? ");

            tipoDeFuncionario = entrada.nextLine().toLowerCase();
        }

        if(tipoDeFuncionario.equals("c")){
            criaFuncionarioContratado();

            funcionarios.add(new FuncCntrd(nome, codigoFuncionario, salario, numeroDeDependentes));
            
        }
        else{
            criaFuncionarioExecutivo();
            funcionarios.add(new FuncExct(nome, codigoFuncionario, salario, numeroDeDependentes, gratificacao));
        }
    }

    public static void geraFolha(){

         funcionarios.forEach( (funcionario) -> System.out.println(funcionario) );

    }

    public static void criaFuncionarioContratado(){
            System.out.print("Nome do Funcionario: ");
            nome = entrada.nextLine();
    
            System.out.print("Codigo: ");
            codigoFuncionario = entrada.nextLine();

            System.out.print("Salario: ");
            salario = Float.parseFloat(entrada.nextLine());

            System.out.print("Numero de dependentes: ");
            numeroDeDependentes = Integer.parseInt(entrada.nextLine());
    }

    public static void criaFuncionarioExecutivo(){
        criaFuncionarioContratado();

        System.out.print("Gratificacao: ");
        gratificacao = Float.parseFloat(entrada.nextLine());
    }
}

