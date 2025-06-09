
package com.p10.model.entities;


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
    
    /**
     * Obtiene el ID del usuario actual
     * @return ID del usuario logueado, -1 si no hay usuario logueado
     */
    public static int getIdUsuario() {
        return idUsuarioActual;
    }
    
    /**
     * Obtiene el nombre del usuario actual
     * @return Nombre del usuario logueado, cadena vacía si no hay usuario
     */
    public static String getNombreUsuario() {
        return nombreUsuarioActual;
    }
    
    /**
     * Verifica si hay un usuario logueado
     * @return true si hay usuario logueado, false en caso contrario
     */
    public static boolean hayUsuarioLogueado() {
        return idUsuarioActual != -1;
    }
    
    /**
     * Cierra la sesión del usuario actual
     */
    public static void cerrarSesion() {
        idUsuarioActual = -1;
        nombreUsuarioActual = "";
    }
}
