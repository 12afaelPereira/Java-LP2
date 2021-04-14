public class P1nX{

    public static void main(String args[]){

        switch(args.length){
            case 1:
                float raio = Float.parseFloat(args[0]);

                System.out.println("Area do circulo: " + calcula(raio));
            break;
            case 2:
                float base = Float.parseFloat(args[0]);
                float altura = Float.parseFloat(args[1]);

                System.out.println("Area do retangulo: " + calcula(base, altura));
            break;
            case 3:
                float lado1 = Float.parseFloat(args[0]);
                float lado2 = Float.parseFloat(args[1]);
                float lado3 = Float.parseFloat(args[2]);

                if(!isTriangulo(lado1, lado2, lado3)){
                    System.out.println("Nao e um triangulo");
                    break;
                }
                else{
                    System.out.println("O triangulo e: " + verificaTipoDeTriangulo(lado1, lado2, lado3));
                    System.out.println("Area do triangulo: " + calcula(lado1, lado2, lado3));
                }
            break;
            default:
                System.out.println("numero de parametros invalidos");
        }

    }

    private static double calcula(float raio){
        double areaDoCirculo = 0.0;

        areaDoCirculo = Math.PI * Math.pow(raio,2);

        return areaDoCirculo;
    }

    private static double calcula(float base, float altura){
        double areaDoRetangulo = 0.0;

        areaDoRetangulo = base * altura;

        return areaDoRetangulo;
    }

    private static double calcula(float lado1, float lado2, float lado3){

        String triangulo = verificaTipoDeTriangulo(lado1, lado2, lado3);
        double areaDoTriangulo = 0.0;
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
    
    public static boolean isTriangulo(float lado1, float lado2, float lado3){
        
        return ((lado1 + lado2) <= lado3? false :
                    (lado2 + lado3) <= lado1? false :
                    (lado2 + lado3) <= lado1? false : true);
    }

    public static String verificaTipoDeTriangulo(float lado1, float lado2, float lado3){
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