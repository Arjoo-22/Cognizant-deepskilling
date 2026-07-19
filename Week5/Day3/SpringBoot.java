
------------------------------------------------
application.properties
------------------------------------------------

spring.datasource.url=jdbc:h2:mem:librarydb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

------------------------------------------------
Book.java
------------------------------------------------
package com.library.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String author;

    public Book(){}

    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id=id; }

    public String getTitle(){ return title; }

    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }
}

------------------------------------------------
BookRepository.java
------------------------------------------------
package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Book;

public interface BookRepository
extends JpaRepository<Book,Long>{

}

------------------------------------------------
BookController.java
------------------------------------------------
package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@RestController

@RequestMapping("/books")

public class BookController {

    @Autowired

    private BookRepository repository;

    @PostMapping

    public Book save(@RequestBody Book book){
        return repository.save(book);
    }

    @GetMapping

    public List<Book> getAll(){
        return repository.findAll();
    }

    @PutMapping("/{id}")

    public Book update(@PathVariable Long id,
                       @RequestBody Book book){

        book.setId(id);

        return repository.save(book);
    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable Long id){

        repository.deleteById(id);

    }

}

------------------------------------------------
LibraryManagementApplication.java
------------------------------------------------
package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class LibraryManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                LibraryManagementApplication.class,
                args);

    }

}
