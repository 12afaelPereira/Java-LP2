import java.util.Scanner;

public class P2nX{

    public static void main(String args[]){

        Scanner entradaTeclado = new Scanner(System.in);
        String entrada = "";
        double angulo = 0;
        Angulo calculos = null;
        
        if(args.length == 1){
            angulo = Double.parseDouble(args[0]);
            
            calculos = new Angulo();
            System.out.println(calculos.toString(angulo));
        }

        while(true){
            System.out.println("Digite uma medida em graus do angulo ou [enter] para sair");
            entrada = entradaTeclado.nextLine();
            
            if(entrada.equals("")){
                break;
            }

            angulo = Double.parseDouble(entrada);
            calculos = new Angulo();
            System.out.println(calculos.toString(angulo));
        }
    }
}