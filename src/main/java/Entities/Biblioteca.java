package Entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Libro> libros;
    private Scanner scanner;

    public Biblioteca() {
        libros = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido a la Biblioteca");
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro por título");
        System.out.println("3. Buscar libro por autor");
        System.out.println("4. Mostrar todos los libros");
        System.out.println("5. Prestar libro");
        System.out.println("6. Devolver libro");
        System.out.println("7. Salir");
        System.out.print("Por favor, seleccione una opción: ");
    }

    public void agregarLibro() {
        System.out.println("Ingrese los detalles del libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int añoPublicacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        libros.add(new Libro(titulo, autor, ISBN, añoPublicacion));
        System.out.println("Libro agregado correctamente.");
    }

    public void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }

    public void buscarLibroPorAutor() {
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro de ese autor.");
        }
    }

    public void mostrarTodosLosLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("Listado de libros disponibles:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void prestarLibro() {
        System.out.print("Ingrese el ISBN del libro a prestar: ");
        String ISBN = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getISBN().equalsIgnoreCase(ISBN)) {
                if (!libro.isPrestado()) {
                    libro.setPrestado(true);
                    System.out.println("Libro prestado correctamente.");
                } else {
                    System.out.println("El libro ya está prestado.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    public void devolverLibro() {
        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String ISBN = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getISBN().equalsIgnoreCase(ISBN)) {
                if (libro.isPrestado()) {
                    libro.setPrestado(false);
                    System.out.println("Libro devuelto correctamente.");
                } else {
                    System.out.println("El libro no estaba prestado.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        buscarLibroPorTitulo();
                        break;
                    case 3:
                        buscarLibroPorAutor();
                        break;
                    case 4:
                        mostrarTodosLosLibros();
                        break;
                    case 5:
                        prestarLibro();
                        break;
                    case 6:
                        devolverLibro();
                        break;
                    case 7:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Descartar la entrada no válida
                opcion = 0; // Reiniciar la opción
            }
        } while (opcion != 7);
    }
}
