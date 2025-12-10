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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.unal.residencias.Logic.SistemaResidencias;
import com.unal.residencias.Logic.Estudiante;

public class Buscar extends JFrame{

    private SistemaResidencias sistema;
    private String estudianteActualId;
    
    JTextField inId, inNombre, inPuntaje, buscaCod;
    JButton edit, delete, buscar;
    private boolean form;
    
    public Buscar(SistemaResidencias sistema){
        this.sistema = sistema;
        this.estudianteActualId = null;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Buscar");
        setMinimumSize(new Dimension(700, 390));
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
        buscaCod = new JTextField();
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
        buscar = new JButton("Buscar");
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
        inId = new JTextField();
        inId.setMaximumSize(new Dimension(1000, 30));
        inId.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inId.setBackground(new Color(230, 230, 230));
        inId.setEditable(false);
        right.add(inId);
        
        // Titulo nombre ------//------//------//------//------//------//
        JLabel infoNombre = new JLabel("Nombre");
        infoNombre.setFont(new Font("Sans-serif", Font.BOLD, 20));
        right.add(infoNombre);

        // campo nombre ------//------//------//------//------//------//
        inNombre = new JTextField();
        inNombre.setMaximumSize(new Dimension(1000, 30));
        inNombre.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inNombre.setBackground(new Color(230, 230, 230));
        inNombre.setEditable(false);
        right.add(inNombre);

        // Titulo Puntaje ------//------//------//------//------//------//
        JLabel infoPuntaje = new JLabel("Puntaje");
        infoPuntaje.setFont(new Font("Sans-serif", Font.BOLD, 20));
        right.add(infoPuntaje);

        // campo Puntaje ------//------//------//------//------//------//
        inPuntaje = new JTextField();
        inPuntaje.setMaximumSize(new Dimension(1000, 30));
        inPuntaje.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inPuntaje.setBackground(new Color(230, 230, 230));
        inPuntaje.setEditable(false);
        right.add(inPuntaje);

        right.add(Box.createRigidArea(new Dimension(0, 30)));
        JPanel buttons = new JPanel();
        buttons.setMaximumSize(new Dimension(1000, 70));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        // botones  ------//------//------//------//------//------//
        edit = new JButton("Editar");
        edit.setMaximumSize(new Dimension(1000, 30));
        edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttons.add(edit);

        buttons.add(Box.createRigidArea(new Dimension(0, 15)));

        delete = new JButton("Borrar");
        delete.setMaximumSize(new Dimension(1000, 30));
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttons.add(delete);

        right.add(buttons);

        this.add(right, BorderLayout.CENTER);

        addListeners();
    }

    private void addListeners(){
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editData();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteData();
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchData();
            }
        });
        
    }
    
    private void editable(boolean state){
        inNombre.setEditable(state);
        inPuntaje.setEditable(state);
    }

    private void editData(){
        if (estudianteActualId == null) {
            JOptionPane.showMessageDialog(this, "Primero debes buscar un estudiante.");
            return;
        }
        
        if(form){
            // si el formulario está habilitado y se da en editar otra vez, se actualiza la información
            try {
                int nuevoPuntaje = Integer.parseInt(inPuntaje.getText());
                if (nuevoPuntaje <= 0) {
                    throw new Exception();
                }
                
                boolean actualizado = sistema.modificarPuntaje(estudianteActualId, nuevoPuntaje);
                if (actualizado) {
                    JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente.");
                    editable(false);
                    form = false;
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el estudiante.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: el puntaje debe ser un entero positivo.");
            }
        }
        else{
            // habilitar los campos para edición
            editable(true);
            form = true;
            edit.setText("Guardar");
        }
    }

    private void deleteData(){
        if (estudianteActualId == null) {
            JOptionPane.showMessageDialog(this, "Primero debes buscar un estudiante.");
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que deseas eliminar este estudiante?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = sistema.eliminarEstudiante(estudianteActualId);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Estudiante eliminado correctamente.");
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el estudiante.");
            }
        }
    }
    
    private void searchData(){
        String id;
        try {
            if (buscaCod.getText().isBlank()) {
                throw new Exception();
            }
            id = buscaCod.getText().trim();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error, debes ingresar un ID válido.");
            return;
        }
        
        Estudiante est = sistema.consultarEstudiante(id);
        if (est != null) {
            estudianteActualId = id;
            inId.setText(est.getId());
            inNombre.setText(est.getNombre());
            inPuntaje.setText(String.valueOf(est.getPuntaje()));
            editable(false);
            form = false;
            edit.setText("Editar");
        } else {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado.");
            limpiarFormulario();
        }
    }
    
    private void limpiarFormulario() {
        estudianteActualId = null;
        inId.setText("");
        inNombre.setText("");
        inPuntaje.setText("");
        editable(false);
        form = false;
        edit.setText("Editar");
        buscaCod.setText("");
    }
}