import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P8nX extends Applet implements ActionListener{
	
	
	
	
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	Label l1 = new Label("Nome: ");
	
	
	public P8nX(){
		add(l1);
		add(t1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

/* 
	<applet code="P8nX" height="300" width="500"></applet>
*/