Programa 3 (valendo nota) – P3n 

Crie a classe AnguloObj, que tem papel semelhante à da classe Angulo do exercício anterior com as  seguintes modificações (o objetivo é comparar os dois estilos de arquitetura): 

• A classe possui o campo privativo (encapsulado), double, arcoRad que é a medida em radianos  de um ângulo. 

• A classe deverá ter um construtor que recebe um valor do tipo double, que é a medida de um  ângulo em graus, e o converte para radianos, e armazena no campo arcoRad. 

• Seus métodos (os mesmos listados para a classe Angulo) agora devem ser **métodos de  instância**, e não recebem parâmetros (obs: não recebem parâmetros, neste exercício – “não  receber parâmetros” não caracteriza métodos de instância), mas devolvem um double. 

• A classe anguloObj também implementa o método toString() que retorna uma instância da  classe String na seguinte forma:  

```
Arco: <medida em radianos do ângulo> rad 
Cosseno: <valor> 
Tangente: <valor> 
Cotangente: <valor> 
```

O programa principal deve perguntar quantos ângulos o usuário quer digitar por stream (fluxo de  entrada por teclado) e criar um array de objetos da classe AnguloObj, onde serrão armazenados  objetos criados. Criar instâncias da classe AnguloObj, (número de objetos foi passado pelo usuário)  lendo do teclado via stream a medida dos ângulos, e armazenar cada um no array. Você vai ter que  desenvolver uma rotina de entrada para isso. 

Faça o seu código modular, bem estrututrado. 

Em seguida (depois de ler todos os ângulos), iterar pelo array, calcular suas funções  trigonométricas e exibir o resultado (se você for "esperto" isso fica bem simples).  

As exceções de entrada devem ser tratadas convenientemente. 

Exemplo (veja como não arredondar a saída exibida fica ruim):

```
>java Ex3 
Digite o numero de angulos: 
2 
Digite a medida em graus do primeiro angulo: 
90 
Digite a medida em graus do segundo angulo: 
60 
Resultado ===================== 
Arco: 1.5707963267948966 
Seno: 1.0 
Cosseno: 6.123233995736766E-17 [arredondar]! 
Tangente: 1.633123935319537E16 
Cotangente: 6.123233995736766E-17 
Arco: 1.0471975511965976 
Seno: 0.8660254037844386 
Cosseno: 0.5000000000000001 
Tangente: 1.7320508075688767 
Cotangente: 0.577350269189626
```



