package com.alura.literatura.principal;

import com.alura.literatura.models.*;
import com.alura.literatura.repository.AuthorRepository;
import com.alura.literatura.repository.BookRepository;
import com.alura.literatura.service.ConexionAPI;
import com.alura.literatura.service.ConvierteDatos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


@Component
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private Scanner tecladoNumero = new Scanner(System.in);
    private ConexionAPI conexionAPI = new ConexionAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos convertidor = new ConvierteDatos();
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Principal(BookRepository book, AuthorRepository author){
        this.bookRepository = book;
        this.authorRepository = author;
    }

    public void mostarMenu(){
        String menu = """
                    *************************************
                            Welcome to Books-Searh\s
                    Seleccione una opcion:\s
                    1. Buscar libro
                    2. Mostar libros registrados
                    3. Mostar Autores registardos
                    4. Listar Autores vivos en determinado ano
                    5. Mostar libros por idiomas
                    *************************************
                    """;
        boolean continuar = true;
        while (continuar){
            System.out.println(menu);
            try {
                var opcion = Integer.parseInt(tecladoNumero.next());
                switch (opcion){
                    case 1:
                        searhBook();break;
                    case 2:
                        mostarLibros();break;
                    case 3:
                        mostarAuthors();break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 0 :
                        continuar = false;
                        break;
                    default:
                        System.out.println("Seleccione una opcion del menu!");
                }
            }catch (NumberFormatException e){
                System.out.println("Solo se admiten numeros!, Error: "+ e.getMessage());
            }
        }
        }
    @Transactional

    public Data getdata(){
        System.out.println("Titulo que quieres buscar: ");
        var consulta = teclado.next();
        var json = conexionAPI.obtenerDatos(URL_BASE+consulta.replace(" ","+"));
        Data data = convertidor.obtenerDatos(json,Data.class);
        return data;
    }
    public void searhBook(){
        Data datos = getdata();
        //verifcar si no se encontro nada en la api
        if (datos.results().isEmpty()) {
            System.out.println("No se encontró el libro");
            return;
        }
        DataBook dataBook = datos.results().get(0);
        // Verificar si el libro ya existe en la base de datos
        Optional<Book> existingBook = bookRepository.findByTitle(dataBook.title());
        if (existingBook.isPresent()) {
            System.out.println("El libro ya existe en la base de datos");
            return;
        }
        //save data author
        DataAuthor dataAuthor = dataBook.author().get(0);
        Author author = new Author(dataAuthor);
        author = authorRepository.save(author);
        //save book
        Book book = new Book(dataBook, author);
        book = bookRepository.save(book);
        System.out.println("Libro guardado: [" + book.getTitle()+"]");
    }

    //mostrar libros de BD
    public void mostarLibros() {
        List<Book> books = bookRepository.findAll();
        System.out.println("----LIBROS GUARDADOS----");
        String bookString = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(bookString);
    }

    public void  mostarAuthors(){
        List<Author> authors = authorRepository.findAll();
        System.out.println("----AUTORES GUARDADOS----");
        String formattedAuthors = authors.stream()
                .map(author -> String.format(
                        "Nombre      = '%s'\n" +
                                "Birth_year  = %s\n" +
                                "Death_year  = %s\n" +
                                "Books       =[%s]\n",
                        author.getName(),
                        author.getBirth_year(),
                        author.getDeath_year(),
                        author.getBooks().stream()
                                .map(Book::getTitle)
                                .collect(Collectors.joining(", "))
                ))
                .collect(Collectors.joining("\n"));

        System.out.println(formattedAuthors);
    }




    }


