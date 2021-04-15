import java.util.Scanner;

public class P2nX{

    public static void main(String args[]){

        Scanner entradaTeclado = new Scanner(System.in);
        String entrada = "";
        double angulo = 0;
        
        if(args.length == 1){
            try{
                angulo = Double.parseDouble(args[0]);
                System.out.println(imprimeResultado(angulo));
            }
            catch(NumberFormatException e){
                System.out.println("Erro. Digite apenas numeros");
            }

        }
        else if(args.length > 1){
            System.out.println("Numero de argumentos invalido");
        }
        

        while(true){
            System.out.println("Digite uma medida em graus do angulo ou [enter] para sair");
            entrada = entradaTeclado.nextLine();
            
            if(entrada.equals("")){
                break;
            }

            try{
                angulo = Double.parseDouble(entrada);

                System.out.println(imprimeResultado(angulo));
            }
            catch(NumberFormatException e){
                System.out.println("Erro. Digite apenas numeros");
            }
        }
    }

    private static String imprimeResultado(double angulo){

        return "Seno: " + String.format("%.2f", Angulo.fSeno(angulo)) + System.lineSeparator()
        + "Cosseno: " + String.format("%.2f", Angulo.fCos(angulo)) + System.lineSeparator()
        + "Tangente: " + String.format("%.2f", Angulo.fTangente(angulo)) + System.lineSeparator()
        + "Cotangente: " + String.format("%.2f", Angulo.fCotangente(angulo)) + System.lineSeparator(); 
    }
}