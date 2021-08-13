**Programa 6 – P6n**

a) Vamos reusar a classe PessoaIMC do Programa 5. Se você não fez, pode fazer agora  ... acrescente os métodos get e set que você achar necessários. 

b) Crie uma classe chamada MinhaListaOrdenavel. 

1) Esta classe vai conter um objeto da classe ArrayList, do pacote java.util. A classe  ArrayList implementa a interface Collection – isso é importante para o exercício. Este  objeto vai colecionar objetos da classe PessoaIMC, que pode ser Mulher ou Homem – ou seja não vão se criar objetos PessoaIMC, mas sim objetos das classes Homem e  Mulher e, em cima dele, vamos fazer as várias ordenações. 

2) Crie métodos add (PessoaIMC p) e PessoaIMC get (index i) para adicionar e  resgatar, respectivamente, objetos das classes Homem e/ou Mulher do ArrayList interno. 

3) Crie múltiplas formas de ordenar sua lista de PessoaIMC (nome AZ, e Z-A, peso,  altura, IMC, gênero). 

Para isso vamos usar a interface Comparator e um truque de programação em Java:  definir uma classe dentro de outra e criar uma instância dela – tudo embutido.  

Para cada tipo de ordenação que queremos ter, ou seja, comparando valores inteiros ou  Strings, temos que ter uma classe que herda da Comparator diferente. A que compara  inteiros vai pegar um campo, digamos o peso ou a altura, de dois objetos da classe  PessoaIMC (que podem ser objetos das classes Homem ou Mulher), subtrair um do  outro e isso será uma indicação se um é menor ou maior que o outro. Se for da classe  String, podem usar os métodos da própria classe String para fazer a comparação. Isso é  o suficiente para se usar os métodos de ordenação... 

Exemplo: 
```
public Comparator pesoC = new Comparator () { 
 public int compare (Object p1, Object p2){ // recebe objetos PessoaIMC como Object 
 double pf1, pf2; 
 pf2 = (PessoaIMC) p2.getPeso(); 
 pf1 = (PessoaIMC) p1.getPeso(); 
 return (int)Math.round (pf2 – pf1); 
 } 
}; 
```

Observe que vamos ter um objeto chamado pesoC (o nome seria uma contração de  peso+Comparator) “dentro” do (objeto) MinhaListaOrdenavel. Da mesma forma vamos  ter vários outros comparadores encapsulados. 

• Se você for bom mesmo, ordene também por gênero (Homem / Mulher) – ponto  extra.

4) Crie um método ordena, que vai receber uma constante, de uma “tabela” de  constantes que você vai criar dentro da classe MinhaListaOrdenavel e vai devolver um  objeto da classe ArrayList, com os objetos da classe PessoaIMC ordenados segundo o  critério da constante. 

Exemplo: 

1.Alfabetica (A-Z) – nome da pessoa 

2.Alfabetica (Z-A) – nome da pessoa 

3.Menor Peso - crescente 

4.Maior Peso - decrescente 

5.Menor Altura – crescente, do mais baixo para o mais alto 

6.Menor IMC - crescente, do mais baixo para o mais alto 

7.Homem / Mulher – ordenar por gênero * esse é desafio 

Para efetivar a ordenação você vai usar o método de classe sort da classe Collections (Atenção: lá no início, dissemos que ArrayList implementa a interface Collection.  Agora estamos mencionando a classe Collections – com “s” no final – esta classe é que  oferece o método sort – leiam a documentação). Observe que a classe Collections só  tem métodos de classe (static) para ser aplicado a objetos de coleção – mais um  exemplo de utilidade dos métodos de classe.

Exemplo de como estruturar o uso do sort: 
```
public ArrayList ordena (int critério) { 
...switch (critério) { 
 case PESO:  
 Collections.sort(this.[ArrayList encapsulado] , pesoC);   // passamos o próprio ArrayList encapusado dentro de MinhaListaOrdenavel  // e o Comparator correspondente ao critério 
 case PESO_REVERSO:  
 Collections.sort(this.[ArrayList encapsulado] ,  pesoC.reversed()); 
 // observe que a única diferença é a chamada a reversed() 
... 
 return this.[ArrayList encapsulado]; 
} 
```
b) O programa principal vai conter um objeto da classe MinhaListaOrdenavel e partir  dela algumas operações serão efetuadas. 

• Crie um objeto da classe MinhaListaOrdenavel. 

• Em seguida, crie “na mão” 10 objetos da classe PessoaIMC (Homem e/ou Mulher) e  insira no objeto MinhaListaOrdenavel. 

• Na sequência crie um menu para o usuário imprimir a lista de produtos ou sair do  programa. Se o usuário optar por listar, pergunte qual o critério e liste os produtos.

PS.: Para simplificar as coisas, pode colocar estas etapas dentro do método main. No  próximo exercício vamos organizar melhor as coisas. 

Exemplo: 
```
1.Imprimir Lista 
2.Sair 
Digite sua opcao: 1 
Escolha seu modo de ordenacao 
1.Alfabetica (A-Z) 
2.Alfabetica (Z-A) 
3.Menor Peso 
4.Maior Altura 
5.Menor IMC 
Digite sua opcao: 5 
[listar as pessoas na ordem correta, exibindo as informações – isso já deveria estar incluído no toString] 
1.Imprimir Lista 
2.Sair 
Digite sua opcao: 1 
Escolha seu modo de ordenacao 
1.Alfabetica (A-Z) 
2.Alfabetica (Z-A) 
3.Menor Peso 
4.Maior Altura 
5.Menor IMC 
Digite sua opcao: 3 
[listar as pessoas na ordem correta, exibindo as informações – isso já deveria estar incluído no toString] 
```
