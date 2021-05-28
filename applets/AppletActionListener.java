import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Container;

public class AppletActionListener extends JApplet implements ActionListener {

   JButton botao1, botao2;
   JPanel grupoBotao12;
   JComboBox botaoDeSelecao;
   String[] botaoDeSelecaoString={"primeiro","segundo","terceiro"};
   JRadioButton opcao1, opcao2, opcao3, opcao4;
   ButtonGroup grupoBotao;
   JPanel grupoBotaoPanel;
   JLabel titulo;
   JTextField campoDeTexto;
   JTextArea areaDeTexto;
   JPanel grupoTexto;
   Panel p;
   Container cp; 

public void init() {
      //botoes
      botao1 = new JButton("botao 1");
      botao1.addActionListener(this);
      botao2 = new JButton("botao 2");
      botao2.addActionListener(this);
      grupoBotao12 = new JPanel();
      grupoBotao12.add(botao1);
      grupoBotao12.add(botao2);
      //botao de selecao
      botaoDeSelecao = new JComboBox(botaoDeSelecaoString);
      botaoDeSelecao.addActionListener(this);
     
      //botao de opcao
      grupoBotao = new ButtonGroup();
      grupoBotaoPanel = new JPanel();
      opcao1 = new JRadioButton("Opcao 1");
      opcao2 = new JRadioButton("Opcao 2");
      opcao3 = new JRadioButton("Opcao 3");
      opcao4 = new JRadioButton("Opcao 4");
      grupoBotao.add(opcao1);
      grupoBotao.add(opcao2);
      grupoBotao.add(opcao3);
      grupoBotao.add(opcao4);
      opcao1.addActionListener(this);
      opcao2.addActionListener(this);
      opcao3.addActionListener(this);
      opcao4.addActionListener(this);
      grupoBotaoPanel.add(opcao1);
      grupoBotaoPanel.add(opcao2);
      grupoBotaoPanel.add(opcao3);
      grupoBotaoPanel.add(opcao4);
     
      //Cria um painel agrupando um Label e um Campo de Texto
      titulo = new JLabel("    Entre com um texto    ");
      campoDeTexto = new JTextField(20);
      grupoTexto = new JPanel();
      campoDeTexto.addActionListener(this);
      grupoTexto.add(titulo);
      grupoTexto.add(campoDeTexto);
      //Content Pane
      cp = getContentPane();
      p = new Panel ();
      areaDeTexto = new JTextArea();
      areaDeTexto.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(areaDeTexto, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setPreferredSize(new Dimension(300, 150));
      p.add(grupoBotao12);
      p.add(botaoDeSelecao);
      p.add(grupoBotaoPanel);
      p.add(grupoTexto);
      p.add(scrollPane);
      cp.add(p);
   } 

   //Este metodo responde as acoes dos componentes
   public void actionPerformed(ActionEvent e) {

      if(e.getSource() instanceof JButton) {
         areaDeTexto.append("Um botao foi apertado \n");
         if(e.getSource()==botao1) {
               areaDeTexto.append("O botao 1 foi apertado \n");
         }else {
               areaDeTexto.append("O botao 2 foi apertado \n");
         }
      }
      if(e.getSource() instanceof JTextField) {
         areaDeTexto.append("O texto digitado foi " + campoDeTexto.getText() + " \n");
      }
      if(e.getSource() instanceof JComboBox) {
          areaDeTexto.append("O botao de selecao escolhido foi o " + 
                              botaoDeSelecao.getSelectedItem() + " \n");
      }
      if(e.getSource() instanceof JRadioButton) {
         if(opcao1.isSelected()) {
            areaDeTexto.append("O botao de opcao foi acionado \n");
            areaDeTexto.append("A opcao escolhida foi a opcao1 \n");
         }
         if(opcao2.isSelected()) {
            areaDeTexto.append("O botao de opcao foi acionado \n");
            areaDeTexto.append("A opcao escolhida foi a opcao2 \n");
         }
         if(opcao3.isSelected()) {
            areaDeTexto.append("O botao de opcao foi acionado \n");
                        areaDeTexto.append("A opcao escolhida foi a opcao3 \n");
         }
         if(opcao4.isSelected()) {
            areaDeTexto.append("O botao de opcao foi acionado \n");
            areaDeTexto.append("A opcao escolhida foi a opcao4 \n");
         }
      }
   }

   class Panel extends JPanel {

      public void paintComponent (java.awt.Graphics g) {
             super.paintComponent(g);
      }
   }
}  
