import java.util.Scanner;

public class P3nX{

    public static void main(String args[]){

        Scanner entrada = new Scanner(System.in);
        int numeroDeAngulos = 0;
        double medidaDoAngulo = 0;
        int i= 0;


        System.out.println("Digite o numero de angulos: ");

        try{
            numeroDeAngulos = Integer.parseInt(entrada.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Erro. Digite apenas numeros");
        }

        AnguloObj[] calculosComAngulo = new AnguloObj[numeroDeAngulos];


        // Lendo angulos
        for(i=0; i<numeroDeAngulos; i++){
            System.out.println("Digite a medida do " + (i+1) + " angulo: ");

            try{
                medidaDoAngulo = Double.parseDouble(entrada.nextLine());
                calculosComAngulo[i] = new AnguloObj(medidaDoAngulo);

            }
            catch(NumberFormatException e){
                System.out.println("Erro. Digite apenas numeros");
            }

        }

        
        try{
            for(i=0; i<numeroDeAngulos; i++){
                // System.out.println("Resultado ==========================================");
                System.out.println( calculosComAngulo[i].toString() );
            }
        }
        catch(NullPointerException e){
            System.out.println("Erro.");
        }
    }
}
