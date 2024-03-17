import java.util.ArrayList;

public class Sucursal {
    private String nombre;
    private ArrayList<Instrumento>instrumentos;


    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.instrumentos = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void listarInstrumentos(){
        for (Instrumento instrumento: instrumentos){
            System.out.println(instrumento);
        }
    }

    public void agregarInstrumento(Instrumento ins){
        this.instrumentos.add(ins);
    }

    public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> instrumentosEncontrados = new ArrayList<>();

        for (Instrumento instrumento : instrumentos) {
            if (tipo == instrumento.getTipo()) {
                instrumentosEncontrados.add(instrumento);
            }
        }

        return instrumentosEncontrados;
    }













    @Override
    public String toString() {
        return "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", instrumentos=" + instrumentos +
                '}';
    }
}
