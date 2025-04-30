package org.example.resfulapi.restfulapibooks.BookController;


import org.example.resfulapi.restfulapibooks.RestfulApiBooksApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.example.resfulapi.restfulapibooks.Entities.Books;


@RestController
public class BookController {


   // @RequestMapping(value = "/getbooks" ,method = RequestMethod.GET)
    @GetMapping("/getbooks")
    //this is alternative of @request mapping it GET show get method and Mapping
    public String getBooks()
    {

        return "This is a book RESTful API";
    }

    @GetMapping("/books")
    public Books getBook(){

 Books book = new Books(1,"Book Title","Author");



return book;
    }

}
