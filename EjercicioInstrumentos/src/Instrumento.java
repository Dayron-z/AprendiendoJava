public class Instrumento {
    private String id;
    private double precio;
    private TipoInstrumento tipo;


    public Instrumento(String id, double precio, TipoInstrumento tipo) {
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
    }


    public TipoInstrumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstrumento tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Instrumento{" +
                "id='" + id + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }
}


