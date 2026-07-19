
package com.library.repository;

public class BookRepository {

    public void displayBook() {
        System.out.println("Book Repository Method Called");
    }
}

----------------------------------------------------
BookService.java
----------------------------------------------------
package com.library.service;

import com.library.repository.BookRepository;*/

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor Injection Successful");
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter Injection Successful");
    }

    public void showBook() {
        bookRepository.displayBook();
    }
}

----------------------------------------------------
applicationContext.xml
----------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bookRepository"
          class="com.library.repository.BookRepository"/>

    <bean id="bookService"
          class="com.library.service.BookService">

        <!-- Constructor Injection -->
        <constructor-arg ref="bookRepository"/>

        <!-- Setter Injection -->
        <property name="bookRepository"
                  ref="bookRepository"/>

    </bean>

</beans>

----------------------------------------------------
package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service =
                context.getBean("bookService", BookService.class);

        service.showBook();
    }
}
