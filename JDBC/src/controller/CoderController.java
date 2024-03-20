package controller;


import entity.Coder;
import model.CoderModel;

import javax.swing.*;

//Coder controller nos sirve para instanciar un objeto de la clase CoderModel, para iterar sobre la lista que nos devuelve el método "findAll", que en este caso es listCoders;
public class CoderController {


    //Creamos método que no retorna
    //Tipo static porque queremos acceder al método directamente desde la clase
    public static void getAll(){
        CoderModel objModel = new CoderModel();
        String listCoders = "🤷‍♂️ CODER LIST \n";

        //Objmodel.finfAll() = Es un metodo que nos retorna una lista,por ende, entiendáse como una lista comun y corriente dinámica
        for (Object iterador: objModel.findAll()){
            //Casteamos del object al Coder
            Coder objCoder = (Coder) iterador;
            listCoders+= objCoder.toString() + "\n";
            //Estamos agreagando el coder ya como tal en formato String, para que se pueda visualizar en el Joption.


        }

        JOptionPane.showMessageDialog(null,listCoders);
    }




}
