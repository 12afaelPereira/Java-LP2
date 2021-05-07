public class Pessoa{

    protected String nome = "";
    protected String dataDeNascimento = "";


    public Pessoa(String nome, String dataDeNascimento){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDataDeNascimento(){
        return this.dataDeNascimento;
    }

    @Override
    public String toString(){
        return "Nome: <" + this.getNome() + ">" + System.lineSeparator()
            +  "Data de Nascimento: <" + this.getDataDeNascimento() + ">" + System.lineSeparator();
    }
}