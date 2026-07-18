/*
==============================================================
Exercise 3: Implementing Logging with Spring AOP
==============================================================

Scenario:
The Library Management Application requires logging capabilities
to track the execution time of service methods.

Steps:
1. Add Spring AOP dependency in pom.xml.
2. Create LoggingAspect.
3. Enable AspectJ support.
4. Run the application and observe execution time logs.

--------------------------------------------------------------
1. pom.xml Dependency
--------------------------------------------------------------

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>

--------------------------------------------------------------
2. LoggingAspect.java
--------------------------------------------------------------
*/

package com.library;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
class LoggingAspect {

    @Around("execution(* com.library.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println(
            "Method : " + joinPoint.getSignature().getName() +
            " | Execution Time : " +
            (endTime - startTime) + " ms"
        );

        return result;
    }
}

/*
--------------------------------------------------------------
3. LibraryService.java
--------------------------------------------------------------
*/

@Service
class LibraryService {

    public void issueBook() {

        System.out.println("Book Issued Successfully.");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public void returnBook() {

        System.out.println("Book Returned Successfully.");

        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }
}

/*
--------------------------------------------------------------
4. applicationContext.xml
--------------------------------------------------------------

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

       xsi:schemaLocation="

http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd

http://www.springframework.org/schema/context
https://www.springframework.org/schema/context/spring-context.xsd

http://www.springframework.org/schema/aop
https://www.springframework.org/schema/aop/spring-aop.xsd">

    <context:component-scan base-package="com.library"/>

    <aop:aspectj-autoproxy/>

</beans>

--------------------------------------------------------------
5. LibraryManagementApplication.java
--------------------------------------------------------------
*/

package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.LibraryService;

public class LoggingWithSpringAOP {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        LibraryService service = context.getBean(LibraryService.class);

        service.issueBook();

        service.returnBook();

        context.close();
    }
}

/*
--------------------------------------------------------------
Expected Output
--------------------------------------------------------------

Book Issued Successfully.
Method : issueBook | Execution Time : 1001 ms

Book Returned Successfully.
Method : returnBook | Execution Time : 501 ms

==============================================================
*/