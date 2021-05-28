import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseMotionEventDemo extends JApplet
             implements MouseMotionListener, MouseListener {

    BlankArea areaMouse;
    JTextArea areaTexto;

    public void init() {
        JPanel contentPane = new JPanel();

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setLayout(gridbag);
       
        //Define como redimensionar
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;

        //Espaco entre a areaMouse e as bordas do applet e da areaTexto
        c.insets = new Insets(0, 0, 0, 0);
        areaMouse = new BlankArea(new Color(0.98f, 0.97f, 0.85f));
        gridbag.setConstraints(areaMouse, c);
        contentPane.add(areaMouse);

        //Espaco entre a areaTexto e as bordas do applet e da areaMouse
        c.insets = new Insets(3, 6, 9, 12);
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(200, 75));
        gridbag.setConstraints(scrollPane, c);
        contentPane.add(scrollPane);   

        //Registro para eventos do mouse na areaMouse.
        areaMouse.addMouseMotionListener(this);
        areaMouse.addMouseListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
        scrollPane.addMouseMotionListener(this);
        scrollPane.addMouseListener(this);

        setContentPane(contentPane);
    }

    //interface MouseListener
    public void mouseEntered(MouseEvent e) {
       escreve("Mouse entrou", e);
    }

    //interface MouseListener
    public void mouseExited(MouseEvent e) {
       escreve("Mouse saiu", e);
    }

    //interface MouseListener
    public void mouseClicked(MouseEvent e) {
       escreve("Mouse clicado", e);
    }

    //interface MouseListener
    public void mousePressed(MouseEvent e) {
       escreve("Mouse pressinado", e);
    }
    //interface MouseListener
    public void mouseReleased(MouseEvent e) {
       escreve("Mouse solto", e);
    }

    //interface MouseMotionListener
    public void mouseDragged(MouseEvent e) {
       escreve("Mouse arrastado", e);
    }

    //interface MouseMotionListener
    public void mouseMoved(MouseEvent e) {
       escreve("Mouse movido", e);
    }

    void escreve(String eventDescription, MouseEvent e) {
        areaTexto.append(eventDescription
                        + " (" + e.getX() + "," + e.getY() + ")"
                        + " detected on "
                        + e.getComponent().getClass().getName()
                        + "\n");
    }
} 
