package entity;

public class Libro {
    private int id;
    private String titulo;
    private int  año_publicacion;
    private int id_autor;


    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año_publicacion=" + año_publicacion +
                ", id_autor=" + id_autor +
                '}';
    }

    public Libro(int id, String titulo, int año_publicacion, int id_autor) {
        this.id = id;
        this.titulo = titulo;
        this.año_publicacion = año_publicacion;
        this.id_autor = id_autor;
    }


    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(int año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
}
