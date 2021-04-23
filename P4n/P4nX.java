import java.util.ArrayList;
import java.util.Scanner;

public class P4nX{

    public static int numeroDeFuncionarios = 0;
    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList funcionarios = new ArrayList();


    public P4nX(int numeroDeFuncionarios){
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public static void main(String args[]){

        P4nX instanciaDeClasse = new P4nX(numeroDeFuncionarios);

        System.out.println("Quantos funcionarios? ");
        numeroDeFuncionarios = Integer.parseInt(entrada.nextLine());

        for(int i=0; i<numeroDeFuncionarios; i++){
            entDados();
        }

        for(int i=0; i<numeroDeFuncionarios; i++){
            geraFolha();
        }
    }

    public static void entDados(){
        String tipoDeFuncionario = "";
        String nome = "";
        String codigoFuncionario = "";
        float salario = 0;
        float gratificacao = 0;
        int numeroDeDependentes = 0;


        while(!tipoDeFuncionario.equals("c") || !tipoDeFuncionario.equals("e")){
            System.out.println("Contratado ou Executivo (c/e)? ");

            tipoDeFuncionario = entrada.nextLine().toLowerCase();
        }

        if(tipoDeFuncionario.equals("c")){
            System.out.println("Nome do Funcionario ");
            nome = entrada.nextLine();
    
            System.out.println("Codigo: ");
            codigoFuncionario = entrada.nextLine();

            System.out.println("Salario");
            salario = Float.parseFloat(entrada.nextLine());

            System.out.println("Numero de dependentes: ");
            numeroDeDependentes = Integer.parseInt(entrada.nextLine());

            funcionarios.add(new FuncCntrd(nome, codigoFuncionario, salario, numeroDeDependentes));
        }
        else{
            System.out.println("Nome do Funcionario ");
            nome = entrada.nextLine();
    
            System.out.println("Codigo: ");
            codigoFuncionario = entrada.nextLine();

            System.out.println("Salario");
            salario = Float.parseFloat(entrada.nextLine());

            System.out.println("Numero de dependentes: ");
            numeroDeDependentes = Integer.parseInt(entrada.nextLine());

            System.out.println("Gratificacao: ");
            gratificacao = Float.parseFloat(entrada.nextLine());

            funcionarios.add(new FuncExct(nome, codigoFuncionario, salario, numeroDeDependentes, gratificacao));
        }


    }

    public static String geraFolha(){
        return "Hello";
    }
}

