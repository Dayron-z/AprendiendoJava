package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;
import model.LibroModel;

import javax.swing.*;

public class LibroController {
    public static void insert() {
        LibroModel objModel = new LibroModel();

        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Inserta el precio del libro"));
        String titulo = JOptionPane.showInputDialog("Ingresa el nombre del libro");
        int año =  Integer.parseInt(JOptionPane.showInputDialog("Inserta el año de publicación del libro"));

        Libro objLibro = new Libro();
        objLibro.setTitulo(titulo);
        objLibro.setAño_publicacion(año);
        objLibro.setPrecio(precio);

        objLibro = (Libro) objModel.insert(objLibro);

        JOptionPane.showMessageDialog(null, objLibro.toString());
    }
}
