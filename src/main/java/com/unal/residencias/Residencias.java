package com.unal.residencias;

import com.unal.residencias.ui.Ventana;
import com.unal.residencias.Logic.SistemaResidencias;
import javax.swing.SwingUtilities;

public class Residencias {

    public static void main(String[] args) {
        // Asegura que la UI se cree en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearYMostrarGUI();
            }
        });
    }

    private static void crearYMostrarGUI() {
        // Crear el sistema de residencias con capacidad inicial de 100 estudiantes
        SistemaResidencias sistema = new SistemaResidencias(100);
        
        // Crear la ventana principal y pasarle el sistema
        Ventana ventana = new Ventana("Sistema de Residencias - UNAL", sistema);
        
        // Mostrar ventana
        ventana.setVisible(true);
    }
}