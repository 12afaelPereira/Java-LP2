import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class P8nX extends Applet implements ActionListener, Serializable {

	public double peso = 0;
	public double altura = 0;
	public static MinhaListaOrdenavel listaOrdenavel = new MinhaListaOrdenavel();
	public File arquivoDeCadastros = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4236458411991515595L;

	Label labelGenero = new Label("Genero: ");
	Choice choiceGenero = new Choice();

	Label labelNome = new Label("Nome: ");
	TextField inputNome = new TextField();

	Label labelNasciento = new Label("Data de nascimento: ");
	TextField inputNascimento = new TextField();

	Label labelPeso = new Label("Peso: ");
	TextField inputPeso = new TextField();

	Label labelAltura = new Label("altura: ");
	TextField inputAltura = new TextField();

	Button cadastrar = new Button("Cadastrar");

	Label labelListar = new Label("Listar por: ");
	Choice choiceListarPor = new Choice();
	
	Button listar = new Button("Ordenar");
	
	Button salvar = new Button("Adicionar cadastros");
	
	TextArea area = new TextArea();
	

	public void init() {

		setSize(600, 400);

		choiceGenero.addItem("Masculino");
		choiceGenero.addItem("Feminino");

		add(labelNome);
		add(inputNome);
		
		
		add(choiceGenero);

		add(labelNasciento);
		add(inputNascimento);
		

		add(labelPeso);
		add(inputPeso);

		add(labelAltura);
		add(inputAltura);

		add(cadastrar);
		cadastrar.addActionListener(this);

		add(labelListar);

		choiceListarPor.addItem("Ordem Alfabetica Crescente");
		choiceListarPor.addItem("Ordem Alfabetica Derescente");
		choiceListarPor.addItem("Menor Peso");
		choiceListarPor.addItem("Maior Peso");
		choiceListarPor.addItem("Menor Altura");
		choiceListarPor.addItem("Maior Altura");
		choiceListarPor.addItem("Menor IMC");
		add(choiceListarPor);
		add(listar);
		listar.addActionListener(this);

		add(salvar);
		salvar.addActionListener(this);
		
		add(area);
		
		checkFile();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonPressed = e.getActionCommand();

		
		if (buttonPressed.equals("Cadastrar")) {

			String nome = inputNome.getText();

			String dataDeNascimento = inputNascimento.getText();

			try {
				peso = Double.parseDouble(inputPeso.getText());
				altura = Double.parseDouble(inputAltura.getText());
				
			} catch (NumberFormatException e2) {

				//Dialog d = new Dialog();
				
				System.out.println("Erro");
			}

			inputNome.setText("");
			inputNascimento.setText("");
			inputPeso.setText("");
			inputAltura.setText("");
			
			if(choiceGenero.equals("Masculino")) {
				listaOrdenavel.add(new Homem(nome, dataDeNascimento, peso, altura));
				area.setText("");
				area.setText(listaOrdenavel.toString());
			}
			else {
				listaOrdenavel.add(new Mulher(nome, dataDeNascimento, peso, altura));
				area.setText("");
				area.setText(listaOrdenavel.toString());
			}

		}
		
		else if (buttonPressed.equals("Ordenar")) {
			listaOrdenavel.ordena(choiceListarPor.getSelectedIndex()+1);
			area.setText("");
			area.setText(listaOrdenavel.toString());
		}
		
		else if (buttonPressed.equals("Adicionar cadastros")) {
			salvaArquivo();
		}
		
		
		repaint();

	}
	
	public void checkFile() {

		arquivoDeCadastros = new File("cadastrosIMC");
		
		if (arquivoDeCadastros.exists()) {
			leArquivo();
		
		}
	}
	
	public void leArquivo(){
        try{
            FileInputStream streamDoArquivo = new FileInputStream("cadastrosIMC");
            ObjectInputStream arquivo = new ObjectInputStream(streamDoArquivo);

            
        	listaOrdenavel = (MinhaListaOrdenavel) arquivo.readObject();
        	
        	arquivo.close();
        	streamDoArquivo.close();
            
        	
        	area.setText("");
			area.setText(listaOrdenavel.toString());
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }
	
	public void salvaArquivo(){
        try{
            FileOutputStream streamDoArquivo = new FileOutputStream("cadastrosIMC");
            ObjectOutputStream arquivo = new ObjectOutputStream(streamDoArquivo);

            arquivo.writeObject(listaOrdenavel);
            arquivo.flush();
            arquivo.close();

            streamDoArquivo.flush();
            streamDoArquivo.close();
            System.out.println("Arquivo salvo com sucesso!");
        }
        catch(IOException e){
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }
}

/*
 * <applet code="P8nX" height="500" width="600"></applet>
 */