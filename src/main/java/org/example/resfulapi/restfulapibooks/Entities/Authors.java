package org.example.resfulapi.restfulapibooks.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString

public class Authors {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String email;
    String phone;
    
public Authors(){
    super();
}
public Authors(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
}

}
