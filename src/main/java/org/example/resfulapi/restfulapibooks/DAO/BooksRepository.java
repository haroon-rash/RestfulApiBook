package org.example.resfulapi.restfulapibooks.DAO;

import org.example.resfulapi.restfulapibooks.DAO.CustomRepository.CustomRepository;
import org.example.resfulapi.restfulapibooks.Entities.Authors;
import org.example.resfulapi.restfulapibooks.Entities.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long> , CustomRepository {




    List<Books> findByTitle(String title);

    List<Books> findByAuthor(Authors author);

   // Books findByid(Long id);


    //All Custom and Build In Methods

}
