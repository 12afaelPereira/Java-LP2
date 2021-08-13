**Programa 2 (valendo nota) – P2n**

Crie uma classe Angulo que deverá ter os seguintes métodos de classe: 

• **cvtAngulo** que recebe como parâmetro um valor do tipo double que é a medida em graus de  um ângulo e retorna um valor do tipo double que é a medida deste ângulo em radianos. 

• **fSeno** que recebe como parâmetro um ângulo e retorna um valor do tipo double que é o seno  deste ângulo. 

• **fCoseno** que recebe como parâmetro um ângulo e retorna um valor do tipo double que é o  coseno deste ângulo. 

• **fTangente** que recebe como parâmetro um ângulo e retorna um valor do tipo double que é a  tangente deste ângulo. 

• **fCotangente** que recebe como parâmetro um ângulo e retorna um valor do tipo double que é a  cotangente deste ângulo. 

Para implementar os métodos anteriores, os métodos da classe Math podem ser embrulhados  (wrapped). Observem que todos eles recebem um parâmetro double (tipo primitivo) e retornam  como resultado um valor double. 

Crie uma classe para o programa principal, com o método main() que: 

• aceite como argumento da linha de comando a medida em graus de um ângulo, e utiliza os  métodos da classe Angulo para convertê-lo para radianos e calcular o valor de suas funções  trigonométricas, imprimindo estes valores. Arredonde a saída. 

• havendo ou não um parâmetro de entrada na linha de comando, ao se iniciar a execução do  programa (ou seja, depois de executar a rotina com o valor passado na linha de comando),  também leia, através de um fluxo de entrada, a medida em graus de um ângulo, e utilize os  métodos da classe Angulo para convertê-lo para radianos e calcular o valor de suas funções  trigonométricas, imprimindo estes valores.  

• logo após o usuário pode entrar com um novo ângulo. A entrada de uma String vazia  (simplesmente pressionando ENTER) encerra a leitura de valores e a aplicação.

• Critique os dados e/ou trate as exceções de entrada (exceções de E/S, de conversão e passagem  de argumentos inválidos).

Exemplo de saída (veja como o não arredondamento pode ficar “desnecessário”):

```
>java Ex1 60  
Seno: 0.87
Cosseno: 0.50 
Tangente: 1.73 
Cotangente: 0.58
Digite uma medida em graus do angulo: 
90 
Seno: 1.0 
Cosseno: 6.123233995736766E-17 [arredondar]! 
Tangente: 1.633123935319537E16 
Cotangente: 6.123233995736766E-17 
Digite a medida em graus do angulo: 
>
```


