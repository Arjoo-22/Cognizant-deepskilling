------------------------------------------------
BookService.java
--------------------------------------------------
package com.library.service;

public class BookService {

    public void issueBook() {
        System.out.println("Book Issued Successfully");
    }
}

--------------------------------------------------
LoggingAspect.java
--------------------------------------------------
package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void beforeMethod(JoinPoint jp) {
        System.out.println("Before Method : " + jp.getSignature().getName());
    }

    public void afterMethod(JoinPoint jp) {
        System.out.println("After Method : " + jp.getSignature().getName());
    }
}

--------------------------------------------------
applicationContext.xml
--------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:aop="http://www.springframework.org/schema/aop"

xsi:schemaLocation="
http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd

http://www.springframework.org/schema/aop
https://www.springframework.org/schema/aop/spring-aop.xsd">

<bean id="bookService"
class="com.library.service.BookService"/>

<bean id="loggingAspect"
class="com.library.aspect.LoggingAspect"/>

<aop:aspectj-autoproxy/>

<aop:config>

<aop:aspect ref="loggingAspect">

<aop:pointcut id="serviceMethods"
expression="execution(* com.library.service.*.*(..))"/>

<aop:before
pointcut-ref="serviceMethods"
method="beforeMethod"/>

<aop:after
pointcut-ref="serviceMethods"
method="afterMethod"/>

</aop:aspect>

</aop:config>

</beans>

--------------------------------------------------
LibraryManagementApplication.java
--------------------------------------------------
package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service =
                context.getBean(BookService.class);

        service.issueBook();
    }
}

