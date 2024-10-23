package co.jmurillo.poointerfaces.models;

import java.util.Objects;

// Clase que representa a un Cliente en el sistema
public class Cliente extends BaseEntity{

    private String nombre;
    private String apellido;


    // Constructor con parámetros
    public Cliente(String nombre, String apellido) {
        super(); // Llama al constructor por defecto
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método para representar el objeto como String
    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
    }

}
