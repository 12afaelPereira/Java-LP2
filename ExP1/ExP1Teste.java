public class ExP1Teste{

    public static void main(String args[]){
        
        Pessoa pessoa3 = new Pessoa("Gabriel");
        System.out.println(pessoa3.toString());

        Pessoa pessoa4 = new Pessoa();
        System.out.println(pessoa4.toString());

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Jose");
        pessoa.setSobreNome("da Silva");
        pessoa.setDataDeNascimento(15, 8, 1962);
        pessoa.setGenero("Masculino");
        pessoa.setAltura(1.8);
        pessoa.setPeso(60);

        System.out.println(pessoa.toString());


        Pessoa pessoa2 = new Pessoa();

        pessoa2.setNome("Maria");
        pessoa2.setSobreNome("da Silva");
        pessoa2.setDataDeNascimento(10, 8, 1982);
        pessoa2.setGenero("Feminino");
        pessoa2.setAltura(1.7);
        pessoa2.setPeso(56);
        pessoa2.setPai(pessoa);
        System.out.println(pessoa2.toString());

        Pessoa pessoa5 = new Pessoa();

        pessoa5.setNome("Joana");
        pessoa5.setSobreNome("da Silva");
        pessoa5.setDataDeNascimento(15, 5, 1999);
        pessoa5.setGenero("Feminino");
        pessoa5.setAltura(1.6);
        pessoa5.setPeso(53);
        pessoa5.setMae(pessoa2);
        System.out.println(pessoa5.toString());

        Pessoa pessoa10 = new Pessoa();

        pessoa10.setNome("Lais");
        pessoa10.setSobreNome("Antunes");
        pessoa10.setDataDeNascimento(15, 5, 1989);
        pessoa10.setGenero("Feminino");
        pessoa10.setAltura(1.6);
        pessoa10.setPeso(53);
        System.out.println(pessoa10.toString());

        Pessoa pessoa6 = new Pessoa("Gabriela", "Costa", 1, 2, 2000, "Feminino", 60, 1.67, pessoa, pessoa10);
        System.out.println(pessoa6.toString());

        System.out.println("Numero de instancias: " + pessoa.getNumeroDeInstancias());
    }
}