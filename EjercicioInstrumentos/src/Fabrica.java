import java.util.ArrayList;

public class Fabrica {
    private ArrayList<Sucursal> sucursales;

    public Fabrica() {
        this.sucursales = new ArrayList<>();
    }

    public void listarInstrumentosPorSucursal(){
        for (Sucursal sucursal: sucursales){
            System.out.println(sucursal.getNombre());

//Aca le estamos pidiendo a cada sucursal que nos entregue su listado de instrumentos por medio de su propio metodo de listado
            sucursal.listarInstrumentos();


        }
    }

    public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> tipoDeInstrumentosPorSucursal = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            System.out.println(sucursal.getNombre());
            tipoDeInstrumentosPorSucursal.addAll(sucursal.instrumentosPorTipo(tipo));
        }


        //Es importante tener cuenta la hora de trabajar con este método en el main respecto a lo que nos devuelve. Al ser un ArrayList, tenemos que tenerlo muy presente a la hora de querer mostrarlo en consola. Una opciones podria ser almacenarla en un arraylist en el main, para luego recorrerla e imprimir sus datos como nos sea útil.

        return tipoDeInstrumentosPorSucursal;
    }





    public void agregarSucursal(Sucursal suc){
        this.sucursales.add(suc);
    }
}
