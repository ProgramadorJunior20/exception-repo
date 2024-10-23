package co.jmurillo.poointerfaces.models;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    // Variable estática para mantener el último ID asignado
    private static int ultimoId;

    // Constructor por defecto
    public BaseEntity() {
        // Asigna automáticamente el siguiente ID disponible
        this.id = ++ultimoId;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Método para comparar si dos objetos Cliente son iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si es el mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false; // Si es null o de diferente clase
        BaseEntity base = (BaseEntity) o; // Casting seguro
        return Objects.equals(id, base.id); // Compara los IDs usando Objects.equals
    }

    // Método para generar un código hash del objeto
    @Override
    public int hashCode() {
        return Objects.hashCode(id); // Genera el hash basado en el ID
    }
}
