package co.jmurillo.poointerfaces.repositorio;

import co.jmurillo.poointerfaces.models.BaseEntity;
import co.jmurillo.poointerfaces.models.Cliente;
import co.jmurillo.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

// Implementación concreta que combina todas las interfaces
public abstract class AbstractaListRepositorio<T extends BaseEntity> implements AllInterfaces<T> {

    protected List<T> dataSource;

    // Constructor: inicializa el ArrayList
    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    // Implementación de CrudRepositorio

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if (id == null || id <= 0){
            throw new LecturaAccesoDatoException("Id invalido, Debe ser mayor a zero!!");
        }
        T resultado = null;
        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        if (resultado == null){
            throw new LecturaAccesoDatoException("No Existe el registro con el id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if (t == null){
            throw new EscrituraAccesoDatoException("Error!! al Insertar un objeto null");
        }
        if (this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error!! esta intentando crear el mismo objet"
                    + t.getId() + " existe ya en el repositorio.");
        }
        this.dataSource.add(t);
    }


    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id));
    }

    // Implementación de PaginableRepositorio

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    // Método adicional para obtener el total de elementos
    @Override
    public int total() {
        return this.dataSource.size();
    }
}
