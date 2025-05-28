package org.example.resfulapi.restfulapibooks.Entities;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Books {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;

    public double price;
    public int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Author_id")
 private Authors author;
    public Books(){
        super();
    }
    public Books(int id, String title, Authors author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
