package com.unal.residencias.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Lista extends JFrame{
    //pantalla para mostrar listas
    Object[][] info;
    String title;

    public Lista(String title, Object[][] info){
        this.info = info;
        this.title = title;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(title);
        setMinimumSize(new Dimension(700, 390));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        iniciar();
    }

    private void iniciar(){
        JLabel titulo = new JLabel(title);
        titulo.setFont(new Font("Sans-serif", Font.BOLD, 40));

        // Para hacer que no pueda editar las celdas
        DefaultTableModel model = new DefaultTableModel(info, new Object[]{"ID", "Nombre", "Puntaje"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retorna false para que ninguna celda sea editable
                return false;
            }
        };

        JTable t = new JTable(model);
        
        // Configurar encabezado de la tabla
        JTableHeader header = t.getTableHeader();
        header.setFont(new Font("Sans-serif", Font.BOLD, 14));
        
        // Configurar altura de filas
        t.setRowHeight(25);
        t.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        
        // Configurar ancho de columnas
        t.getColumnModel().getColumn(0).setPreferredWidth(150);
        t.getColumnModel().getColumn(1).setPreferredWidth(250);
        t.getColumnModel().getColumn(2).setPreferredWidth(150);
        
        // Desactivar reordenamiento de columnas
        t.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane scroll = new JScrollPane(t);
        t.setFillsViewportHeight(true);

        this.add(titulo, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}