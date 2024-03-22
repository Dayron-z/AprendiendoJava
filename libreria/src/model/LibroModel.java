package model;


import database.CRUD;
import database.ConfigDB;
import entity.Autor;
import entity.Libro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibroModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        Libro objLibro = (Libro) obj;

        //Encendemos la conexión
        Connection objConecction = ConfigDB.openConnection();

        try {

            String sql = " INSERT INTO libro (precio, titulo, año_de_publicación) VALUES (?,?, ?);";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setDouble(1, objLibro.getPrecio());
            objPrepare.setString(2, objLibro.getTitulo());
            objPrepare.setInt(3, objLibro.getAño_publicacion());
            /*-------*/
            /*Ejecutamos*/
            objPrepare.execute();

            //Siempre que necesitemos hacer un while para cononcer si hay datos se usa ResulSet

            //Obtenemos las llaves generadas
            ResultSet objRest = objPrepare.getGeneratedKeys();
            //Acá obtenemos el id, pero como tal
            while (objRest.next()) {
                // Obtener el valor del atributo "id" por su nombre
                int getId = objRest.getInt(1);
                int  getAutorId  = objRest.getInt(5);
                //Linea señalada en rojo por si hay problemas en algun momento, cambiar por 1
                // Asignar el valor del atributo "id" al objeto "objAutor"
                objLibro.setId(getId);
                objLibro.setId_autor(getAutorId);
            }


        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectarse con la base de datos" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objLibro;
    }

    @Override
    public List<Object> findAll() {
        return null;
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
