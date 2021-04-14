public class P1nX{

    public static void main(String args[]){

        switch(args.length){
            case 1:
                try{
                    double raio = Double.parseDouble(args[0]);
                    System.out.printf("Area do circulo: %.2f unidades de area\n", calcula(raio));
                }
                catch(NumberFormatException e){
                    System.out.println("Erro, digite apenas numeros");
                }
            break;
            case 2:
                try{
                    double base = Double.parseDouble(args[0]);
                    double altura = Double.parseDouble(args[1]);
                    System.out.printf("Area do retangulo: %.2f unidades de area\n", calcula(base, altura));
                }
                catch(NumberFormatException e){
                    System.out.println("Erro, digite apenas numeros");
                }
            break;
            case 3:
                try{
                    double lado1 = Double.parseDouble(args[0]);
                    double lado2 = Double.parseDouble(args[1]);
                    double lado3 = Double.parseDouble(args[2]);

                    if(!isTriangulo(lado1, lado2, lado3)){
                        System.out.println("Nao e um triangulo");
                        break;
                    }
                    else{
                        System.out.println("O triangulo e: " + verificaTipoDeTriangulo(lado1, lado2, lado3));
                        System.out.printf("Area do triangulo: %.2f unidades de area\n", calcula(lado1, lado2, lado3));
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Erro, digite apenas numeros");
                }
            break;
            default:
                System.out.println("numero de parametros invalidos");
        }
    }

    private static double calcula(double raio){
        double areaDoCirculo = 0;

        areaDoCirculo = Math.PI * Math.pow(raio,2);

        return areaDoCirculo;
    }

    private static double calcula(double base, double altura){
        double areaDoRetangulo = 0;

        areaDoRetangulo = base * altura;

        return areaDoRetangulo;
    }

    private static double calcula(double lado1, double lado2, double lado3){

        String triangulo = verificaTipoDeTriangulo(lado1, lado2, lado3);
        double areaDoTriangulo = 0;
        double altura = 0;
        double semiperimetro = 0;

        switch(triangulo){
            case "isosceles":
                if(lado1 == lado2){
                    altura = Math.sqrt(Math.pow(lado1,2)-Math.pow((lado3/2),2));
                    areaDoTriangulo = (lado3*altura)/2;
                }
                else if(lado1 == lado3){
                    altura = Math.sqrt(Math.pow(lado1,2)-Math.pow((lado2/2),2));
                    areaDoTriangulo = (lado2*altura)/2;
                }
                else{
                    altura = Math.sqrt(Math.pow(lado2,2)-Math.pow((lado1/2),2));
                    areaDoTriangulo = (lado1*altura)/2;
                }
            break;
            case "escaleno":
                semiperimetro = (lado1 + lado2 + lado3)/2;
                areaDoTriangulo = Math.sqrt(semiperimetro*(semiperimetro-lado1)*(semiperimetro-lado2)*(semiperimetro-lado3));
            break;
            case "equilatero":
                areaDoTriangulo = (Math.pow(lado1, 2) * Math.sqrt(3))/4;
            break;
        }

        return areaDoTriangulo;
    }
    
    private static boolean isTriangulo(double lado1, double lado2, double lado3){
        
        return ((lado1 + lado2) <= lado3? false :
                    (lado1 + lado3) <= lado2? false :
                    (lado2 + lado3) <= lado1? false : true);
    }

    private static String verificaTipoDeTriangulo(double lado1, double lado2, double lado3){
        if((lado1 == lado2) && (lado2 == lado3)){
            return "equilatero";
        }
        else if((lado1 != lado2) && (lado1 != lado3) && (lado2 != lado3)){
            return "escaleno";
        }
        else{
            return "isosceles";
        }
    }

    

}