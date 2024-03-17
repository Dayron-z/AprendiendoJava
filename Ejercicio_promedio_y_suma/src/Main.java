import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Instanciamos concesionaria
        Concesionaria concesionaria = new Concesionaria("FakeCar");
        Scanner objScanner = new Scanner(System.in);

        //Autos para testear, el metodo espera un objeto de la clase Auto para agregarlo a la lista

        concesionaria.agregarAuto(new Auto("2A20A0", "Rojo", 1000));
        concesionaria.agregarAuto(new Auto("3A30A0", "Amarillo", 5000));
        concesionaria.agregarAuto(new Auto("4A40A0", "Verde", 9000));
        concesionaria.agregarAuto(new Auto("5A50A0", "Naranja", 2000));



        //Primer ejercicio, en este ejercicio buscamos sumar todos las revoluciones de cada uno de los carros, y a su vez creamos el método para sacar el promedio
/*        System.out.println(concesionaria.sumatoriaRecorridos());
        System.out.println(concesionaria.promedio());*/


        //Segundo ejercicio queremos sacar el valor de revoluciones minimo y máximo
/*        System.out.println("El auto con mas kilometros recorridos, tiene "+  concesionaria.obtenerValorMaximo()  + " kilometros recorrridos");
        System.out.println("----------------------------------------");
        System.out.println(concesionaria.obtenerValorMinimo());*/

        //Buscar en una coleccion de objetos en java
        System.out.println("Ingrese la patente del auto que desea buscar");
        String patenteABuscar = objScanner.next();

        if (concesionaria.buscarPorPatente(patenteABuscar) == null){
            System.out.println("Esa placa no existe");
        } else{
            System.out.println(concesionaria.buscarPorPatente(patenteABuscar));
        }








    }
}