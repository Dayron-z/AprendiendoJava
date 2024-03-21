package controller;

import entity.Autor;
import model.AutorModel;

import javax.swing.*;
import java.util.ArrayList;

//Repasar controller
// Por qué debemos instanciar cada clase en controller, analizar

//Ver en detalle a agregar

public class AutorController {








    public void findAll(){
        // Instanciamos para poder acceder a sus métodos.
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

    public void insertAuthor(){
        // Instanciamos para poder acceder a sus métodos.
        AutorModel objModel = new AutorModel();


        //Pedimos los datos al usuario
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del autor");
        String nacionalidad =  JOptionPane.showInputDialog("Ingresas el nombre de la nacionalidad");

        //Creamos instancia de Autor, ya que es lo que requiere nuestro método, tengamos que cuando pide un object, justamente lo que necesita es que se le envíe un datos como tal, no importa cual sea.


        //Es evidente que si estamos requiriendo unos datos para la creación de un autor, lo hagamos justamene con quien recibe esos argumentos en su constructor

        //Lo hacemos desde su contructor vacio para poder setear los atributos del objeto y no desde el constructor como tal
        Autor objAutor = new Autor();



        objAutor.setNombre(nombre);
        objAutor.setNacionalidad(nacionalidad);

        //Tengamos en cuenta que lo que nos retorna el metodo es un object, hay que castearlo
        objAutor = (Autor) objModel.insert(objAutor) ;


    }









}
