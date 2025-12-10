package com.unal.residencias.ui;

import javax.swing.JFrame;
import java.awt.*;

import com.unal.residencias.Logic.SistemaResidencias;

public class Ventana extends JFrame{
    public Ventana(String nombre, SistemaResidencias sistema){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(nombre);
        setMinimumSize(new Dimension(1000, 600));
        this.setLocationRelativeTo(null);

        PanelPrincipal p = new PanelPrincipal(sistema);

        this.add(p);
    }
}