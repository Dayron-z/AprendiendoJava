import controller.AutorController;
import entity.Autor;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String option = "";

        //Instanciamos para acceder a sus metodos
        AutorController objAutor = new AutorController();


        do {
            option = JOptionPane.showInputDialog("""
                    1 - Gestion autores
                    2 - Gestion libros
                    """);
            switch (option){
                case "1":
                    String autorOption = "";

                    do {
                        autorOption = JOptionPane.showInputDialog("""
                    1 - Insertar autores
                    2 - Buscar autor por id (Por el momento lista)
                    3 - Actualizar autor por id
                    4 - Eliminar autor por id
                    5 - Salir
                    """);

                        switch (autorOption){
                            case "1":

                                break;
                            case "2":
                                objAutor.findAll();
                                break;
                        }
                    }while (!option.equals(5));

                    break;
            }


        }while (!option.equals("3"));
    }
}