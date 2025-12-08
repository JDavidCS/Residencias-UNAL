package com.unal.residencias.Logic;

import java.util.ArrayList;

public class SistemaResidencias {
    private HashTable tablaEstudiantes;
    private MinHeap heapPermanente;
    
    public SistemaResidencias(int capacidadInicial) {
        tablaEstudiantes = new HashTable(capacidadInicial);
        heapPermanente = new MinHeap();
    }
    
    public boolean registrarEstudiante(String id, String nombre, int puntaje) {
        if (tablaEstudiantes.containsKey(id)) {
            return false;
        }
        
        Estudiante est = new Estudiante(id, nombre, puntaje);
        tablaEstudiantes.put(id, est);
        heapPermanente.insertar(est);
        return true;
    }
    
    public Estudiante consultarEstudiante(String id) {
        return tablaEstudiantes.get(id);
    }
    
    public boolean modificarPuntaje(String id, int nuevoPuntaje) {
        Estudiante est = tablaEstudiantes.get(id);
        if (est == null) {
            return false;
        }
        
        heapPermanente.delete(id);
        est.setPuntaje(nuevoPuntaje);
        heapPermanente.insertar(est);
        
        return true;
    }
    
    public boolean eliminarEstudiante(String id) {
        Estudiante est = tablaEstudiantes.get(id);
        if (est == null) {
            return false;
        }
        
        tablaEstudiantes.remove(id);
        heapPermanente.delete(id);
        return true;
    }
    
    public ArrayList<Estudiante> listarEstudiantesPorPuntaje() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        MinHeap copiaTemp = heapPermanente.copiar();
        
        while (!copiaTemp.isEmpty()) {
            lista.add(copiaTemp.extractMin());
        }
        
        return lista;
    }
    
    public ResultadoAsignacion asignarCupos(int cuposDisponibles) {
        if (cuposDisponibles <= 0) {
            return null;
        }
        
        if (cuposDisponibles > tablaEstudiantes.size()) {
            cuposDisponibles = tablaEstudiantes.size();
        }
        
        ArrayList<Estudiante> aceptados = new ArrayList<>();
        ArrayList<Estudiante> noAceptados = new ArrayList<>();
        
        MinHeap copiaAsignacion = heapPermanente.copiar();
        
        for (int i = 0; i < cuposDisponibles && !copiaAsignacion.isEmpty(); i++) {
            aceptados.add(copiaAsignacion.extractMin());
        }
        
        while (!copiaAsignacion.isEmpty()) {
            noAceptados.add(copiaAsignacion.extractMin());
        }
        
        return new ResultadoAsignacion(aceptados, noAceptados);
    }
    
    public int getTotalEstudiantes() {
        return tablaEstudiantes.size();
    }
    
    public static class ResultadoAsignacion {
        private ArrayList<Estudiante> aceptados;
        private ArrayList<Estudiante> noAceptados;
        
        public ResultadoAsignacion(ArrayList<Estudiante> aceptados, ArrayList<Estudiante> noAceptados) {
            this.aceptados = aceptados;
            this.noAceptados = noAceptados;
        }
        
        public ArrayList<Estudiante> getAceptados() {
            return aceptados;
        }
        
        public ArrayList<Estudiante> getNoAceptados() {
            return noAceptados;
        }
    }
}