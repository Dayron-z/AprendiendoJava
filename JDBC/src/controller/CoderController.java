package controller;


import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.security.interfaces.DSAPublicKey;

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

    //Haremos sobreescritura, normalmente se escribe con dos nombres iguales, pero como es static, toca nombre distinto
    public static String getAllString(){
        CoderModel objModel = new CoderModel();
        String listCoders = "🤷‍♂️ CODER LIST \n";

        //Objmodel.finfAll() = Es un metodo que nos retorna una lista,por ende, entiendáse como una lista comun y corriente dinámica
        for (Object iterador: objModel.findAll()){
            //Casteamos del object al Coder
            Coder objCoder = (Coder) iterador;
            listCoders+= objCoder.toString() + "\n";
            //Estamos agreagando el coder ya como tal en formato String, para que se pueda visualizar en el Joption.
        }

        return listCoders;
    }


    public static void create(){
        //Usamos el modelo
        CoderModel objCoderModel = new CoderModel();

        //Pedimos los datos al usuario
        String name = JOptionPane.showInputDialog("Insert name");
        String clan = JOptionPane.showInputDialog("Insert clan");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age"));

        //Creamos una instancia de coder
        Coder objCoder = new Coder();
        objCoder.setClan(clan);
        objCoder.setAge(age);
        objCoder.setName(name);

        //Llamamos al método de insercción y guardamos el objeto que retorna en coder previamente instanciado, debemos castearlo.
        objCoder = (Coder) objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());
    }



    public static void delete(){
        //Para acceder a sus métodos (Linea para la que se usa mas adelante  Coder objCoder = objCoderModel.findById(idDelete);)
        CoderModel objCoderModel = new CoderModel();




        String listCoder = getAllString();


        //Acá le pedí el id para que busque el coder con el metodo findById
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoder + "\n Choose an option"));


        //Acá es donde le damos el parametro al metodo findById
        Coder objCoder = objCoderModel.findById(idDelete);
        /*------------------------------*/
        /*------------------------------*/
        /*------------------------------*/

        int confirm = 1;


        if (objCoder == null){
            JOptionPane.showMessageDialog(null, "Coder not found");
        }else{
            confirm = JOptionPane.showConfirmDialog(null, "Estàs seguro que desea eliminar el code" + objCoder.toString());


            if (confirm == 0){
                System.out.println("Hasta aqui llegué");
                objCoderModel.delete(objCoder);
            }
        }



    }




}
