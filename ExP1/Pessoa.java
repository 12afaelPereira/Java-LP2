import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa{
    
    // *** Atributos ***
    private static int numeroDeInstancias = 0;

    private String nome = "";
    private String sobrenome = "";
    private GregorianCalendar dataDeNascimento = null;
    private double peso = 0.0;
    private double altura = 0.0;
    private String genero = "";
    private String status = "Fazendo nada...";
    private int anoCorrente = Calendar.getInstance().get(Calendar.YEAR); 

    // Atributos Especiais
    private Pessoa pai = null;
    private Pessoa mae = null;


    // *** Construtores ***
    public Pessoa(){
        numeroDeInstancias++;
    }

    public Pessoa(String nome){
        this.nome = nome;
        numeroDeInstancias++;
    }

    public Pessoa(String nome, String sobrenome, int dia, int mes, int ano, String genero, double peso, double altura, Pessoa pai, Pessoa mae){
        this.setNome(nome);
        this.setSobreNome(sobrenome);
        this.setDataDeNascimento(dia, mes, ano);
        this.setGenero(genero);
        this.setPeso(peso);
        this.setAltura(altura);
        this.setPai(pai);
        this.setMae(mae);

        numeroDeInstancias++;
    }



    // *** Getters ***
    public String getNome(){
        return this.nome;
    }

    public String getSobreNome(){
        return this.sobrenome;
    }

    public String getDataDeNascimento(){
        if(dataDeNascimento == null){
            return "O usuario nao possui data da nascimento cadastrada";
        }

        return "" + this.dataDeNascimento.get(Calendar.DATE) 
            + "/" + this.dataDeNascimento.get(Calendar.MONTH)
            + "/" + this.dataDeNascimento.get(Calendar.YEAR);
    }

    public double getPeso(){
        return this.peso;
    }

    public double getAltura(){
        return this.altura;
    }

    public String getGenero(){
        return this.genero;
    }
    
    public String getPai(){
        if(pai == null){
            return "O usuario nao possui um pai cadastrado";
        }

        return this.pai.nome + " " + this.pai.sobrenome;
    }
    
    public String getMae(){
        if(mae == null){
            return "O usuario nao possui uma mae cadastrada";
        }

        return this.mae.nome + " " + this.mae.sobrenome;
    }



    // *** Setters ***
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSobreNome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public void setDataDeNascimento(int dia, int mes, int ano){
        dataDeNascimento = new GregorianCalendar(ano, mes, dia);
    }

    public void setPeso(double peso){
        if(peso>=45 && peso<=200){
            this.peso = peso;
        }
        else{
            System.out.println("Nao foi possivel setar peso. Escolha um valor entre 45 e 200");
        }
    }

    public void setAltura(double altura){
        if(altura >= 1.5 && altura <= 2.5){
            this.altura = altura;
        }
        else{
            System.out.println("Nao foi possivel setar altura. Escolha um valor entre 1.5 e 2.5");
        }
    }

    public void setGenero(String genero){
        if ( (!genero.toLowerCase().equals("masculino") && (!genero.toLowerCase().equals("feminino"))) ){
            System.out.println("Nao foi possivel setar o genero. Escolha entre masculino ou feminino");
        }
        else{
            this.genero = genero.toLowerCase();
        }
    }    

    public void setPai(Pessoa pai){
        this.pai = pai;
    }

    public void setMae(Pessoa mae){
        this.mae = mae;
    }



    // *** Metodos especiais ***
    public int getNumeroDeInstancias(){
        return numeroDeInstancias;
    }

    public String getStatus(){
        return this.status;
    }

    private int getIdade(){
        if(dataDeNascimento == null){
            return 0;
        }

        int idade = anoCorrente - this.dataDeNascimento.get(Calendar.YEAR);

        return idade;
    }

    @Override
    public String toString(){
        return "************** Pessoa Info **************" + System.lineSeparator()
        + "nome: " + this.getNome() + System.lineSeparator()
        + "Sobrenome: " + this.getSobreNome() + System.lineSeparator()
        + "Genero: " + this.getGenero() + System.lineSeparator()
        + "Data de nascimento: " + this.getDataDeNascimento() + System.lineSeparator()
        + "Altura: " + this.getAltura() + "m" + System.lineSeparator()
        + "Peso: " + this.getPeso() + "kg" + System.lineSeparator()
        + "status: " + this.getStatus() + System.lineSeparator()
        + "Idade: " + this.getIdade() + System.lineSeparator()
        + "Pai: " + this.getPai() + System.lineSeparator()
        + "Mae: " + this.getMae() + System.lineSeparator();
    }
}