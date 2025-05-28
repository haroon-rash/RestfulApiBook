package org.example.resfulapi.restfulapibooks.BookController;


import org.example.resfulapi.restfulapibooks.Entities.Authors;
import org.example.resfulapi.restfulapibooks.RestfulApiBooksApplication;
import org.example.resfulapi.restfulapibooks.Services.BookServices;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.resfulapi.restfulapibooks.Entities.Books;


import java.util.List;


@RestController
public class BookController {

private final BookServices bookServices;

public BookController(BookServices bservice) {
    this.bookServices = bservice;
}
    // @RequestMapping(value = "/getbooks" ,method = RequestMethod.GET)
    @GetMapping("/getbooks")
    //this is alternative of @request mapping it GET show get method and Mapping
    public String getBooks()
    {

        return "This is a book RESTful API";
    }

    @GetMapping("/books")
    public ResponseEntity<?>getBook(){

    List<Books> b =bookServices.getAllBooks();
    if(b.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Books Found");
    }

        return ResponseEntity.ok(b);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchBook(@PathVariable Long id){



    Books book =bookServices.getBookById(id);
if(book==null)
    {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found at id :  "+id);

    }

        return ResponseEntity.ok(book);



    }


    @GetMapping("/search")
    public ResponseEntity<?> searchBook(@RequestParam(required = false) String title,@RequestParam(required = false) Authors author){

    List<Books> list=bookServices.searchBooks(title,author);
    if(list.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found");

    return ResponseEntity.ok("Book Found");

    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
    bookServices.deleteBooks(id);

    return ResponseEntity.ok("Book Deleted");
}


@PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody Books book){
    bookServices.create(book);

    return ResponseEntity.ok("Book Created");
}




}
