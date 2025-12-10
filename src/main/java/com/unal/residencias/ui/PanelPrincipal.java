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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPrincipal extends JPanel{
    JPanel right;
    JLabel nEstudiantes;
    private JLabel infoProgram;
    private JLabel parametros;
    private JButton listarAsig, listarRe, buscar, regis, listar, run;
    private JTextField inputCupos;

    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        iniciar();
    }
    private void iniciar(){        
        //------//------//------//------//------//------//
        // ------//------ PANEL IZQUIERDA ------//------//
        //------//------//------//------//------//------//
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(new Color(180, 180, 180));
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));
        left.setPreferredSize(new Dimension(350, left.getPreferredSize().height));

        // ------//------//------ Panel Estudiante ------//------//------//------//
        JPanel pEst = new JPanel();
        pEst.setMaximumSize(new Dimension(left.getPreferredSize().width, 100));
        pEst.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1; gc.weighty = 0;
        gc.insets = new Insets(10, 10, 10, 10);

        // titulo "estudiantes" ------//------//------//------//------//
        JLabel tEstudiante = new JLabel("Estudiantes");
        tEstudiante.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 0; gc.gridy = 0;
        gc.gridwidth = 3;
        gc.gridheight = 2;
        pEst.add(tEstudiante, gc);

        // numero estudiantes ------//------//------//------//------//
        nEstudiantes = new JLabel("10");
        nEstudiantes.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 3; gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 2;
        pEst.add(nEstudiantes, gc);

        // botón Buscar ------//------//------//------//------//------//
        gc.fill = GridBagConstraints.HORIZONTAL;
        buscar = new JButton("Buscar");
        buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gc.gridx = 0; gc.gridy = 2;
        gc.gridwidth = 2;
        gc.gridheight = 1;
        pEst.add(buscar, gc);

        // Boton Registrar ------//------//------//------//------//
        regis = new JButton("registrar");
        regis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gc.gridx = 2; gc.gridy = 2;
        gc.gridwidth = 2;
        gc.gridheight = 1;
        pEst.add(regis, gc);
        
        pEst.setAlignmentX(Component.CENTER_ALIGNMENT);
        left.add(pEst);

        left.add(Box.createRigidArea(new Dimension(0, 15)));


        // ------//------//------ Boton Listar elementos ------//------//------//------//
        listar = new JButton("Listar estudiantes");
        listar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        listar.setMaximumSize(new Dimension(left.getPreferredSize().width, listar.getPreferredSize().height));
        listar.setAlignmentX(Component.CENTER_ALIGNMENT);
        left.add(listar);

        left.add(Box.createRigidArea(new Dimension(0, 15)));

        //                      Panel - cantidad de cupos
        JPanel pCupos = new JPanel();
        pCupos.setLayout(new BoxLayout(pCupos, BoxLayout.Y_AXIS));
        pCupos.setMaximumSize(new Dimension(left.getPreferredSize().width, 100));
        pCupos.setBackground(new Color(255, 255, 255));

        JLabel tCupos = new JLabel("N° Residencias");
        tCupos.setFont(new Font("Sans-serif", Font.BOLD, 24));
        tCupos.setAlignmentX(Component.CENTER_ALIGNMENT);
        pCupos.add(tCupos);

        inputCupos = new JTextField();
        inputCupos.setMaximumSize(new Dimension((left.getPreferredSize().width*3/5), inputCupos.getPreferredSize().height*2));
        inputCupos.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputCupos.setHorizontalAlignment(JTextField.CENTER);
        inputCupos.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inputCupos.setBackground(new Color(230, 230, 230));
        pCupos.add(inputCupos);

        left.add(pCupos);
        this.add(left, BorderLayout.WEST);


        //------//------//------//------//------//------//
        //------//------   PANEL DERECHO  ------//------//
        //------//------//------//------//------//------//
        
        right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));

        
        run = new JButton("Asignar Cupos");
        run.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        run.setFont(new Font("Sans-serif", Font.BOLD, 28));
        run.setAlignmentX(Component.CENTER_ALIGNMENT);
        right.add(run);
        

        // información una vez se ejecute el programa.
        right.add(Box.createRigidArea(new Dimension(0, 10)));
        infoProgram = new JLabel("Lista generada:");
        infoProgram.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        infoProgram.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        infoProgram.setVisible(false);
        right.add(infoProgram);

        right.add(Box.createRigidArea(new Dimension(0, 5)));
        parametros = new JLabel("135 estudiantes - 50 residencias");
        parametros.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        parametros.setAlignmentX(Component.CENTER_ALIGNMENT);
        parametros.setVisible(false);
        right.add(parametros);

        listarAsig = new JButton("Listar Asignados");
        listarRe = new JButton("Listar Rechazados");
        listarAsig.setAlignmentX(Component.CENTER_ALIGNMENT);
        listarRe.setAlignmentX(Component.CENTER_ALIGNMENT);
        listarAsig.setMaximumSize(new Dimension(right.getPreferredSize().width, listarAsig.getPreferredSize().height));
        listarRe.setMaximumSize(new Dimension(right.getPreferredSize().width, listarRe.getPreferredSize().height));
        listarAsig.setVisible(false);
        listarRe.setVisible(false);

        right.add(Box.createRigidArea(new Dimension(0, 20)));
        right.add(listarAsig);
        right.add(Box.createRigidArea(new Dimension(0, 10)));
        right.add(listarRe);


        this.add(right, BorderLayout.CENTER);

        addListeners();
    }

    private void addListeners(){
        // Asignar Cupos
        run.addActionListener(new ActionListener() {
            // !!!!!!!!!!!!!!!!!!!!Pasar Parametros usados !!!!!!!!!!!!!!!!!!!!!!

            @Override
            public void actionPerformed(ActionEvent e) {
                // setInformation(100, 40);
                executeProgram();
            }

        });

        // Abrir buscador
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Buscar v = new Buscar();
                v.setVisible(true);
            }
        });

        regis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro v = new Registro();
                v.setVisible(true);
            }
        });

        // Listar todos los estudiantes
        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //!!!!!!!!!!!!!!!!!!!!!Obtener todos los estudiantes!!!!!!!!!!!!!!!!!!!!!!!!

                Object[][] list = { { 32390, "Samantha", 342 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 }

                };

                Lista v = new Lista("Lista Estudiantes", list);
                v.setVisible(true);
            }
        });

        listarAsig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // !!!!!!!!!!!! Obtener lista de los estudiantes asignados

                Object[][] list = { { 32390, "Samantha", 342 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 }

                };

                Lista v = new Lista("Lista Asignados", list);
                v.setVisible(true);
            }
        });

        listarRe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // !!!!!!!!!!!! Obtener lista de los estudiantes asignados !!!!!!!!!!!!

                Object[][] list = { { 32390, "Samantha", 342 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 },
                        { 49388924, "Daniel", 432 }

                };

                Lista v = new Lista("Lista NO admitidos", list);
                v.setVisible(true);
            }
        });
    }

    public void executeProgram(){

        // ACÁ SE EJECUTA TODO EL PROGRAMA PARA ASIGNAR CUPOS

        // obtenemos el número de cupos y verificamos que no hayan errores.
        int cupos;
        try {
            if(inputCupos.getText().isBlank()) throw new Exception();
            cupos = Integer.parseInt(inputCupos.getText());
            if(cupos <= 0) throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error, La cantidad de cupos debe ser un entero positivo diferente de 0");
            return;
        }
        // si el número es valido, sigue el programa (si el número es decimal, se redondea)

        // INCLUIR LÓGICA DEL PROGRAMA

        
        // mostrar información en pantalla.
        setInformation(100, cupos);
    }

    public void setInformation(int estudiantes, int cupos){
        // una vez se corre el programa, se muestran los parámetros y los botones para obtener los resultados.
        infoProgram.setVisible(true);
        parametros.setText(estudiantes+" estudiantes - "+cupos+" residencias");
        parametros.setVisible(true);

        listarAsig.setVisible(true);
        listarRe.setVisible(true);
    }

}
