public class Pessoa{

    protected String nome = "";
    protected String dataDeNascimento = "";


    public Pessoa(String nome, String dataDeNascimento){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString(){
        return "Nome: <" + nome + ">" + System.lineSeparator()
            +  "Data de Nascimento: <" + dataDeNascimento + ">" + System.lineSeparator();
    }
}