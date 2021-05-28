import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel{

    public ArrayList pessoas = new ArrayList();

    public void add(PessoaIMC pessoa){
        this.pessoas.add(pessoa);
    }

    public PessoaIMC get(int i){
        return (PessoaIMC)this.pessoas.get(i);
    }

    public ArrayList ordena(int criterio){
        switch(criterio){
            case 1:
                // "Alfabetica (A-Z)"
                Collections.sort(this.pessoas, new Comparator<PessoaIMC>(){

                    @Override
                    public int compare(PessoaIMC p1, PessoaIMC p2){
                        return p1.getNome().compareTo(p2.getNome());
                    }
                });
                // Collections.sort(this.pessoas);
                break;

            case 2:
                // "Alfabetica (Z-A)"
                Collections.sort(this.pessoas, new Comparator<PessoaIMC>(){

                    @Override
                    public int compare(PessoaIMC p1, PessoaIMC p2){
                        return p2.getNome().compareTo(p1.getNome());
                    }
                });
                
                break;

            case 3:
                // "Menor peso"
                Collections.sort(this.pessoas, new Comparator<PessoaIMC>(){

                    @Override
                    public int compare(PessoaIMC p1, PessoaIMC p2){
                        if(p1.getPeso() < p2.getPeso()){
                            return -1;
                        }
                        else if(p1.getPeso() > p2.getPeso()){
                            return 1;
                        }
                        else return 0;
                    }
                });

                break;
            
            case 4:
                // "Maior peso"
                Collections.sort(this.pessoas, new Comparator<PessoaIMC>(){

                    @Override
                    public int compare(PessoaIMC p1, PessoaIMC p2){
                        if(p1.getPeso() > p2.getPeso()){
                            return -1;
                        }
                        else if(p1.getPeso() < p2.getPeso()){
                            return 1;
                        }
                        else return 0;
                    }
                });

                break;
            
            case 5:
                // "Menor altura"
                Collections.sort(this.pessoas, new Comparator<PessoaIMC>(){

                    @Override
                    public int compare(PessoaIMC p1, PessoaIMC p2){
                        if(p1.getAltura() < p2.getAltura()){
                            return -1;
                        }
                        else if(p1.getAltura() > p2.getAltura()){
                            return 1;
                        }
                        else return 0;
                    }
                });
                break;
            
            case 6:
                // Menor IMC
                Collections.sort(this.pessoas, new Comparator<PessoaIMC>(){

                    @Override
                    public int compare(PessoaIMC p1, PessoaIMC p2){
                        if(p1.calculaIMC(p1.getPeso(), p1.getAltura()) < p2.calculaIMC(p2.getPeso(), p2.getAltura())){
                            return -1;
                        }
                        else if(p1.calculaIMC(p1.getPeso(), p1.getAltura()) > p2.calculaIMC(p2.getPeso(), p2.getAltura())){
                            return 1;
                        }
                        else return 0;
                    }
                });
                break;
        }

        return this.pessoas;
    }

    @Override
    public String toString(){
        return this.pessoas.toString();
    }


}