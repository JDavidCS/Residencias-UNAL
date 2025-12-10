package com.unal.residencias.util;

public class Util {

    public static boolean esEntero(String s) {
        if (s == null) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esNoVacio(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean esDouble(String s) {
        if (s == null) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

