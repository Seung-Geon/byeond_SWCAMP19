package com.ohgiraffers.section01.autowired.subsection03.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        BookService bookService = (BookService) context.getBean("constructorService", BookService.class);    // 동일 타입이 여러개 있으면 이렇게 사용
//        System.out.println("bookService = " + bookService);

//        bookService.findAllBook().forEach(System.out::println);
//
//        System.out.println("1번 책: " + bookService.findBookBySequenceOf(1));
//        System.out.println("2번 책: " + bookService.findBookBySequenceOf(2));
//        System.out.println("3번 책: " + bookService.findBookBySequenceOf(3));
    }
}
