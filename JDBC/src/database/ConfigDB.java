package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta clase se encarga de establecer y cerrar la conexion
public class ConfigDB {
    //Este atributo tendrá el estado de la conexión
    // Importante para hacer validacion sobre estado de la conexion
    public static Connection objConnection = null;

    public static Connection openConnection(){
       try {
           //Llamamos el driver
           //Se hace para hace la validadción
           Class.forName("com.mysql.cj.jdbc.Driver");


           String url = "jdbc:mysql://localhost:3306/ejerciciojdbc";
           String user = "root";
           String password = "Rlwl2023.";

           //Establecer la conexión
           objConnection = (Connection) DriverManager.getConnection(url,user,password);
           System.out.println("Me conecté perfectamente!!!!");



       }catch (ClassNotFoundException error){
           System.out.println("Error >> Driver no instalado" + error.getMessage() );
       }catch (SQLException error){
           System.out.println("ERROR >> error al conectar con la base de datos"+ error.getMessage());
       };
        return objConnection;
    };


    public static void closeConecction(){
        try {
            //Si objConecction no es igual a null entonces quiere decir que está abierta
            if (objConnection != null){
                objConnection.close();
                System.out.println("Me apagué");
            }

        }catch (SQLException error){
            System.out.println("No se pudo cerrar la base de datos " + error.getMessage());
        }
    }


}

