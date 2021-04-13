import java.util.Scanner;

public class Ex2nX{

    public static void main(String args[]){

        Scanner entradaTeclado = new Scanner(System.in);
        String entrada = "";
        int tamanhoDaEntrada = 0;
        int[] contaLetra = new int[26];
        int i = 0;
        int index = 0;
        

        while(true){
            System.out.println("Entre com um texto ou digite [enter] para sair");
            entrada = entradaTeclado.nextLine();
            
            if(entrada.equals("")){
                break;
            }

            tamanhoDaEntrada = entrada.length();

            for(i=0; i<tamanhoDaEntrada; i++){
                char letra = entrada.charAt(i);

                if (letra >= 'a' && letra <= 'z'){
                    index = (int)letra - (int)'a';
                    contaLetra[index]++;
                }
            }

            for(i=0; i<contaLetra.length; i++){
                if(contaLetra[i] != 0){
                    System.out.println("Numero de letras " + (char)(97+i) + ": " + contaLetra[i]);
                    contaLetra[i] = 0;
                }
            }
        }
    }
}