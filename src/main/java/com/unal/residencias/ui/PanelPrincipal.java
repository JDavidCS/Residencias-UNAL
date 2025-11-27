package com.unal.residencias.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{

    JLabel nEstudiantes;

    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        // this.setPreferredSize(new Dimension(200, 200));
        iniciar();
    }
    private void iniciar(){
        // Panel izquierdo
        
        // Por problemas inexplicables de java swing, tocó crear este contenedor
        JPanel adapt = new JPanel();
        adapt.setLayout(null);
        adapt.setBackground(new Color(255, 0, 0));
        //----------//----------//----------//----------//----------//----------//
        //                      PANEL IZQUIERDA
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(new Color(100, 100, 100));
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));
        left.setPreferredSize(new Dimension(350, left.getPreferredSize().height));

        //                      Panel Estudiante
        JPanel pEst = new JPanel();
        pEst.setMaximumSize(new Dimension(left.getPreferredSize().width, 100));
        pEst.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1; gc.weighty = 0;
        gc.insets = new Insets(10, 10, 10, 10);
        // titulo "estudiantes"
        JLabel tEstudiante = new JLabel("Estudiantes");
        tEstudiante.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 0; gc.gridy = 0;
        gc.gridwidth = 3;
        gc.gridheight = 2;
        pEst.add(tEstudiante, gc);
        // numero estudiantes
        nEstudiantes = new JLabel("10");
        nEstudiantes.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 3; gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 2;
        pEst.add(nEstudiantes, gc);
        // botón Buscar
        gc.fill = GridBagConstraints.HORIZONTAL;
        JButton buscar = new JButton("Buscar");
        gc.gridx = 0; gc.gridy = 2;
        gc.gridwidth = 2;
        gc.gridheight = 1;
        pEst.add(buscar, gc);
        // Boton Registrar
        JButton regis = new JButton("registrar");
        gc.gridx = 2; gc.gridy = 2;
        gc.gridwidth = 2;
        gc.gridheight = 1;
        pEst.add(regis, gc);
        
        pEst.setAlignmentX(Component.CENTER_ALIGNMENT);
        left.add(pEst);

        left.add(Box.createRigidArea(new Dimension(0, 15)));
        //                      Boton Listar elementos
        JButton listar = new JButton("Listar estudiantes");
        listar.setMaximumSize(new Dimension(left.getPreferredSize().width, listar.getPreferredSize().height));
        listar.setAlignmentX(Component.CENTER_ALIGNMENT);
        left.add(listar);



        this.add(left, BorderLayout.WEST);
        // PANEL DERECHO
        this.add(adapt, BorderLayout.CENTER);
    }
}
