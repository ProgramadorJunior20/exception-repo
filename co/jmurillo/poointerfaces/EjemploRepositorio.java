package co.jmurillo.poointerfaces;

import co.jmurillo.poointerfaces.models.Cliente;
import co.jmurillo.poointerfaces.repositorio.*;
import co.jmurillo.poointerfaces.repositorio.excepciones.AccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import co.jmurillo.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            // Creación del repositorio utilizando la interfaz AllInterfaces
            AllInterfaces<Cliente> repo = new ClienteListRepositorio();

            // Creación de clientes
            repo.crear(new Cliente("Jeferson", "Murillo"));
            repo.crear(new Cliente("Ladys Smith", "Murillo"));
            repo.crear(new Cliente("Crud", "Repositorio"));
            repo.crear(new Cliente("Lucy", "Gunz"));

            repo.crear(null);

            // Listado de todos los clientes
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);

            // Demostración de paginación
            System.out.println("--------------- Paginable -------------------");
            List<Cliente> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);

            // Demostración de ordenamiento
            System.out.println("--------------- Ordenable -------------------");
            List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.ASC);
            for (Cliente c : clientesOrdenAsc) {
                System.out.println(c);
            }

            // Demostración de edición
            System.out.println("--------------- Editar -------------------");
            Cliente jeffActualizar = new Cliente("Jeff", "Palacio");
            jeffActualizar.setId(1);
            repo.editar(jeffActualizar);
            Cliente jeff = repo.porId(1);
            System.out.println(jeff + "\n");
            repo.listar("apellido", Direccion.DESC).forEach(System.out::println);

            // Demostración de eliminación
            System.out.println("--------------- Eliminar -------------------");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            // Demostración del conteo total
            System.out.println("--------------- Total -------------------");
            System.out.println("Registros Total: " + repo.total());
        }catch (RegistroDuplicadoAccesoDatoException e){
            System.out.println("Registro Duplicado: " + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        }catch (EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        }catch (AccesoDatoException e){
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}