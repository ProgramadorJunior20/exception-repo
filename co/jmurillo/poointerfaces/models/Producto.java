package co.jmurillo.poointerfaces.models;

public class Producto extends BaseEntity{

    private String descripcion;
    private Double precio;

    public Producto(String descripcion, Double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", id=" + id;
    }
}
