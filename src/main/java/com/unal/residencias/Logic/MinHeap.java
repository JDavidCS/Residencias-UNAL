package com.unal.residencias.Logic;

import java.util.ArrayList;

public class MinHeap{
    private ArrayList<Estudiante> heap;

    public MinHeap(){
        heap = new ArrayList<>();
    }

    private int parent(int i){ 
        return (i - 1) / 2; 
    }
    
    private int leftChild(int i){ 
        return 2 * i + 1; 
    }
    
    private int rightChild(int i){ 
        return 2 * i + 2; 
    }
    
    private void swap(int i, int j) {
        Estudiante temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }    

    private void siftUp(int i) {
        // Uso de compareTo para determinar la prioridad (menor puntaje = > 0)
        while (i > 0 && heap.get(parent(i)).compareTo(heap.get(i)) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int min = i;

        int left = leftChild(i);
        // Uso de compareTo para la comparación
        if (left < heap.size() && heap.get(left).compareTo(heap.get(min)) < 0) {
            min = left;
        }
        
        int right = rightChild(i);
        // Uso de compareTo para la comparación
        if (right < heap.size() && heap.get(right).compareTo(heap.get(min)) < 0) {
            min = right;
        }

        if (min != i) {
            swap(i, min);
            siftDown(min);
        }
    }

    public void insertar(Estudiante est){
        heap.add(est);
        siftUp(heap.size() - 1);
    }

    public Estudiante extractMin() {
        if (heap.isEmpty()) {
            return null; 
        }
        
        Estudiante min = heap.get(0); 
        Estudiante lastElement = heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            siftDown(0);
        }
        
        return min;
    }

    public boolean delete(String id){
        int index = -1;

        for (int i = 0; i < heap.size(); i++){
            if (heap.get(i).getId().equals(id)){
                index = i;
                break;
            }
        }

        if (index == -1) return false;

        if (index == heap.size() - 1){
            heap.remove(heap.size() - 1);
            return true;
        }

        Estudiante lastElement = heap.remove(heap.size() - 1);
        heap.set(index, lastElement);

        siftUp(index);
        siftDown(index);
        return true;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){ 
        return heap.isEmpty(); 
    }

    public MinHeap copiar() {
        MinHeap copia = new MinHeap();
        for (Estudiante est : heap) {
            Estudiante copiaEst = new Estudiante(
                est.getId(), 
                est.getNombre(), 
                est.getPuntaje()
            );
            copia.heap.add(copiaEst);
        }
        return copia;
    }
    
    public ArrayList<Estudiante> getAll() {
        return new ArrayList<>(heap);
    }
}
