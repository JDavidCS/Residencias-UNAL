package com.unal.residencias.ui;

import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import com.unal.residencias.Logic.SistemaResidencias;
import com.unal.residencias.Logic.Estudiante;

public class PanelPrincipal extends JPanel {

    private SistemaResidencias sistema;

    private JPanel panelDerecho;
    private JLabel lblNumEstudiantes;
    private JLabel lblInfoProgram;
    private JLabel lblParametros;
    private JButton btnListarEstudiantes, btnListarAsignados, btnListarRechazados;
    private JButton btnBuscar, btnRegistrar, btnAsignarCupos;
    private JFormattedTextField inputCupos;

    public PanelPrincipal(SistemaResidencias sistema) {
        this.sistema = sistema;
        this.setLayout(new BorderLayout());
        iniciar();
        setInformation(sistema.getTotalEstudiantes(), sistema.getCuposDisponibles());
    }

    private void iniciar() {
        JPanel panelIzquierdo = crearPanelIzquierdo();
        panelDerecho = crearPanelDerecho();

        this.add(panelIzquierdo, BorderLayout.WEST);
        this.add(panelDerecho, BorderLayout.CENTER);

        addListeners();
    }

    // -------------------- PANEL IZQUIERDO --------------------
    private JPanel crearPanelIzquierdo() {
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(new Color(180, 180, 180));
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelIzquierdo.setPreferredSize(new Dimension(350, 0));

        panelIzquierdo.add(crearPanelEstudiantes());
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 15)));
        panelIzquierdo.add(crearBotonListarEstudiantes());
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 15)));
        panelIzquierdo.add(crearPanelCupos());

        return panelIzquierdo;
    }

    private JPanel crearPanelEstudiantes() {
        JPanel panelEstudiantes = new JPanel(new GridBagLayout());
        panelEstudiantes.setMaximumSize(new Dimension(350, 100));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 10, 10);
        gc.weightx = 1;

        // Título
        JLabel lblTitulo = new JLabel("Estudiantes");
        lblTitulo.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 2;
        panelEstudiantes.add(lblTitulo, gc);

        // Número de estudiantes
        lblNumEstudiantes = new JLabel("0");
        lblNumEstudiantes.setFont(new Font("Sans-serif", Font.BOLD, 20));
        gc.gridx = 2; gc.gridy = 0; gc.gridwidth = 1;
        panelEstudiantes.add(lblNumEstudiantes, gc);

        // Botón Buscar
        btnBuscar = new JButton("Buscar");
        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 1; gc.fill = GridBagConstraints.HORIZONTAL;
        panelEstudiantes.add(btnBuscar, gc);

        // Botón Registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gc.gridx = 1; gc.gridy = 1;
        panelEstudiantes.add(btnRegistrar, gc);

        return panelEstudiantes;
    }

    private JButton crearBotonListarEstudiantes() {
        btnListarEstudiantes = new JButton("Listar estudiantes");
        btnListarEstudiantes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnListarEstudiantes.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListarEstudiantes.setMaximumSize(new Dimension(350, btnListarEstudiantes.getPreferredSize().height));
        return btnListarEstudiantes;
    }

    private JPanel crearPanelCupos() {
        JPanel panelCupos = new JPanel();
        panelCupos.setLayout(new BoxLayout(panelCupos, BoxLayout.Y_AXIS));
        panelCupos.setMaximumSize(new Dimension(350, 100));
        panelCupos.setBackground(Color.WHITE);

        JLabel lblTituloCupos = new JLabel("N° Residencias");
        lblTituloCupos.setFont(new Font("Sans-serif", Font.BOLD, 24));
        lblTituloCupos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCupos.add(lblTituloCupos);

        NumberFormatter formatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setAllowsInvalid(false);
        inputCupos = new JFormattedTextField(formatter);
        inputCupos.setMaximumSize(new Dimension(200, 40));
        inputCupos.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputCupos.setHorizontalAlignment(JTextField.CENTER);
        inputCupos.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        inputCupos.setBackground(new Color(230, 230, 230));
        panelCupos.add(inputCupos);

        return panelCupos;
    }

    // -------------------- PANEL DERECHO --------------------
    private JPanel crearPanelDerecho() {
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));

        btnAsignarCupos = new JButton("Asignar Cupos");
        btnAsignarCupos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAsignarCupos.setFont(new Font("Sans-serif", Font.BOLD, 28));
        btnAsignarCupos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(btnAsignarCupos);

        panelDerecho.add(Box.createRigidArea(new Dimension(0, 10)));
        lblInfoProgram = new JLabel("Lista generada:");
        lblInfoProgram.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        lblInfoProgram.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblInfoProgram.setVisible(false);
        panelDerecho.add(lblInfoProgram);

        panelDerecho.add(Box.createRigidArea(new Dimension(0, 5)));
        lblParametros = new JLabel();
        lblParametros.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        lblParametros.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblParametros.setVisible(false);
        panelDerecho.add(lblParametros);

        btnListarAsignados = new JButton("Listar Asignados");
        btnListarRechazados = new JButton("Listar Rechazados");
        btnListarAsignados.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListarRechazados.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListarAsignados.setMaximumSize(new Dimension(250, btnListarAsignados.getPreferredSize().height));
        btnListarRechazados.setMaximumSize(new Dimension(250, btnListarRechazados.getPreferredSize().height));
        btnListarAsignados.setVisible(false);
        btnListarRechazados.setVisible(false);

        panelDerecho.add(Box.createRigidArea(new Dimension(0, 20)));
        panelDerecho.add(btnListarAsignados);
        panelDerecho.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecho.add(btnListarRechazados);

        return panelDerecho;
    }

    // -------------------- LISTENERS --------------------
        // -------------------- LISTENERS --------------------
    private void addListeners() {
        btnAsignarCupos.addActionListener(e -> executeProgram());
        btnBuscar.addActionListener(e -> new Buscar(sistema).setVisible(true));
        btnRegistrar.addActionListener(e -> new Registro(sistema).setVisible(true));

        btnListarEstudiantes.addActionListener(e -> mostrarLista("Lista Estudiantes", toObjectMatrix(sistema.obtenerListaOrdenadaPorPuntaje())));
        btnListarAsignados.addActionListener(e -> mostrarLista("Lista Asignados", toObjectMatrix(sistema.listarAsignados())));
        btnListarRechazados.addActionListener(e -> mostrarLista("Lista NO admitidos", toObjectMatrix(sistema.listarNoAsignados())));
    }

    // -------------------- MÉTODOS AUXILIARES --------------------
    private void mostrarLista(String titulo, Object[][] data) {
        Lista lista = new Lista(titulo, data);
        lista.setVisible(true);
    }

    private Object[][] listaEjemplo() {
        return new Object[][]{
            {32390, "Samantha", 342},
            {49388924, "Daniel", 432},
            {49388925, "Laura", 220}
        };
    }

    public void executeProgram() {
        int cupos;
        try {
            if (inputCupos.getText().isBlank()) throw new Exception();
            cupos = Integer.parseInt(inputCupos.getText());
            if (cupos <= 0) throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: la cantidad de cupos debe ser un entero positivo.");
            return;
        }

        // Lógica de asignación: fijar cupos en el sistema y ejecutar la asignación
        sistema.establecerCupos(cupos);
        sistema.asignarCupos();

        // Actualizar la UI con los valores actuales
        setInformation(sistema.getTotalEstudiantes(), sistema.getCuposDisponibles());
    }

    public void setInformation(int estudiantes, int cupos) {
        lblInfoProgram.setVisible(true);
        lblParametros.setText(estudiantes + " estudiantes - " + cupos + " residencias");
        lblParametros.setVisible(true);

        btnListarAsignados.setVisible(true);
        btnListarRechazados.setVisible(true);

        lblNumEstudiantes.setText(String.valueOf(estudiantes));
    }

    private Object[][] toObjectMatrix(ArrayList<Estudiante> lista) {
        if (lista == null) return new Object[0][0];
        Object[][] data = new Object[lista.size()][3];
        for (int i = 0; i < lista.size(); i++) {
            Estudiante e = lista.get(i);
            data[i][0] = e.getId();
            data[i][1] = e.getNombre();
            data[i][2] = e.getPuntaje();
        }
        return data;
    }
}