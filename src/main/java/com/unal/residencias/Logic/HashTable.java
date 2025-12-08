package com.unal.residencias.Logic;

import java.util.LinkedList;

public class HashTable {
    private static class Entry {
        String key;
        Estudiante value;

        Entry(String key, Estudiante value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int size;
    private double loadFactor = 0.75;

    public HashTable(int initialCapacity) {
        table = new LinkedList[initialCapacity];
        size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(String key, Estudiante value) {
        if ((double) size / table.length >= loadFactor) {
            rehash();
        }
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }

    public Estudiante get(String key) {
        int index = hash(key);

        if (table[index] == null) return null;

        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean remove(String key) {
        int index = hash(key);

        if (table[index] == null) return false;

        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }
  
    public int size() {
        return size;
    }

    private void rehash() {
        LinkedList<Entry>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        size = 0;
        for (LinkedList<Entry> i : oldTable) {
            if (i != null) {
                for (Entry entry : i) {
                    put(entry.key, entry.value);
                }
            }
        }
    }
}

