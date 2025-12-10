package com.unal.residencias.Logic; 

// Implementa Comparable para que MinHeap ordene por puntaje (menor es mejor)
public class Estudiante implements Comparable<Estudiante> {
    
    private String id;
    private String nombre;
    private int puntaje;
    private boolean residenciaAsignada; // Nuevo campo para el estado de asignación

    public Estudiante() {
    }

    public Estudiante(String id, String nombre, int puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.residenciaAsignada = false; // Por defecto, no asignada
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPuntaje() { return puntaje; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }
    
    // Nuevo Getter y Setter para el estado de asignación
    public boolean isResidenciaAsignada() { return residenciaAsignada; }
    public void setResidenciaAsignada(boolean residenciaAsignada) { this.residenciaAsignada = residenciaAsignada; }

    @Override
    public String toString() {
        String estado = residenciaAsignada ? "Asignada" : "No Asignada";
        return "Estudiante [ID=" + id + ", Nombre=" + nombre + ", Puntaje=" + puntaje + ", Residencia=" + estado + "]";
    }
    
    /**
     * Implementación de Comparable: compara por puntaje.
     * Retorna un valor negativo si este objeto tiene MAYOR prioridad (menor puntaje).
     */
    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.puntaje, otro.puntaje);
    }
}