**Programa 1 (valendo nota)**

Fazer um programa que calcule a área de 3 tipos de figuras: círculos, retângulos e triângulos dependendo da entrada recebida, e imprima seus valores de acordo.  

• Caso a figura seja um círculo é passado o raio do circulo; 

• Caso a figura seja um retângulo é passado base e altura; 

• Caso a figura seja um triângulo, o comprimento dos lados do Triângulo será passado. 

Os valores devem ser passados como argumentos de linha de comando, valores com tipo double. Você vai identificar o tipo de figura com base no número de argumentos passados. 

O cálculo da área deve ser feito em um método de classe, chamado calcula cujas assinaturas são dadas a  seguir.  

```
private static double calcula(float r)  
private static double calcula(float b, float a)  
private static double calcula(float l1, floatl2, floatl3)  
```

Chame estes métodos para fazer os cálculos (tornando o programa mais modular).  

No caso de ser um triângulo, classifique também se ele é: equilátero, isósceles ou escaleno. Para  isso crie outro método de classe e use o mesmo.

Utilize técnicas de criticas de dados e/ou tratamento de exceções para capturar problemas de  entrada: número insuficiente de argumentos, número de excessivo de argumentos, argumentos que  não sejam convertíveis para double, argumento(s) inválido(s), argumentos que não formam um  triângulo.  

Cada problema deve ser capturado e mostrado individualmente para o usuário. 

Depois de executar o cálculo e a exibição o programa termina. Se houver algum problema  detectado nos argumentos, a mensagem é exibida e o programa também termina. 

Exemplos de execução (arredonde o número de casas decimais): 
>java Ex1 1.3  
A area do circulo e’: XXX unidades de area.  
>java Ex1 3.0 4.0 5.0  
A area do triangulo e': XXX unidades de area.  
O triangulo e' isosceles.  
>java Ex1  
Número de argumentos insuficiente  
>java Ex1 0 1 3.7 9.5  
Numero de argumentos excessivo  
>java Ex1 a 0 0xD  
1o argumento, “a”, nao eh numero  
3o argumento, “0xD”, nao eh numero 


Para esta 1ª experiência, o programa principal pode ser codificado todo no método main (sabendo que  isso não é incentivado)
