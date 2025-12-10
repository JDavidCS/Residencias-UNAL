package com.unal.residencias.Logic;

import java.util.ArrayList;
import java.util.Collections; // Para ordenar la lista de estudiantes

public class SistemaResidencias {
    private HashTable tablaEstudiantes;
    private MinHeap heapPermanente;
    private int cuposDisponibles;

    public SistemaResidencias(int capacidadInicial) {
        tablaEstudiantes = new HashTable(capacidadInicial);
        heapPermanente = new MinHeap();
        this.cuposDisponibles = 0;
    }

    // Requisito: Permitir ingresar cuántos son los cupos disponibles.
    public void establecerCupos(int cupos) {
        this.cuposDisponibles = cupos;
    }
    
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }
    
    // Requisito: Registrar estudiantes
    public boolean registrarEstudiante(String id, String nombre, int puntaje) {
        if (tablaEstudiantes.containsKey(id)) {
            return false;
        }
        
        Estudiante est = new Estudiante(id, nombre, puntaje);
        tablaEstudiantes.put(id, est);
        heapPermanente.insertar(est);
        return true;
    }
    
    // Requisito: Acceder directamente a los datos mediante el ID único
    public Estudiante consultarEstudiante(String id) {
        return tablaEstudiantes.get(id);
    }
    
    // Requisito: Permitir modificar el puntaje de un estudiante y que el sistema actualice su posición.
    public boolean modificarPuntaje(String id, int nuevoPuntaje) {
        Estudiante est = tablaEstudiantes.get(id);
        if (est == null) {
            return false;
        }
        
        // 1. Eliminar del Heap
        heapPermanente.delete(id); 
        // 2. Modificar el puntaje del objeto
        est.setPuntaje(nuevoPuntaje);
        // 3. Reinsertar en el Heap para actualizar su posición
        heapPermanente.insertar(est);
        
        return true;
    }
    
    // Requisito: Eliminar estudiantes del sistema.
    public boolean eliminarEstudiante(String id) {
        Estudiante est = tablaEstudiantes.get(id);
        if (est == null) {
            return false;
        }
        
        tablaEstudiantes.remove(id);
        heapPermanente.delete(id); 
        return true;
    }
    
    /**
     * Requisito: Asignar cupos disponibles comenzando por los estudiantes con menor puntaje.
     * Modifica el estado de asignación de los estudiantes.
     */
    public void asignarCupos() {
        // 1. Reiniciar el estado de asignación de todos
        ArrayList<Estudiante> todos = obtenerListaTotal();
        for (Estudiante e : todos) {
            e.setResidenciaAsignada(false);
        }
        
        // 2. Usar una copia del Heap para la asignación
        MinHeap copiaAsignacion = heapPermanente.copiar();
        
        int cupos = this.cuposDisponibles;
        
        // 3. Extraer a los N estudiantes más prioritarios y marcar su estado
        for (int i = 0; i < cupos && !copiaAsignacion.isEmpty(); i++) {
            Estudiante prioritarioCopia = copiaAsignacion.extractMin();
            if (prioritarioCopia == null) continue;

            // Obtener el objeto real desde la tabla usando el ID
            Estudiante original = tablaEstudiantes.get(prioritarioCopia.getId());
            if (original != null) {
                original.setResidenciaAsignada(true);
            }
        }
    }
    
    /** Obtiene todos los estudiantes registrados (a partir del Heap, ya que no hay getAllValues en HashTable) */
    public ArrayList<Estudiante> obtenerListaTotal() {
        // Se asume que MinHeap.getAll() retorna todos los elementos.
        return heapPermanente.getAll(); 
    }
    
    /**
     * Requisito: Listar estudiantes en orden creciente por puntaje socioeconómico.
     */
    public ArrayList<Estudiante> obtenerListaOrdenadaPorPuntaje() {
        ArrayList<Estudiante> lista = obtenerListaTotal(); 
        
        // Usa la implementación de compareTo de Estudiante (orden creciente)
        Collections.sort(lista);
        
        return lista;
    }
    
    // Requisito: Listar estudiantes que obtuvieron residencia.
    public ArrayList<Estudiante> listarAsignados() {
        ArrayList<Estudiante> asignados = new ArrayList<>();
        ArrayList<Estudiante> todos = obtenerListaTotal();
        
        for (Estudiante e : todos) {
            if (e.isResidenciaAsignada()) {
                asignados.add(e);
            }
        }
        return asignados;
    }
    
    // Requisito: Listar estudiantes que no obtuvieron residencia.
    public ArrayList<Estudiante> listarNoAsignados() {
        ArrayList<Estudiante> noAsignados = new ArrayList<>();
        ArrayList<Estudiante> todos = obtenerListaTotal();
        
        for (Estudiante e : todos) {
            if (!e.isResidenciaAsignada()) {
                noAsignados.add(e);
            }
        }
        return noAsignados;
    }

    public int getTotalEstudiantes() {
        return tablaEstudiantes.size();
    }
}