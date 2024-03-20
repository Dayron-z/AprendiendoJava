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

        //Abrimos conexión
        Connection objConecction = ConfigDB.openConnection();


        //2 Convertir el obj que llegó a Coder
        Coder objCoder = (Coder) obj;



        //El obj que nos llega lo debemos convertir a coder, ya que necesitamos acceder a sus atributos, para poder hacer la inyección de datos




        try {
            //Tengamos en cuenta que el funcionamiento de esto es muy sencillo, cuando nosotros ejecutamos codigo sql, se hace lo que le pasamos al String SQl, y luego le pasamos los valores de forma dinamica.


            String sql = "INSERT INTO coder (name,age,clan) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Asignamos los valores desde el objPrepare
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2, objCoder.getAge());
            objPrepare.setString(3, objCoder.getClan());
            //Hasta este punto es como si hubieramos creado la parte mysql que inserta datos dentro de una tabla.

            //Ahora debemos proceder a ejecutar
            //Execute lo debemos tomar simplemenete como que hace la ejecución y listo, en este caso no necesitamos guardar lo que nos proporcione, solo que ejecute
            objPrepare.execute();

            //7. Obtener el resultado con los id (LLaves generadas)
            //Guardamos
            ResultSet objRest = objPrepare.getGeneratedKeys();

            //8. Iterar mientras haya un registro
            // Esta validacion se suele hacer cuando necesitamos recuperar datos de la base de datos
                //En este caso necesitamos recuperar el id auto incremental que nos proporciona mySQL.
            while (objRest.next()){
                // Nota kevin: Podemos obtener el valor tambien con indices
                //Lo haremos con nombre
                objCoder.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Se agregaron datos satisfactoriamente");





        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }



        //Error dejado a propósito
        //Estudiar el retorno
        //La respuesta debe ser analizada junto con el controller.
        return objCoder;
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
        //Convertimos el objeto a la entidad
        Coder objCoder = (Coder) obj;


        //Abrimos conexión y posterior creamos el try - Catch
        // La connection ya tiene su propio try catch
        Connection objConnection = ConfigDB.openConnection();


        //Creamos una variable de estado
        boolean isDeleted = false;

        try {
            //Sql
            String sql = "DELETE FROM coder WHERE id = ?;";
            //El preparedStatement se hace simepre con la conexion
            PreparedStatement objPreprared = objConnection.prepareStatement(sql);

            //Dar al valor al signo de interrogación
            objPreprared.setInt(1, objCoder.getId());

            //Ejecutamos el query
            //Devuelve el numero de registros afectados.
            int  totalAffectedRows = objPreprared.executeUpdate();



            //Si se afectaron mas de 0 lineas quiere decir que si hubo algun cambio (En este caso eliminar);
            if (totalAffectedRows >0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "La actualización fue satisfactoria");

            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Error" + error.getMessage());
        }

        ConfigDB.closeConecction();
        return isDeleted;
    }



    public Coder findById(int id){
        //Abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();

        Coder objCoder = null;

        try {
            //3. Sentencia SQL
            String sql = "SELECT * FROM coder WHERE id = ?;";

            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //Darle el valor al parametro del query
            objPrepared.setInt(1, id);



            //Resultado de una ejecucion
            ResultSet objResult =  objPrepared.executeQuery();

            if (objResult.next()){

                //Traemos el coder de la base de datos del id que la pasamos
                objCoder = new Coder();
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setId(objResult.getInt("id"));
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "  + e.getMessage());
        }

        return objCoder;
    }


    public Coder findByName(String name){
        //Instanciamos Coder
        Coder objCoder = null;
        //Conexión
        Connection objConnection = ConfigDB.openConnection();


        try {
            String sql = "SELECT * FROM coder where name like ?";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //NO OLVIDAR, SI CREAMOS UNA SENTENCIA SQL, OBVIAMENTE LE TENEMOS QUE DAR VALOR SI EXISTE ALGUN SIGNO DE INTERROGACION
            objPrepared.setString(1, name);



            //Esto va dentro del if

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Error:" + error.getMessage());
        };

        return null;
    }
}
