public class ExP1Teste{

    public static void main(String args[]){
        
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

        System.out.println("Numero de instancias: " + pessoa.getNumeroDeInstancias());
        System.out.println(pessoa.toString());
    }
}