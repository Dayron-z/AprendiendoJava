package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {
    /*El coderModel tiene que hacer _todo lo  relacionado con la conexión con el sql*/


    /*Creamos el método con el que vamos a listar*/

    @Override
    public Object insert(Object obj) {
        return null;
    }

    //Nos retornará una lista con el tipo de dato object, es decir, lo usamos con el fin de que nos retorne multiples datos y parsearlos o castearlos a nuestra conveniencia
    public List<Object> findAll(){

        //Creamos la lista para guardar lo que nos devuelve la base de datos y lo que vamos a retornar
        List<Object> listCoders = new ArrayList<>();

        //Abrimos la conexión
        //Previamente creado
        Connection objConecction = ConfigDB.openConnection();

        //Desde que se abra la conexión, cualquier cosa puede suceder, entonces, posterior a la apertura, _todo debe ir dentro de un try, catch

        try {
            //Empezamos a ejecutar codigo SQL
            //Almacenamos petición en una variable tipo string para luego agregarla al PreparedStatement
            //El PreparedStatement recibe como parametro la peticíon sql, y es lo primero que debemos hacer ante cualquier petición

            String sql = "SELECT * FROM coder";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql);

            //Lo que debemos hacer ahora es ejecutar el query y obtener el resultado para almacenarlo en una variable con el tipo de dato ResultSet

            ResultSet objResult = objPrepare.executeQuery();

            //6 Mientras exista un resultado, queremos que cuando detecte una tabla en el query que le proporcionamos, recorra cada uno de lo elementos de la query

            /*"mientras haya datos en el ResultSet, avanza al siguiente registro y realiza las operaciones dentro del bucle"*/
            while (objResult.next()){
                // Creamos un nuevo coder, ya que aunque esté en base de datos, no hemos agregado los valores a java
                Coder objCoder = new Coder();

                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));


                listCoders.add(objCoder);

            }


        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectar con la base de datos" + error.getMessage());

        }

        //Cerrar conexión como buena práctica
        ConfigDB.closeConecction();


        return listCoders;



    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

}
