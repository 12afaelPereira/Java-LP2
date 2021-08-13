**Programa 5 – Pn5**

O IMC de uma pessoa pode ser calculado através de uma fórmula que consiste em dividir o peso  (em kg) pelo quadrado da altura (em m²). 

O número resultante é então verificado em uma escala  que varia de acordo com o seu gênero e então se chega a um resultado. Sua tarefa, neste exercício, é realizar o cálculo do IMC usando dados fornecidos pelo(a) usuário(a) e analisar a escala a fim de  mostrar se ele(a) está acima, na média ou abaixo do peso ideal 

Crie a classe Pessoa com os campos protegidos (encapsulados), nome e dataNascimento, objetos da  classe String, que vão representar o nome e data de nascimento. A classe Pessoa deve conter: 

• Um construtor que recebe como parâmetros duas strings e inicializa os campos nome e  dataNascimento. 

• O método toString, que não recebe parâmetros e retorna um objeto da classe String na seguinte  forma:  

```
Nome: <nome da pessoa> 
Data de Nascimento: <data de nascimento da pessoa> 
```

Crie a classe abstrata PessoaIMC que herde da classe Pessoa e contenha tenha os campos  protegidos peso e altura, ambos do tipo double. O construtor desta classe deve receber como  parâmetros duas strings e dois valores do tipo double e inicializar os campos nome,  dataNascimento, peso e altura. 

A classe PessoaIMC deve conter os seguintes métodos:  

• public double getPeso() que retorna o peso;

• public double getAltura() que retorna a altura;

• calculaIMC() que recebe como parâmetros dois valores do tipo double que são a altura e o peso  e retorna um valor do tipo double correspondente ao IMC (Índice de Massa Corporal = peso /  altura ao quadrado) calculado.  

• o método abstrato resultIMC() que não recebe parâmetros e retorna uma instância da classe  String. (o método não é implementado nesta classe - ele é abstrato) 

• O método toString() desta classe deve retornar uma string da seguinte forma (um bom lugar  para você exercer o reuso de código por herança): 

```
Nome: <nome da pessoa> 
Data de Nascimento: <sua data de nascimento> 
Peso: <seu peso> 
Altura: <sua altura> 
```

Crie as classes Homem e Mulher, herdeiras de PessoaIMC. Cada uma deve implementar o método  abstrato resultIMC() para classificar o calculo do IMC (o cálculo efetivo é realizado pelo método 
calculaIMC). 

O método toString() retorna um objeto da classe String com o resultado acordo com  o valor obtido e todos as demais informações da pessoa.  

A classificação do IMC, indicando se a pessoa está abaixo, acima ou com o peso ideal é dada pela  tabela abaixo: 

```
Para Homem:  

IMC < 20.7 : Abaixo do peso ideal 
20.7 ≤ IMC ≤ 26.4: Peso ideal  
 IMC > 26.4 : Acima do peso ideal 

Para Mulher:  
IMC < 19 : Abaixo do peso ideal 
19 ≤ IMC ≤ 25.8: Peso ideal  
 IMC > 25.8 : Acima do peso ideal
```


Crie uma classe para o programa principal, com o método main(), que crie instâncias das classes  Homem e Mulher e armazene essas instâncias em um objeto da classe Vector (ou algum outro  objeto do framework Collection – ArrayList, por exemplo). 

O programa deve perguntar ao usuário  o número de pessoas, que tipo de objeto (Homem ou Mulher) deseja criar e os dados referentes a  cada objeto. A leitura de dados deve ser feita através de fluxo de entrada. Após o armazenamento  de todos os objetos, o programa deve ler cada elemento do ArrayList, imprimindo os dados do  objeto ali contido, com todos os dados. 

**Não usar GENERICS “<tipo>”**

Erros de entrada de dados devem ser criticados e tratados quando possível (por exemplo,  solicitando nova entrada). 

Exemplo: 
``` 
java Ex4 
Digite o numero de pessoas: 
2 
Inserir homem (h) ou mulher(m)? 
j 
--- Opcao Invalida!!! 
Inserir homem (h) ou mulher(m)? 
h 
Digite o nome: 
Zezinho 
Digite a data de nascimento: 
01/01/1901 
Digite o peso: 
64.8 
Digite a altura (em metros): 
um m 
--- A altura deve ser um numero real!!! 
Digite a altura (em metros): 
1.80 
Inserir homem (h) ou mulher(m)? 
m
Digite o nome: 
Mariazinha 
Digite a data de nascimento: 02/02/02/1902 
Digite o peso: 
64.8 
Digite a altura (em metros): 1.8 
-------- 
Nome: Zezinho 
Data de Nascimento: 01/01/1901 Peso: 64.8 
Altura: 1.8 
IMC: 19.99 Abaixo do peso -------- 
-------- 
Nome: Mariazinha 
Data de Nascimento: 02/02/02/1902 Peso: 64.8 
Altura: 1.8 
IMC: 19.99 Peso ideal 
--------
```