package co.jmurillo.generics;

import co.jmurillo.poointerfaces.models.Cliente;
import co.jmurillo.poointerfaces.models.ClientePremiun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        // Creamos una lista genérica que solo puede contener objetos de tipo Cliente
        List<Cliente> clientes = new ArrayList<>();

        // Añadimos un nuevo Cliente a la lista
        clientes.add(new Cliente("Jefferson", "Murillo"));

        // Obtenemos el primer Cliente de la lista
        // No necesitamos hacer cast gracias a los genéricos
        Cliente jefferson = clientes.getFirst();

        // Creamos un array de Clientes
        Cliente[] clientesArreglo = {new Cliente("Jeff", "Palacio"),
                new Cliente("Xioma", "Murillo")};

        // Creamos un array de Integers
        Integer[] enterosArreglo = {1,2,3};

        // Convertimos el array de Clientes a una Lista de Clientes
        // usando nuestro método genérico fromArrayToList
        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);

        // Convertimos el array de Integers a una Lista de Integers
        // usando el mismo método genérico
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        // Imprimimos cada Cliente en clientesLista
        clientesLista.forEach(System.out::println);

        // Imprimimos cada Integer en enterosLista
        enterosLista.forEach(System.out::println);

        // Usamos la versión sobrecargada de fromArrayToList que acepta dos arrays
        // El primer array es de Strings, el segundo es de Integers
        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe",
                "Luci", "Bea", "John"}, enterosArreglo);

        // Imprimimos cada nombre en la lista nombres
        nombres.forEach(System.out::println);

        List<ClientePremiun> clientePremiunList = fromArrayToList(new ClientePremiun[]{
                new ClientePremiun("Jeff Antonio", "Murillo"),
                new ClientePremiun("Pedro Angel", "Murillo"),
                new ClientePremiun("Lucelly", "Palacio")
        });

        //clientePremiunList.forEach(System.out::println);

        imprimirClientes(clientePremiunList);
        imprimirClientes(clientesLista);
        imprimirClientes(clientes);

        System.out.println("\n==================================================");
        System.out.println("Maximo de 20, 90, 30 es: " + maximo(20, 90, 30));
        System.out.println("Maximo de 20.5, 80.6, 30.9 es: " + maximo(20.5, 80.6, 30.9));
        System.out.println("Maximo de 20, 100, 30 es: " + maximo("20", "100", "30"));
        System.out.println("Maximo de zanahoria, arándanos, manzanas: " + maximo("zanahoria", "arándanos", "Manzanas"));

    }
    public static <T extends Cliente & Comparable<T> > List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    // Método genérico para convertir un array a una lista
    // <T> define un parámetro de tipo que puede ser cualquier clase
    // Este método puede trabajar con arrays de cualquier tipo
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    // Versión sobrecargada del método fromArrayToList que acepta dos arrays
    // <T, G> define dos parámetros de tipo, permitiendo que el método
    // trabaje con dos tipos diferentes simultáneamente
    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        // Imprime cada elemento del segundo array
        for (G elemento: x){
            System.out.println(elemento);
        }
        // Devuelve una lista del primer array
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if (b.compareTo(max) > 0){
            max = b;
        }
        if (c.compareTo(max) > 0){
            max = c;
        }

        return max;

    }
}
