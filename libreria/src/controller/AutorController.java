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

}
