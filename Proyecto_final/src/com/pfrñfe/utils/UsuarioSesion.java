
package com.pfrñfe.utils;


public class UsuarioSesion {
    private static int idUsuarioActual = -1;
    private static String nombreUsuarioActual = "";
    
    /**
     * Establece los datos del usuario logueado
     * @param id ID del usuario
     * @param nombre Nombre del usuario
     */
    public static void setUsuario(int id, String nombre) {
        idUsuarioActual = id;
        nombreUsuarioActual = nombre;
    }
    
    public static int getIdUsuario() {
        return idUsuarioActual;
    }
    
    public static String getNombreUsuario() {
        return nombreUsuarioActual;
    }
    

    public static boolean hayUsuarioLogueado() {
        return idUsuarioActual != -1;
    }
    
    public static void cerrarSesion() {
        idUsuarioActual = -1;
        nombreUsuarioActual = "";
    }
}
