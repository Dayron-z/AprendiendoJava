
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Fabrica f = new Fabrica();
        cargarFabrica(f);


        System.out.println(f.instrumentosPorTipo(TipoInstrumento.VIENTO));




    }


    private static void cargarFabrica(Fabrica f){
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B");


        s1.agregarInstrumento(new Instrumento("01A", 2000, TipoInstrumento.VIENTO));
        s1.agregarInstrumento(new Instrumento("02A", 2000, TipoInstrumento.CUERDA));
        s1.agregarInstrumento(new Instrumento("03A", 2000, TipoInstrumento.PERCUSION));

        s2.agregarInstrumento(new Instrumento("01B", 2000, TipoInstrumento.VIENTO));
        s2.agregarInstrumento(new Instrumento("02B", 2000, TipoInstrumento.PERCUSION));




        f.agregarSucursal(s1);
        f.agregarSucursal(s2);
    }
}