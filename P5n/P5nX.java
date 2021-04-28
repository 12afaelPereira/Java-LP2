import java.util.ArrayList;
import java.util.Scanner;

    public class P5nX{
        public static Scanner entrada = new Scanner(System.in);
        public static String numero = "";
        public static int numeroDePessoas = 0;
        public static String genero = "";
        public static ArrayList pessoas = new ArrayList();
        public static String nome = "";
        public static String dataDeNascimento = "";
        public static String peso = "";
        public static String altura = "";

        public static void main(String[] args){

            while(!isInt(numero)){
                System.out.println("Digite o numero de pessoas");
                numero = entrada.nextLine();

                if(!isInt(numero)){
                    System.out.println("--- O numero de pessoas deve ser um numero inteiro!!!");
                }
            }

            numeroDePessoas = Integer.parseInt(numero);

            for(int i=0; i<numeroDePessoas; i++){
                entradaDeDados();
                System.lineSeparator();
            }

            imprimeDados();
        }

        public static void entradaDeDados(){
            genero = "";
            peso = "";
            altura = "";

            while(!genero.equals("h") && !genero.equals("m")){
                System.out.println("Inserir homem (h) ou mulher (m) ");

                genero = entrada.nextLine().toLowerCase();

                if(!genero.equals("h") && !genero.equals("m")){
                    System.out.println("--- Opcao Invalida!!!");
                }
            }

            System.out.println("Digite o nome: ");
            nome = entrada.nextLine();

            System.out.println("Digite a data de nascimento: ");
            dataDeNascimento = entrada.nextLine();

            while(!isDouble(peso)){
                System.out.println("Digite o peso: ");
                peso = entrada.nextLine();

                if(!isDouble(peso)){
                    System.out.println("--- O peso deve ser um numero real!!!");
                }
            }

            while(!isDouble(altura)){
                System.out.println("Digite a altura (em metros): ");
                altura = entrada.nextLine();

                if(!isDouble(altura)){
                    System.out.println("--- A altura deve ser um numero real!!!");
                }
            }

            if(genero.equals("h")){
                pessoas.add(new Homem(nome, dataDeNascimento, Double.parseDouble(peso), Double.parseDouble(altura)));
            }
            else{
                pessoas.add(new Mulher(nome, dataDeNascimento, Double.parseDouble(peso), Double.parseDouble(altura)));
            }   
        }

        public static void imprimeDados(){
            pessoas.forEach( (pessoa) -> {
                System.out.println("--------");
                System.out.println(pessoa);
                System.out.println("--------");
            });
        }

        public static boolean isDouble(String number){
            try{
                Double.parseDouble(number);
            }
            catch(NumberFormatException e){
                return false;
            }
            return true;
        }

        public static boolean isInt(String number){
            try{
                Integer.parseInt(number);
            }
            catch(NumberFormatException e){
                return false;
            }
            return true;
        }
    }