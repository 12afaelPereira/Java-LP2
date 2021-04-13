import java.util.*;

public class Completar{

    public static void main(String args[]){

        String entrada = args[0].toLowerCase();
        int tamanhoDaEntrada = entrada.length();
        int[] contaLetra = new int[26];
        int i = 0;
        int index = 0;

        // if(args.length == 0 || args[0] == ""){
        //     System.out.println("Entre com um texto");
        // }
        // else{
           
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
                }
            }
        // }
    }
}

        // String line; line = dataFile.readLine(); // Le uma linha por vez
        // int location; char letter;	

        // //************ precisa acertar isso na leitura de teclado ...
        // while (line != null) // Enquando houver linhas a serem lidas
        // {
        //     for (location =0; location<line.length(); location++)
        //     { 
        //         letter = line.charAt(location);
        //         if ((letter  >= 'A' && letter <= 'Z') || (letter  >= 'a' && letter <= 'z'))
        //         {
        //         // 2o truque
        //         index = (int)Character.toUpperCase(letter) - (int) 'A';	
        //             letterCount[index]++;
        //         }
        //     }
        //     line = dataFile.readLine(); // Lê a próxima linha
        // }

        // for (index = 0; index < letterCount.length; index++)
        // {
        // System.out.println("The total number of " + (char)(index + (int)'A') + "'s is " + letterCount[index]);
        // }

   