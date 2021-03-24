public class ExP1Teste{

    public static void main(String args[]){
        
        Pessoa pessoa3 = new Pessoa("Rafael");
        System.out.println(pessoa3.toString());

        Pessoa pessoa4 = new Pessoa();
        System.out.println(pessoa4.toString());

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Jose");
        pessoa.setSobreNome("da Silva");
        pessoa.setDataDeNascimento(15, 8, 1992);
        pessoa.setGenero("Masculino");
        pessoa.setAltura(1.8);
        pessoa.setPeso(60);

        // System.out.println("Nome: " + pessoa.getNome());
        // System.out.println("Sobrenome: " + pessoa.getSobreNome());
        // System.out.println("Genero: " + pessoa.getGenero());
        // System.out.println("Altura: " + pessoa.getAltura() + "m");
        // System.out.println("Peso: " + pessoa.getPeso() + "kg");

        // System.out.println("Numero de instancias: " + pessoa.getNumeroDeInstancias());
        System.out.println(pessoa.toString());


        Pessoa pessoa2 = new Pessoa();

        pessoa2.setNome("Maria");
        pessoa2.setSobreNome("da Silva");
        pessoa2.setDataDeNascimento(10, 8, 1982);
        pessoa2.setGenero("Feminino");
        pessoa2.setAltura(1.7);
        pessoa2.setPeso(56);
        System.out.println(pessoa2.toString());


        System.out.println("Numero de instancias: " + pessoa.getNumeroDeInstancias());
    }
}