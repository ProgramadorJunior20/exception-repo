package co.jmurillo.poointerfaces.repositorio;

import co.jmurillo.poointerfaces.models.Cliente;

import java.util.List;

// Interfaz que define la operación de listar con ordenamiento
public interface OrdenableRepositorio<T> {
    // Método para listar clientes con ordenamiento
    // @param campo: el campo por el cual se ordenará la lista
    // @param dir: la dirección del ordenamiento (ascendente o descendente)
    // @return Lista de clientes ordenada según los parámetros especificados
    List<T> listar(String campo, Direccion dir);
}
