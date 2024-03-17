public class Auto {
    private String placa;
    private String color;
    private int revoluciones;

    public Auto(String placa, String color, int revoluciones) {
        this.placa = placa;
        this.color = color;
        this.revoluciones = revoluciones;
    }



    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRevoluciones() {
        return revoluciones;
    }

    public void setRevoluciones(int revoluciones) {
        this.revoluciones = revoluciones;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "placa='" + placa + '\'' +
                ", color='" + color + '\'' +
                ", revoluciones=" + revoluciones +
                '}';
    }
}
