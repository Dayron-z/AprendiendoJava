package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;
import model.LibroModel;

import javax.swing.*;

public class LibroController {
    public static void insert() {
        LibroModel objModel = new LibroModel();


        int idAutor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del autor del libro"));
        String titulo = JOptionPane.showInputDialog("Ingresa el nombre del libro");
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Inserta el precio del libro"));
        int año =  Integer.parseInt(JOptionPane.showInputDialog("Inserta el año de publicación del libro"));


        Libro objLibro = new Libro();
        objLibro.setTitulo(titulo);
        objLibro.setAño_publicacion(año);
        objLibro.setPrecio(precio);
        objLibro.setId_autor(idAutor);

        objLibro = (Libro) objModel.insert(objLibro);

        JOptionPane.showMessageDialog(null, objLibro.toString());
    }

    public static void findAll(){
        LibroModel objModel = new LibroModel();
        //Inicializar string siempre que queramos mostrar de manera mas organizada
        String listLibros  = "️📝 Lista de libros \n";

        //Ponemos tipo de dato object porque con eso estamos trabajando
        for (Object libro: objModel.findAll()){
            Libro objLibro = (Libro) libro;

            listLibros += objLibro.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,  listLibros);
    }


    public static String findAllString(){
        LibroModel objModel = new LibroModel();
        //Inicializar string siempre que queramos mostrar de manera mas organizada
        String listLibros  = "️📝 Lista de libros \n";

        //Ponemos tipo de dato object porque con eso estamos trabajando
        for (Object libro: objModel.findAll()){
            Libro objLibro = (Libro) libro;

            listLibros += objLibro.toString() + "\n";
        }

        return listLibros;
    }

    public static void GetLibroId(){
        int id =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que desea buscar"));
        LibroModel objLibroModel = new LibroModel();

        String listaString = "COINCIDENCIAS \n";

        Libro objLibro = objLibroModel.getLibroById(id);
        listaString = objLibro.toString();

        JOptionPane.showMessageDialog(null, listaString);

    }

    public static void getByName(){
        String name = JOptionPane.showInputDialog("Insert name ");
        LibroModel objModel = new LibroModel();

        String listaString = "COINCIDENCIAS \n";
        for (Libro iterador: objModel.findByName(name)){
            listaString += iterador.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listaString);

    }

    public static void editarLibro(){
        LibroModel objLibroModel = new LibroModel();

        Libro objLibro = new Libro();


        int id =  Integer.parseInt(JOptionPane.showInputDialog( findAllString()  + "\n Ingrese el id del libro que desea editar"));


        //Pedimos los datos al usuario
        String sql = "UPDATE libro SET titulo = ?, año_de_publicación = ?, precio = ?, id_autor = ? WHERE (id = ?);";


        String titulo = JOptionPane.showInputDialog("Ingrese el nuevo nombre del libro");
        int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicacion del libro"));
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrse el nuevo precio del libro"));
        int idAutor = Integer.parseInt( JOptionPane.showInputDialog("Ingrse el id del autor"));



        objLibro.setId(id);
        objLibro.setTitulo(titulo);
        objLibro.setAño_publicacion(año);
        objLibro.setPrecio(precio);
        objLibro.setId_autor(idAutor);


        objLibroModel.update(objLibro);

    }


    public static void eliminarLibro(){

        LibroModel objLibroModel = new LibroModel();
        Libro objLibro  = new Libro();

        int id =  Integer.parseInt(JOptionPane.showInputDialog( findAllString() + "\n Ingrese el id del libro que desea eliminar"));


        objLibro.setId(id);
        objLibroModel.delete(objLibro);

    }



    public static void librosDeAutor(){
        AutorController objAutorController = new AutorController();

        LibroModel objLibroModel = new LibroModel();

        String listaString = "COINCIDENCIAS \n";

        int id =  Integer.parseInt(JOptionPane.showInputDialog(objAutorController.findAllString() +  "\n Ingrese el id del autor del que desea ver sus libros"));

        for (Libro iterador: objLibroModel.findByAutor(id)){
            listaString += iterador.toString() + "\n";
        }


        JOptionPane.showMessageDialog(null, listaString );

    }








}
