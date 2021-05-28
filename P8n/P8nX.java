import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P8nX extends Applet implements ActionListener {
	String str = "";

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

	public void init() {

		setSize(400, 400);

		choiceGenero.addItem("Masculino");
		choiceGenero.addItem("Feminino");
		choiceGenero.addItem("Outro");

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

	}

	/*
	 * public void Paint(Graphics g) {
	 * 
	 * g.drawString(str, 20, 50); }
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonPressed = e.getActionCommand();

		if (buttonPressed.equals("Cadastrar")) {

			String nome = inputNome.getText();

			String dataDeNascimento = inputNascimento.getText();

			try {
				double peso = Double.parseDouble(inputPeso.getText());
				double altura = Double.parseDouble(inputPeso.getText());
				
			} catch (NumberFormatException e2) {

				//Dialog d = new Dialog();
				
				// System.out.println("Erro");
			}

			// str = "Cadastro feito!";

		}
		// repaint();

	}
}

/*
 * <applet code="P8nX" height="500" width="600"></applet>
 */