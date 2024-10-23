package co.jmurillo.genericsclass;

public class EjemplosGenericos {
    public static <T> void imprimirCamion(Camion<T> camion){


    }
    public static void main(String[] args) {

        Camion<Animal> transporteCaballo = new Camion<>(2);

        transporteCaballo.add(new Animal("Peregrino", "Caballo"));
        transporteCaballo.add(new Animal("Grillo", "Caballo"));

        for (Animal a: transporteCaballo){
            System.out.println(a.getNombre()  + " " + a.getTipo());
        }

        System.out.println("======================MQ========================");
        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bolldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        for (Maquinaria m: transMaquinas){
            System.out.println(m.getTipo());
        }

        System.out.println("====================Auto========================");
        Camion<Automovil> transAutomovil = new Camion<>(1);
        transAutomovil.add(new Automovil("Ferrary"));
        transAutomovil.add(new Automovil("BMW"));

        for (Automovil a: transAutomovil){
            System.out.println(a.getMarca());
        }
    }
}