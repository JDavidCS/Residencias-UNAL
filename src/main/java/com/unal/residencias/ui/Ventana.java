package com.unal.residencias.ui;

import javax.swing.JFrame;
import java.awt.*;

public class Ventana extends JFrame{
    public Ventana(String nombre){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(nombre);
        setMinimumSize(new Dimension(700, 400));
        this.setLocationRelativeTo(null);
    }
}
