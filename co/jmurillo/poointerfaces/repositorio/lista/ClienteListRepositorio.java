package co.jmurillo.poointerfaces.repositorio.lista;

import co.jmurillo.poointerfaces.models.Cliente;
import co.jmurillo.poointerfaces.repositorio.AbstractaListRepositorio;
import co.jmurillo.poointerfaces.repositorio.Direccion;
import co.jmurillo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

// Implementación concreta que combina todas las interfaces
public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente resultado = this.porId(cliente.getId());
        resultado.setNombre(cliente.getNombre());
        resultado.setApellido(cliente.getApellido());
    }


    // Implementación de OrdenableRepositorio


    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    // Implementación de PaginableRepositorio


    // Método auxiliar para ordenamiento
    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
