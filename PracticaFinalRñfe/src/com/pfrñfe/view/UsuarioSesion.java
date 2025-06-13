/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pfrñfe.view;

public class UsuarioSesion {
    private static int idUsuarioActual = -1;
    private static String nombreUsuarioActual = "";
    
 
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

