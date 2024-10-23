package co.jmurillo.poointerfaces;

import co.jmurillo.poointerfaces.models.Cliente;
import co.jmurillo.poointerfaces.models.Producto;
import co.jmurillo.poointerfaces.repositorio.AllInterfaces;
import co.jmurillo.poointerfaces.repositorio.Direccion;
import co.jmurillo.poointerfaces.repositorio.excepciones.AccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.lista.ClienteListRepositorio;
import co.jmurillo.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {

            // Creación del repositorio utilizando la interfaz AllInterfaces
            AllInterfaces<Producto> repo = new ProductoListRepositorio();

            // Creación de clientes
            repo.crear(new Producto("Mesa", 12.1));
            repo.crear(new Producto("Pc", 123.1));
            repo.crear(new Producto("Modemn", 88.9));
            repo.crear(new Producto("Materia Prima", 99.9));

            // Listado de todos los clientes
            List<Producto> clientes = repo.listar();
            clientes.forEach(System.out::println);

            // Demostración de paginación
            System.out.println("--------------- Paginable -------------------");
            List<Producto> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);

            // Demostración de ordenamiento
            System.out.println("--------------- Ordenable -------------------");
            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
            for (Producto c : productosOrdenAsc) {
                System.out.println(c);
            }

            // Demostración de edición
            System.out.println("--------------- Editar -------------------");
            Producto mesaActualizar = new Producto("Mesa Ortopedica", 100.1);
            mesaActualizar.setId(1);
            repo.editar(mesaActualizar);
            Producto mesa = repo.porId(1);
            System.out.println(mesa + "\n");
            repo.listar("descripcion", Direccion.DESC).forEach(System.out::println);

            // Demostración de eliminación
            System.out.println("--------------- Eliminar -------------------");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            // Demostración del conteo total
            System.out.println("--------------- Total -------------------");
            System.out.println("Registros Total: " + repo.total());
        }catch (LecturaAccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (AccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}