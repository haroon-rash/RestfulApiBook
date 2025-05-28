package org.example.resfulapi.restfulapibooks.Services;

import org.example.resfulapi.restfulapibooks.DAO.BooksRepository;
import org.example.resfulapi.restfulapibooks.Entities.Authors;
import org.example.resfulapi.restfulapibooks.Entities.Books;
import org.example.resfulapi.restfulapibooks.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BookServices {


    private final BooksRepository bRepository;

    public BookServices(BooksRepository bRepository) {
        this.bRepository = bRepository;
    }

    public List<Books> getAllBooks() {

        List<Books> books = new ArrayList<>();
        bRepository.findAll().forEach(books::add);

        return books;
    }

    public Books getBookById(Long id) {
        Books b = null;
        try {


            Optional<Books> bt = bRepository.findById(id);
            b = bt.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;

    }

    public List<Books> searchBooks(String name, Authors author) {
        try {

            if (name != null) {
                return bRepository.findByTitle(name);
            }
            if (author != null) {
                return bRepository.findByAuthor(author);
            }


        } catch (Exception e) {
            System.out.println("Error");
        }
        return new ArrayList<>();
    }

    // Service
    public void deleteBooks(Long id) {
        Books book = bRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Book Not Found with id: " + id));
        bRepository.delete(book);
    }


    public Books create(Books book) {

        return bRepository.save(book);


    }
}
