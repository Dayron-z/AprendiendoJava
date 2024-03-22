import controller.AutorController;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String option = "";

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
                    2 - Buscar autor por id 
                    3 - Actualizar autor por id
                    4 - Eliminar autor por id
                    5 - Salir
                    """);

                        switch (autorOption){
                            case "1":
                                AutorController.insert();
                                break;
                            case "2":
                                AutorController.GetAutorId();
                                break;
                            case "3":
                                AutorController.editarAutor();
                                break;
                            case "4":
                                AutorController.eliminarAutor();
                                break;
                        }
                    }while (!option.equals(5));

                    break;
            }


        }while (!option.equals("3"));
    }
}