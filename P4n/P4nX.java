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
    }

    public static void entDados(){
        String tipoDeFuncionario = "";
        String nome = "";
        String codigoFuncionario = "";
        float salario = 0;
        int numeroDeDependentes = 0;


        while(!tipoDeFuncionario.equals("c") || !tipoDeFuncionario.equals("e")){
            System.out.println("Contratado ou Executivo (c/e)? ");

            tipoDeFuncionario = entrada.nextLine().toLowerCase();
        }

        if(tipoDeFuncionario.equals("c")){
            System.out.println("Nome do Funcionario ");
            System.out.println("Codigo: ");
            System.out.println("Salario");
            System.out.println("Numero de dependentes: ");

            funcionarios.add(new FuncCntrd(nome, codigoFuncionario, salario, numeroDeDependentes));
        }


    }

    public String geraFolha(){
        return "Hello";
    }


    // public void calculaSalarios(){

    // }
}

