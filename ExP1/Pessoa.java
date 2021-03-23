public class Pessoa{
    
    // *** Atributos ***
    private static int numeroDeInstancias = 0;

    private String nome = "";
    private String sobrenome = "";
    // data de nascimento
    private double peso = 0.0;
    private double altura = 0.0;
    private String status = "Fazendo nada...";
    private int idade = 0;

    // Atributos Especiais
    private Pessoa pai = null;
    private Pessoa mae = null;
    
    // Enumeracao
    enum genero{
        MASCULINO,
        FEMININO
    }


    // *** Construtores ***
    public Pessoa(String nome){
        this.nome = nome;
        numeroDeInstancias++;
    }

    public Pessoa(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
        numeroDeInstancias++;
    }

    public Pessoa(String nome, String sobrenome, double peso, double altura){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.peso = peso;
        numeroDeInstancias++;
    }



    // *** Getters ***
    public String getNome(){
        return this.nome;
    }

    public String getSobreNome(){
        return this.sobrenome;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getAltura(){
        return this.altura;
    }

    // public String getPai(){
    //     return this.pai.nome;
    // }
    
    // public String getMae(){
    //     return this.mae.nome;
    // }



    // *** Setters ***
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSobreNome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    // public void setPai(String nome){
    //     this.pai.nome = nome;
    // }

    // public void setMae(String nome){
    //     this.mae.nome = nome;
    // }



    // *** Metodos especiais ***
    public String getStatus(){
        return this.status;
    }

    public String toString(){
        return "nome: " + this.nome + System.lineSeparator();
    } 

    private int getIdade(){
        return this.idade;
    }
}