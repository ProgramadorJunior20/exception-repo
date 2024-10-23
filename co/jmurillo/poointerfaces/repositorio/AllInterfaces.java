package co.jmurillo.poointerfaces.repositorio;

// Interfaz que combina múltiples interfaces para proporcionar
// una funcionalidad completa de repositorio
public interface AllInterfaces<T> extends
        OrdenableRepositorio<T>,
        PaginableRepositorio<T>,
        CrudRepositorio<T>,
        ContableRepositorio {
    // Esta interfaz no define métodos adicionales,
    // solo combina los métodos de las interfaces que extiende
}
