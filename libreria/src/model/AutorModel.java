package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AutorModel implements CRUD {

    @Override
    // Inferimos desde la crud que para nosotros insertar requerimos obtener como parametro un object el, cual será proporcionado por el autorController
    public Object insert(Object obj) {
        //A esto le corresponde que le llegue un autor, hacer lógica insert esperando que los datos lleguen correctamente
        Autor objAutor = (Autor) obj;

        //Encendemos la conexión
        Connection objConecction = ConfigDB.openConnection();

        //Desde la conexión _todo puede fallar

        try {
            //Preparamos el sql
            String sql = " INSERT INTO autor (nombre, nacionalidad) VALUES (?,?);";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            /*-------*/
            /*Usamos el objAutor para acceder a sus atributos, por eso que lo creamos como tipo author*/
            objPrepare.setString(1, objAutor.getNombre());
            objPrepare.setString(2, objAutor.getNacionalidad());
            /*-------*/
            /*Ejecutamos*/
            objPrepare.execute();

            //Siempre que necesitemos hacer un while para cononcer si hay datos se usa ResulSet

            //Obtenemos las llaves generadas
            ResultSet objRest = objPrepare.getGeneratedKeys();
            //Acá obtenemos el id, pero como tal
            while (objRest.next()) {
                // Obtener el valor del atributo "id" por su nombre
                int GetId = objRest.getInt(1);
                //Linea señalada en rojo por si hay problemas en algun momento, cambiar por 1
                // Asignar el valor del atributo "id" al objeto "objAutor"
                objAutor.setId(GetId);
            }


        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectarse con la base de datos" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objAutor;
    }

    @Override
    public List<Object> findAll() {
        //Recordemos que List<Object> nos sirve para almacenar elementos de diferentes tipos en una sola estructura de datos.
        List<Object> listaAutores = new ArrayList<>();

        //Encendemos la conexion
        Connection objConnection = ConfigDB.openConnection();

        try {
            //Preparamos el sql
            String sql = "SELECT * FROM autor;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //Esto no es necesario proporcionarle mas datos del lenguaje sql, por ende procedemos ejecutar esperando un retorno(ResulSet) para hacer un while.
            ResultSet objRest = objPrepared.executeQuery();


/*            Mientras objRest tenga algo:
            (haz algo)*/
            while (objRest.next()) {
                //Acá se refleja la necesidad de un constructor vacío, nos sirve para poder proporcionar los datos después
                Autor objAutor = new Autor();

                objAutor.setId(objRest.getInt("id"));
                objAutor.setNombre(objRest.getString("nombre"));
                objAutor.setNacionalidad(objRest.getString("nacionalidad"));

                listaAutores.add(objAutor);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectarse con la base de datos" + e.getMessage());
        }


        //Cerramos la conexión

        ConfigDB.closeConnection();
        return listaAutores;
    }

    @Override
    public boolean update(Object obj) {

        Autor objAutor = (Autor) obj;

        Connection objConnection = ConfigDB.openConnection();

        //Variable de estado
        boolean editar = false;

        try {
            String sql = "UPDATE autor SET nombre = ?, nacionalidad = ?  WHERE (id = ?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objAutor.getNombre());
            objPrepare.setString(2, objAutor.getNacionalidad());
            objPrepare.setInt(3, objAutor.getId());

            int totalFilasAfectadas =   objPrepare.executeUpdate();

            if (totalFilasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Se ha actualizado al autor exitosamente");
                 editar = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return editar;
    }

    @Override
    public boolean delete(Object obj) {







        return false;
    }


    public Autor getAuthorById(int autorId){
        Connection objConenection = ConfigDB.openConnection();
        Autor objAutor = new Autor();

        try {
            String sql = "SELECT * FROM autor WHERE autor.id = " + autorId + ";";
            PreparedStatement objPrepare= objConenection.prepareStatement(sql);

            ResultSet objRest = objPrepare.executeQuery();

            while (objRest.next()){

                objAutor.setId(objRest.getInt("id"));
                objAutor.setNombre(objRest.getString("nombre"));
                objAutor.setNacionalidad(objRest.getString("nacionalidad"));
            }


        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error" + error.getMessage());
        }



        return objAutor;
    }



}
