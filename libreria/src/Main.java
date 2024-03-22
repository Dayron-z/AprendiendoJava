import controller.AutorController;
import controller.LibroController;

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
                    3 - Salir
                    """);
            switch (option){
                case "1":
                    String autorOption;

                    do {
                        autorOption = JOptionPane.showInputDialog("""
                                1 - Insertar autores
                                2 - Listar autores 
                                3 - Buscar autor por id 
                                4 - Actualizar autor por id
                                5 - Eliminar autor por id
                                6 - Salir
                                """);

                        switch (autorOption){
                            case "1":
                                AutorController.insert();
                                break;
                            case "2":
                                AutorController.findAll();
                                break;
                            case "3":
                                AutorController.GetAutorId();
                                break;
                            case "4":
                                AutorController.editarAutor();
                                break;
                            case "5":
                                AutorController.eliminarAutor();
                                break;
                        }
                    } while (!autorOption.equals("6")); // Salir del bucle cuando se selecciona la opción "6"

                    break;



                case "2":
                    String libroOption;

                    do {
                        libroOption = JOptionPane.showInputDialog("""
                                1 - Insertar libro
                                2 - Ver todos los libros disponibles
                                3 - Buscar libros por id.
                                4 - Buscar libros por nombres 
                                5 - Buscar libros por autor
                                6 - Editar libros por id.
                                7 - Eliminar libro.
                                8 - Salir.
                                """);

                        switch (libroOption){
                            case "1":
                                LibroController.insert();
                                break;
                            case "2":
                                LibroController.findAll();
                                break;
                            case "3":
                                LibroController.GetLibroId();
                                break;
                            case "4":
                                LibroController.getByName();
                                break;
                            case "5":
                                LibroController.librosDeAutor();
                                break;
                            case "6":
                                LibroController.editarLibro();
                                break;
                            case "7":
                                LibroController.eliminarLibro();
                                break;
                        }
                    } while (!libroOption.equals("8"));
                    break;
            }
        } while (!option.equals("3"));
    }
}
