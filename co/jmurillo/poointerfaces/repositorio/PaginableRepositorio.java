package co.jmurillo.poointerfaces.repositorio;

import co.jmurillo.poointerfaces.models.Cliente;

import java.util.List;

// Interfaz que define la operación de listar con paginación
public interface PaginableRepositorio<T> {
    // Método para listar clientes con paginación
    // @param desde: índice inicial de la página
    // @param hasta: índice final de la página
    // @return Lista de clientes dentro del rango especificado
    List<T> listar(int desde, int hasta);
}