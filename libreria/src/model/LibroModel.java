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
import java.util.ArrayList;
import java.util.List;

public class LibroModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        Libro objLibro = (Libro) obj;

        //Encendemos la conexión
        Connection objConecction = ConfigDB.openConnection();

        try {

            String sql = " INSERT INTO libro (precio, titulo, año_de_publicación, id_autor) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setDouble(1, objLibro.getPrecio());
            objPrepare.setString(2, objLibro.getTitulo());
            objPrepare.setInt(3, objLibro.getAño_publicacion());
            objPrepare.setInt(4, objLibro.getId_autor());
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
                objLibro.setId(getId);
            }


        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectarse con la base de datos" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objLibro;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listaLibros = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            //Preparamos el sql
            String sql = "SELECT * FROM libro;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            ResultSet objRest = objPrepared.executeQuery();


            while (objRest.next()) {
                //Acá se refleja la necesidad de un constructor vacío, nos sirve para poder proporcionar los datos después
                Libro objLibro = new Libro();

                objLibro.setId(objRest.getInt("id"));
                objLibro.setId_autor(objRest.getInt("id_autor"));
                objLibro.setPrecio(objRest.getDouble("precio"));
                objLibro.setTitulo(objRest.getString("titulo"));
                objLibro.setAño_publicacion(objRest.getInt("año_de_publicación"));


                listaLibros.add(objLibro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaLibros;
    }

    public Libro getLibroById(int libroId){
        Connection objConenection = ConfigDB.openConnection();
        Libro objLibro = new Libro();

        try {
            String sql = "SELECT * FROM libro WHERE libro.id = " + libroId + ";";
            PreparedStatement objPrepare= objConenection.prepareStatement(sql);

            ResultSet objRest = objPrepare.executeQuery();

            while (objRest.next()){

                objLibro.setId(objRest.getInt("id"));
                objLibro.setId_autor(objRest.getInt("id_autor"));
                objLibro.setPrecio(objRest.getDouble("precio"));
                objLibro.setTitulo(objRest.getString("titulo"));
                objLibro.setAño_publicacion(objRest.getInt("año_de_publicación"));
            }


        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error" + error.getMessage());
        }



        return objLibro;
    }

    @Override
    public boolean update(Object obj) {
        Libro objLibro = (Libro) obj;

        Connection objConnection = ConfigDB.openConnection();

        //Variable de estado
        boolean editar = false;

        try {
            String sql = "UPDATE libro SET titulo = ?, año_de_publicación = ?, precio = ?, id_autor = ? WHERE (id = ?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setInt(2, objLibro.getAño_publicacion());
            objPrepare.setDouble(3, objLibro.getPrecio());
            objPrepare.setInt(4, objLibro.getId_autor());
            objPrepare.setInt(5, objLibro.getId());


            int totalFilasAfectadas =   objPrepare.executeUpdate();

            if (totalFilasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Se ha actualizado libro exitosamente");
                editar = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return editar;

    }

    public List<Libro> findByName(String titulo) {
        //Creamos la lista
        List<Libro> listLibro = new ArrayList<>();
        //Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        try {
            //Sentencia SQL
            String sql = "SELECT * FROM libro WHERE titulo LIKE ?;";
            //Preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+titulo+"%");

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Libro objLibro = new Libro();

                objLibro.setId(objResult.getInt("id"));
                objLibro.setId_autor(objResult.getInt("id_autor"));
                objLibro.setPrecio(objResult.getDouble("precio"));
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setAño_publicacion(objResult.getInt("año_de_publicación"));

                listLibro.add(objLibro);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return listLibro;
    }

    @Override
    public boolean delete(Object obj) {
        Libro objLibro = (Libro) obj;

        Connection objConnection = ConfigDB.openConnection();

        //Variable de estado
        boolean eliminar = false;


        try {
            String sql = "DELETE FROM libro WHERE id = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            objPrepared.setInt(1, objLibro.getId());

            int totalFilasAfectadas =  objPrepared.executeUpdate();

            if (totalFilasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Se ha eliminado el libro exitosamente");
                eliminar = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return eliminar;
    }

    public List<Libro> findByAutor(int id) {
        //Creamos la lista
        List<Libro> listLibro = new ArrayList<>();
        //Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        try {
            //Sentencia SQL
            String sql = "SELECT * FROM libro where id_autor = ?;";
            //Preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Libro objLibro = new Libro();

                objLibro.setId(objResult.getInt("id"));
                objLibro.setId_autor(objResult.getInt("id_autor"));
                objLibro.setPrecio(objResult.getDouble("precio"));
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setAño_publicacion(objResult.getInt("año_de_publicación"));

                listLibro.add(objLibro);
            }




        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return listLibro;
    }


}
