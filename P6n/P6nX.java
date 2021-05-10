import java.util.ArrayList;
import java.util.Scanner;

    public class P6nX{
        public static Scanner entrada = new Scanner(System.in);
        public static String numero = "";
        public static int numeroDePessoas = 0;
        public static String opcaoDoMenu = "";
        public static String modoDeOrdenacao = "";
        public static String genero = "";
        public static String nome = "";
        public static String dataDeNascimento = "";
        public static String peso = "";
        public static String altura = "";
        public static MinhaListaOrdenavel listaOrdenavel = new MinhaListaOrdenavel();

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

            menu();
            System.out.println("Minha lista ordenada...");
            System.out.println(listaOrdenavel.toString());
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
                listaOrdenavel.add(new Homem(nome, dataDeNascimento, Double.parseDouble(peso), Double.parseDouble(altura)));
            }
            else{
                listaOrdenavel.add(new Mulher(nome, dataDeNascimento, Double.parseDouble(peso), Double.parseDouble(altura)));
            }
        }

        public static void menu(){
            opcaoDoMenu = "";
            modoDeOrdenacao = "";

            System.out.println("1. Imprimir Lista");
            System.out.println("2. Sair");
            
            while(!isInt(opcaoDoMenu)){
                System.out.println("Digite sua opcao: ");
                opcaoDoMenu = entrada.nextLine();

                if(!isInt(opcaoDoMenu)){
                    System.out.println("--- A opcao deve ser um numero inteiro!!!");
                }
                else if(Integer.parseInt(opcaoDoMenu) < 1 || Integer.parseInt(opcaoDoMenu) > 2){
                    System.out.println("--- A opcao deve ser o numero 1 ou 2!!!");
                }
            }

            System.out.println("Escolha seu modo de oredenacao");
            System.out.println("1. Alfabetica (A-Z)");
            System.out.println("2. Alfabetica (Z-A)");
            System.out.println("3. Menor Peso");
            System.out.println("4. Maior Peso");
            System.out.println("5. Menor Altura");
            System.out.println("6. Menor IMC");
            
            while(!isInt(modoDeOrdenacao)){
                System.out.println("Digite sua opcao: ");
                modoDeOrdenacao = entrada.nextLine();

                if(!isInt(modoDeOrdenacao)){
                    System.out.println("--- A opcao deve ser um numero inteiro!!!");
                }
                else if(Integer.parseInt(modoDeOrdenacao) < 1 || Integer.parseInt(modoDeOrdenacao) > 6){
                    System.out.println("--- A opcao deve ser um numero entre 1 e 5!!!");
                }
            }

            listaOrdenavel.ordena(Integer.parseInt(modoDeOrdenacao));
            listaOrdenavel.toString();
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