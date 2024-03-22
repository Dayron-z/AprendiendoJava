package controller;

import entity.Autor;
import model.AutorModel;

import javax.swing.*;

//Repasar controller
// Por qué debemos instanciar cada clase en controller, analizar

//Ver en detalle a agregar


public class AutorController {
    public void findAll(){
        AutorModel objModel = new AutorModel();
        //Inicializar string siempre que queramos mostrar de manera mas organizada
        String listAutors  = "️📝 AUTHOR LIST \n";

        //Ponemos tipo de dato object porque con eso estamos trabajando
        for (Object autor: objModel.findAll()){
            Autor objAutor = (Autor) autor;

            listAutors += objAutor.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,  listAutors);
    }


    public static String findAllString(){
        AutorModel objModel = new AutorModel();
        //Inicializar string siempre que queramos mostrar de manera mas organizada
        String listAutors  = "️📝 Lista de autores \n";

        //Ponemos tipo de dato object porque con eso estamos trabajando
        for (Object autor: objModel.findAll()){
            Autor objAutor = (Autor) autor;

            listAutors += objAutor.toString() + "\n";
        }

        return listAutors;
    }


    public static void insert() {
        //Usamos el modelo
        AutorModel objModel = new AutorModel();

        //Pedimos los datos al usuario
        String nombre = JOptionPane.showInputDialog("Inserta el nombre");
        String nacionalidad = JOptionPane.showInputDialog("Inserta la nacionalidad");

        //Creamos una instacia de coder
        Autor objAutor = new Autor();
        objAutor.setNombre(nombre);
        objAutor.setNacionalidad(nacionalidad);


        //Llamamos al método de inserción guardamos el objeto que retorna en coder previamente instanciado, debemos castearlo.
        objAutor = (Autor) objModel.insert(objAutor);

        JOptionPane.showMessageDialog(null, objAutor.toString());
    }

    public static void GetAutorId(){
        int id =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del autor que desea buscar"));
        AutorModel objAutorModel = new AutorModel();

        String listaString = "COINCIDENCIAS \n";

        Autor objAutor = objAutorModel.getAuthorById(id);
        listaString = objAutor.toString();

        JOptionPane.showMessageDialog(null, listaString);
    }

    public static void editarAutor(){
        AutorModel objAutorModel = new AutorModel();

        Autor objAutor = new Autor();


        int id =  Integer.parseInt(JOptionPane.showInputDialog( findAllString()  + "\n Ingrese el id del autor que desea eliminar"));
        //Pedimos los datos al usuario
        String nombre = JOptionPane.showInputDialog("Inserta el nombre");
        String nacionalidad = JOptionPane.showInputDialog("Inserta la nacionalidad");



        objAutor.setNacionalidad(nacionalidad);
        objAutor.setId(id);
        objAutor.setNombre(nombre);

        objAutorModel.update(objAutor);

    }

    public static void eliminarAutor(){
        AutorModel objAutorModel = new AutorModel();
        Autor objAutor = new Autor();

        int id =  Integer.parseInt(JOptionPane.showInputDialog( findAllString()  + "\n Ingrese el id del autor que desea eliminar"));


        objAutor.setId(id);
        objAutorModel.delete(objAutor);

    }



}
