package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Atributo con el estado de la conexión para hacer validaciones y por temas de scope
    public static Connection objConnection = null;


    //Queremos que retorne una conexion como tal
    public static Connection openConnection(){
        try {
            //Llamamos al driver para hacer validacion
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos las varaibles de conexión
            String url = "jdbc:mysql://bcros6vxvzc9yujwkqwt-mysql.services.clever-cloud.com:3306/bcros6vxvzc9yujwkqwt";
            String user = "uqe9nu2xti9ky3a7";
            String password = "oHuiiXrgCX4HhvbkCUuE";

            //Establecemos conexión
            objConnection = (Connection) DriverManager.getConnection(url, user, password );

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

        return objConnection;
    }


    //Método para finalizar una conexión
    public static void closeConnection(){
        try{
            //Si hay una conexión activa entonces la cierra
            if ( objConnection != null){
                objConnection.close();
                System.out.println("Se finalizó la conexión con éxito");
            }
        }catch (SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
