package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//=======================
// Repository Class
//=======================
@Repository
class BookRepository {

    public void displayBook() {
        System.out.println("Book Repository: Displaying Book Details...");
    }
}

//=======================
// Service Class
//=======================
@Service
class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void showBook() {
        bookRepository.displayBook();
    }
}

//=======================
// Main Class
//=======================
public class ConfBeans {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean(BookService.class);

        service.showBook();
    }
}

/*
=========================================================
applicationContext.xml
=========================================================

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Enable Component Scanning -->
    <context:component-scan base-package="com.library"/>

</beans>

=========================================================
Output
=========================================================

Book Repository: Displaying Book Details...

*/