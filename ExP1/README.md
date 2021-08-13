**LP II – 2020/2 – noite Exercício prático 1 
Prof. Alexandre Sztajnberg**

**Passo1.** Crie um diretório chamado ExP1. O exercício será desenvolvido dentro dele. A  permissão do diretório e dos arquivos deve ser restrita ao seu usuário.  

Se você não vai fazer na sua conta na VM, sem problemas. Depois transfere tudo para lá e  acerta o diretório. 

**Passo2.** Crie uma classe Pessoa com os seguintes requisitos: 

**Campos:** nome, sobrenome, data-nascimento, peso, altura, genero. Use classes e tipos  adequados (data-nascimento não pode ser String – veja a documentação, todos protegidos ao  máximo (private). 

**Campos especiais:** pai e mae, apontando para um objeto da classe Pessoa, representando o pai  ou a mãe. 

Métodos getters se setters para todos os campos. Mas, verifique se os valores são coerentes.  

Pessoas com 3 metros de altura, ou 1 Kg de peso. De a sua solução (temporária) para estes  problemas, no seu código (ou seja, que tipo de retorno eu vou dar, já, que não sei usar exceções  ainda). 

**Construtores.** Um iniciando o nome, outro o nome + os outros atributos e um vazio. Contagem: um método que conte quantas instâncias da classe pessoa foram criadas. 

**Métodos:** a assinatura você deve fazer adequadamente, com o s parâmetros necessários e  retorno, caso necessário 

**status** – represente o que a pessoa está fazendo. Faça o que for necessário para isso. Pode criar  listas de literais ou constantes. 

**toString** – lembre-se do que falamos. Este método tem que ficar muito bom. 

**idade** – pega a data de nascimento, o dia de hoje e calcula a idade. Método privativo! Vai ser  usado no toString 

**Passo3.** Desenhe o diagrama de classe representando Pessoa. Faça o upload do gif, png ou pdf deste diagrama. 

**Passo4.** Desenvolva uma casse de teste chamada ExP1Teste, com os seguintes requisitos. 
Crie vários objetos da classe Pessoa, com vários gêneros, usando vários construtores. Ainda  não vimos array (profundamente) ou classe List (e derivadas). Vai uma dica do uso do array: 
Pessoa[] pessoas = new Pessoa[<quantas?>];

O número de pessoas deve ser passado como argumento na linha de comando. 

Vai ter que fazer uma rotina e um loop de entrada ou fazer “na mão”. 

Crie relações entre algumas delas (pai e mãe). 
Exercite alguns métodos getters e setters 
Exiba quantas pessoas foram criadas acessando o método criado – não pode usar o tamanho do  array e nem usar uma variável local! 

Exiba a informação dos objetos criados usando um for
