package com.iteso.sesion5;

import android.text.Editable;

import static java.lang.Boolean.TRUE;

/**
 * Created by hsm-y on 02/02/2018.
 */

public class Alumno {

    String nombre;
    String telefono;
    String escolaridad;
    String genero;
    String libro;
    boolean deporte;

    public Alumno(String nombre, String telefono, String escolaridad, String genero, String libro, boolean deporte){
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        this.genero = genero;
        this.libro = libro;
        this.deporte = deporte;
    }

    public String toString(){
        if(deporte == TRUE)
            return ("Nombre: " +nombre+ "\nTelefono: " +telefono+ "\nEscolaridad: " +escolaridad+ "\nGénero: " +genero+ "\nLibro Favorito: " +libro+ "\nPractica Deporte: Sí");
        else
            return ("Nombre: " +nombre+ "\nTelefono: " +telefono+ "\nEscolaridad: " +escolaridad+ "\nGénero: " +genero+ "\nLibro Favorito: " +libro+ "\nPractica Deporte: Sí");
    }

}
