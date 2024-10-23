package co.jmurillo.poointerfaces.repositorio;

import co.jmurillo.poointerfaces.models.Cliente;
import co.jmurillo.poointerfaces.repositorio.excepciones.AccesoDatoException;



import java.util.List;

// Interfaz que define las operaciones CRUD para la entidad Cliente
public interface CrudRepositorio<T> {
    // Método para listar todos los clientes
    List<T> listar();

    // Método para buscar un cliente por su ID
    T porId(Integer id) throws AccesoDatoException;

    // Método para crear un nuevo cliente
    void crear(T t) throws AccesoDatoException;

    // Método para editar un cliente existente
    void editar(T t) throws AccesoDatoException;

    // Método para eliminar un cliente por su ID
    void eliminar(Integer id) throws AccesoDatoException;
}
