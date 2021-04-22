import java.util.ArrayList;
import java.util.Scanner;

public class P4nX{

    public static int numeroDeObjetosFuncCntrl = 0;
    public static int numeroDeObjetosFuncionarioExct = 0;


    public P4nX(int numeroDeObjetosFuncCntrl, int numeroDeObjetosFuncionarioExct){
        this.numeroDeObjetosFuncCntrl = numeroDeObjetosFuncCntrl;
        this.numeroDeObjetosFuncionarioExct = numeroDeObjetosFuncionarioExct;
    }

    public static void main(String args[]){

        P4nX instanciaDeClasse = new P4nX(numeroDeObjetosFuncCntrl, numeroDeObjetosFuncionarioExct);

        System.out.println(instanciaDeClasse.sayHello());
        

        Scanner entrada = new Scanner(System.in);
        ArrayList<FuncionarioExct> executivos = new ArrayList<>();
        ArrayList<FuncCntrd> contratados = new ArrayList<>();

        System.out.println("Quantos contradados ?");
        numeroDeObjetosFuncCntrl = Integer.parseInt(entrada.nextLine());

        

        System.out.println("Quantos executivos ?");
        numeroDeObjetosFuncionarioExct = Integer.parseInt(entrada.nextLine());

        // FuncCntrd subFunc = new FuncCntrd("Rafael", "007", 500, 0);

        // subFunc.calculaSalario();
        // System.out.println(subFunc.toString());

        // FuncionarioExct subSubFunc = new FuncionarioExct("Jose", "008", 500, 2, 100);

        // subSubFunc.calculaSalario();
        // System.out.println(subSubFunc.toString());
    }

    public String sayHello(){
        return "Hello";
    }

    public void calculaSalarios(){

    }
}

