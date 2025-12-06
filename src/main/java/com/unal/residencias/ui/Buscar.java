package com.unal.residencias.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buscar extends JFrame{

    JTextField inId, inNombre, inPuntaje;

    public Buscar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Insertar");
        setMinimumSize(new Dimension(700, 400));
        this.setLocationRelativeTo(null);

        iniciar();
    }
    private void iniciar(){
        //-----//-----//-----//-----//-----//-----//-----//-----//
        //-----//-----//--- PANTALLA INSERTAR ----//-----//-----//
        //-----//-----//-----//-----//-----//-----//-----//-----//
        setLayout(new BorderLayout());
        
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(new Color(180, 180, 180));
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        left.setPreferredSize(new Dimension(350, left.getPreferredSize().height));

        // ------//------//------ Panel Estudiante ------//------//------//------//
        JPanel pEst = new JPanel();
        pEst.setMaximumSize(new Dimension(left.getPreferredSize().width, 170));
        pEst.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 0;
        gc.insets = new Insets(5, 10, 5, 10);

        // titulo ------//------//------//------//------//
        JLabel title = new JLabel("Buscar");
        title.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.BASELINE;
        pEst.add(title, gc);

        // subtitulo ------//------//------//------//------//
        JLabel subtitle = new JLabel("ID estudiante");
        subtitle.setFont(new Font("Sans-serif", Font.ITALIC, 11));
        gc.gridx = 0;
        gc.gridy = 1;
        pEst.add(subtitle, gc);

        // input Código ------//------//------//------//------//
        JTextField buscaCod = new JTextField();
        buscaCod.setMaximumSize(new Dimension(left.getPreferredSize().width, buscaCod.getPreferredSize().height));
        buscaCod.setAlignmentX(Component.CENTER_ALIGNMENT);
        buscaCod.setHorizontalAlignment(JTextField.CENTER);
        buscaCod.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        buscaCod.setBackground(new Color(230, 230, 230));
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.BOTH;
        pEst.add(buscaCod, gc);


        // botón Buscar ------//------//------//------//------//------//
        gc.fill = GridBagConstraints.HORIZONTAL;
        JButton buscar = new JButton("Buscar");
        buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gc.gridx = 0;
        gc.gridy = 3;
        pEst.add(buscar, gc);

        pEst.setAlignmentX(Component.CENTER_ALIGNMENT);
        left.add(pEst);

        left.add(Box.createRigidArea(new Dimension(0, 15)));

        this.add(left, BorderLayout.WEST);

        //------//------//------//------//------//------//
        //------//------   PANEL DERECHO  ------//------//
        //------//------//------//------//------//------//
        
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
    
        // Titulo id ------//------//------//------//------//------//
        JLabel infoId = new JLabel("ID");
        infoId.setFont(new Font("Sans-serif", Font.BOLD, 20));
        right.add(infoId);
        // campo id ------//------//------//------//------//------//
        JTextField inId = new JTextField();
        inId.setMaximumSize(new Dimension(1000, 30));
        inId.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inId.setBackground(new Color(230, 230, 230));
        inId.setEditable(false);
        
        inId.setText("484379349");
        right.add(inId);
        // Titulo nombre ------//------//------//------//------//------//
        JLabel infoNombre = new JLabel("Nombre");
        infoNombre.setFont(new Font("Sans-serif", Font.BOLD, 20));
        right.add(infoNombre);

        // campo nombre ------//------//------//------//------//------//
        JTextField inNombre = new JTextField();
        inNombre.setMaximumSize(new Dimension(1000, 30));
        inNombre.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inNombre.setBackground(new Color(230, 230, 230));
        inNombre.setEditable(false);

        inNombre.setText("Tulio Triviño");
        right.add(inNombre);

        // Titulo Puntaje ------//------//------//------//------//------//
        JLabel infoPuntaje = new JLabel("Puntaje");
        infoPuntaje.setFont(new Font("Sans-serif", Font.BOLD, 20));
        right.add(infoPuntaje);

        // campo Puntaje ------//------//------//------//------//------//
        JTextField inPuntaje = new JTextField();
        inPuntaje.setMaximumSize(new Dimension(1000, 30));
        inPuntaje.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inPuntaje.setBackground(new Color(230, 230, 230));
        inPuntaje.setEditable(false);

        inPuntaje.setText("130");
        right.add(inPuntaje);

        right.add(Box.createRigidArea(new Dimension(0, 30)));
        JPanel buttons = new JPanel();
        buttons.setMaximumSize(new Dimension(1000, 70));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        // botones  ------//------//------//------//------//------//
        JButton edit = new JButton("editar");
        edit.setMaximumSize(new Dimension(1000, 30));
        buttons.add(edit);
        JButton delete = new JButton("Borrar");
        delete.setMaximumSize(new Dimension(1000, 30));
        buttons.add(delete);

        right.add(buttons);

        this.add(right, BorderLayout.CENTER);
    }
    
}
