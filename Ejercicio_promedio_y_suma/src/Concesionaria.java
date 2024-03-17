import java.util.ArrayList;
import java.util.Scanner;

public class Concesionaria {

    private final String nombre;
    private final ArrayList<Auto> autos;



    public Concesionaria(String nombre) {
        this.nombre = nombre;
        this.autos = new ArrayList<>();
    }
    public int sumatoriaRecorridos(){
        int contador = 0;

        for (Auto auto: this.autos){
            contador += auto.getRevoluciones();
        }
        return contador;
    }
    public double promedio(){
        int suma =  sumatoriaRecorridos();
        double resultado = suma/autos.size();

        return resultado;
    }
    public void agregarAuto(Auto a){
        this.autos.add(a);
    }
    public int obtenerValorMaximo() {
        int numeroMayor = 0;
        for (Auto auto : autos) {
                    //1000
            if (numeroMayor <= auto.getRevoluciones()) {
                numeroMayor = auto.getRevoluciones();
            }
        }
        return numeroMayor;
    }
    public int obtenerValorMinimo() {
        int numeroMenor = autos.get(0).getRevoluciones();

        for (Auto auto : autos) {
            if (numeroMenor >= auto.getRevoluciones()) {
                numeroMenor = auto.getRevoluciones();
            }
        }
        return numeroMenor;
    }

    public Auto buscarPorPatente(String patenteABuscar) {
        Auto autoEncontrado = null;
        int contador = 0;
        while (contador < autos.size() && autoEncontrado == null) {
            if (autos.get(contador).getPlaca().equals(patenteABuscar)) {
                autoEncontrado = autos.get(contador);
                return  autoEncontrado;
            }
            contador++;
        }
        return null;
    }


/*    public Auto buscarPorPatente(String patenteABuscar) {
        for (Auto auto: autos){
            if (patenteABuscar.equals(auto.getPlaca())){
                return auto;
            }
        }
        return null;
    } */


}


