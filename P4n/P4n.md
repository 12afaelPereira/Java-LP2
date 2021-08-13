**Programa 4 (valendo nota) - P4n** 

Uma empresa contratou novos funcionários e deseja calcular o valor de seus salários após a  aplicação do desconto do Imposto de Renda. No caso de funcionários com dependentes, o salário base é a soma do salário com o salário-família. Também temos o caso de funcionários executivos  que recebem uma gratificação. 

Salário – salário negociado, vai no construtor

Salário Base – salário + salário família 

Salário Família – parcela do salário base calculado com número de dependentes + valor Salário Líquido – calculado (enunciado) é quando o funcionário vai receber no final Gratificação – valor negociado para os executivos. Vai no construtor. 

a) Crie a classe Funcionario com campos String para o nome e o código do empregado e campos  do tipo float para o salário e o salário-líquido. Crie também os métodos:  

• Construtor: 
o recebe como argumento dois objetos String, para inicializa o nome e o campo de código  do empregado; 
o e ainda recebe como argumento um valor float, para inicializa o salário; 

 o campo salário-líquido deve ser inicializados com o mesmo valor do salário; o Atenção: não deve haver nessa classe nenhum outro construtor.  

• float calculaSalario(float desconto): retorna o valor do salário-líquido a ser recebido  pelo empregado, que é o valor do salário-base reduzido do percentual de desconto passado ao  método;

• String toString(): retorna o nome, código e o salário-base do empregado. 

b) Implemente a classe FuncCntrd que estende a classe Funcionario e que possua, além dos  campos herdados, um campo do tipo int para o número de dependentes, um campo do tipo float para o salário-família e dois campos de valor constante: valorPorDep (que vale R$ 9.58, para o  cálculo do salário-família) e aliquotaIR (valendo 15%, para o cálculo do desconto do IR). Essa  classe deve implementar os seguintes métodos:  

• Um construtor que recebe como parâmetros duas “strings”, um número float e um inteiro, e  inicializa os campos nome, código, salário e número de dependentes. Atenção: é obrigatória  uma referência explícita ao construtor da classe Funcionario, que foi definido antes.  

• float calculaSalario(): Calcula o salário-líquido do empregado, invocando o método  calculaSalario da superclasse com o valor da aliquotaIR como parâmetro. 

• float calculaSalario(int numeroDependentes): Para empregados que possuam  dependentes. Calcula o valor no salário-base do empregado, acrescentado ao salário o valor do  salário-família (número de dependentes * valPorDep), e invoca o método calculaSalario() para  calcular seu salário-líquido.  

• String toString(): retorna um objeto String contendo o nome, código, salário-base e salário líquido do Empregado. 

c) Implemente a classe FuncExct que herda da classe FuncCntrd 
As mesmas observações anteriores se aplicam aqui. 
Além disso, esta classe tem: 

• Um campo privativo float que deve ser inicializado com um construtor específico desta classe,  contendo um valor de gratificação negociado; 

• float calculaSalario(): acrescenta ao cálculo do salário líquido da supercalsse o valor (ou  seja soma o valor) do campo gratificação; 

• String toString(): acrescenta à versão do método toString da classe pai, um “*” ao lado do  código e exibe também o valor da gratificação (planeje direitinho a “cadeia” de toString para  ficar modular, ao invés de ficar repetindo código – reuso é fundamental. 

As classes acima descritas devem implementar também um método getXXX para cada campo da  classe (onde “XXX” é o nome do campo). Estes métodos são geralmente chamados métodos de  acesso ou geters.

c) Crie uma classe com o programa principal que crie instâncias da classe FuncCntrd e  FuncionarioExct (recebendo os dados via fluxo de entrada). Estes devem ser armazenados num  objeto que implemente a interface Collection (ArrayList, por exemplo.). 

**Atenção:** está classe conterá o método main e TAMBÉM um construtor e métodos entDados e calculaSalarios. 

O método main deve fazer o seguinte: 

1) pedir ao usuário o número de objetos (FuncCntrd e FuncExct) para os quais o salário vai ser  calculado; 

2) criar uma instância da classe principal (sim, isso mesmo!). Para isso você também vai ter que  resolver onde vai ficar a referência a esta instância: global à classe ou local ao método main. 

 a. O construtor da classe principal deve receber como argumento o número de  funcionários a ser entrado; 

b. Invocar o método entDados no objeto instanciado da classe principal; 

c. Invocar o método geraFolha no objeto instanciado da classe principal. 

O método entDados é uma rotina onde se pede ao usuário o tipo de funcionário a ser criado, cria a  instância do objeto correspondente e coloca no ArrayList; 

O método geraFolha, na realidade faz o trabalho “importante” (também não é o ideal, mas é  melhor do que deixar tudo dentro do método main). Lista os objetos criados exibindo os detalhes de  cada tipo (FuncCntrd e FuncExct), incluindo seu tipo, dependentes, salário base e salário líquido. 

Exemplo:
```
//============== Dica ==============// 
ArrayList funcList; 
P4nX (int n) { 
funcList = new ArrayList(n); 
} 
Main(){ 
 Read(); 
 Float n = Float.parseFloat(); 
 P4nX p = new P4nX(n); 
  
 p.entDados(); 
 p.geraFolha(); 
 } 
//==================== Dica =============// 


Quantos Funcionários? 2 
--- Cadastro de Funcionarios 
Contratado ou Executivo (c/e)? c 
Nome do Empregado: Rubens Andrade 
Codigo: Emp01 
Salario:500.00 
Numero de Dependentes: 0 
Contratado ou Executivo (c/e)? e 
Nome do Empregado: Paulo Ricardo 
Codigo: Emp02 
Salario: 1000.00 
Numero de Dependentes: 2 
Gratificacao: 250.50 
... 
--- Folha Salarial --- 
Nome: Rubens Andrade 
Codigo: Emp01 
Salario-Base: 500.0 
Salario-Liquido: 425.0 
---- 
Nome: Paulo Ricardo (executivo)// ou algo assim, de acordo com o enunciado Codigo: Emp02 
Salario-Base: 519.16 // corrigir 
Salario-Liquido: 441.28599999999994 
---- 
... 
```
Montar o diagrama UML.
