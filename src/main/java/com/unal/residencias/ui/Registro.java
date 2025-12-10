package com.unal.residencias.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


// Pantalla para registrar.
public class Registro extends JFrame{

    JTextField inId, inNombre, inPuntaje;
    JButton regisBt;
    public Registro(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registrar");
        setMinimumSize(new Dimension(700, 390));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        ((JComponent) this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20,10, 50, 10));

        iniciar();
    }
    public void iniciar(){
        JLabel titulo = new JLabel("Registrar");
        titulo.setFont(new Font("Sans-serif", Font.BOLD, 40));
        this.add(titulo, BorderLayout.NORTH);

        // campos
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
        center.setBackground(Color.WHITE);
        center.setBorder(BorderFactory.createEmptyBorder(30,20, 40, 20));

        JPanel panelId = new JPanel();
        panelId.setLayout(new BoxLayout(panelId, BoxLayout.Y_AXIS));
        panelId.setBackground(Color.WHITE);

        JLabel infoId = new JLabel("ID");
        infoId.setFont(new Font("Sans-serif", Font.BOLD, 20));
        panelId.add(infoId);
        inId = new JTextField();
        inId.setMaximumSize(new Dimension(1000, 30));
        inId.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inId.setBackground(new Color(230, 230, 230));
        panelId.add(inId);

        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.Y_AXIS));
        panelNombre.setBackground(Color.WHITE);

        JLabel infoNombre = new JLabel("Nombre");
        infoNombre.setFont(new Font("Sans-serif", Font.BOLD, 20));
        panelNombre.add(infoNombre);
        // campo nombre ------//------//------//------//------//------//
        inNombre = new JTextField();
        inNombre.setMaximumSize(new Dimension(1000, 30));
        inNombre.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inNombre.setBackground(new Color(230, 230, 230));
        panelNombre.add(inNombre);

        JPanel panelPuntaje = new JPanel();
        panelPuntaje.setLayout(new BoxLayout(panelPuntaje, BoxLayout.Y_AXIS));
        panelPuntaje.setBackground(Color.WHITE);

        JLabel infoPuntaje = new JLabel("Puntaje");
        infoPuntaje.setFont(new Font("Sans-serif", Font.BOLD, 20));
        panelPuntaje.add(infoPuntaje);

        // campo Puntaje ------//------//------//------//------//------//
        inPuntaje = new JTextField();
        inPuntaje.setMaximumSize(new Dimension(1000, 30));
        inPuntaje.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inPuntaje.setBackground(new Color(230, 230, 230));
        panelPuntaje.add(inPuntaje);

        center.add(panelId);
        center.add(panelNombre);
        center.add(panelPuntaje);
        this.add(center, BorderLayout.CENTER);

        // Boton registrar ------//------//------//------//------//------//
        regisBt = new JButton("Registrar");
        this.add(regisBt, BorderLayout.SOUTH);

        addListeners();
    }
    private void addListeners(){
        regisBt.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertData();
            }
        });
    }
    private void insertData(){
        int id, puntaje;
        String nombre;
        try {
            if (inId.getText().isBlank() || inNombre.getText().isBlank() || inPuntaje.getText().isBlank())
                throw new Exception();
            id = Integer.parseInt(inId.getText());
            puntaje = Integer.parseInt(inPuntaje.getText());
            if (id <= 0)
                throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error, Campos invalidos");
            return;
        }
        System.out.println("inserting data");
    }

}
