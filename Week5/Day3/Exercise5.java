// Exercise 5: Configuring Spring IoC Container

package com.library;

class BookRepository {
    public void displayBook() {
        System.out.println("Book Details");
    }
}

class BookService {

    private BookRepository repository;

    public void setBookRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void showBook() {
        repository.displayBook();
    }
}

public class Exercise5 {

    public static void main(String[] args) {
        System.out.println("Load applicationContext.xml");
        System.out.println("BookService bean created using XML configuration.");
    }
}

/*
applicationContext.xml

<bean id="bookRepository" class="com.library.BookRepository"/>

<bean id="bookService" class="com.library.BookService">
    <property name="bookRepository" ref="bookRepository"/>
</bean>
*/