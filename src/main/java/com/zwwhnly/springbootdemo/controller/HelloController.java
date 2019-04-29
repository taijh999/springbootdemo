package com.zwwhnly.springbootdemo.controller;

import com.zwwhnly.springbootdemo.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }

    @RequestMapping(value = "/getBookList", method = RequestMethod.GET)
    public List<Book> getBookList() {
        List<Book> books = new ArrayList<>();
        try {
            Book book1 = new Book(1, "平凡的世界", "路遥", "2010-01-01");
            Book book2 = new Book(2, "人生", "路遥", "2011-01-01");

            books.add(book1);
            books.add(book2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return books;
    }

    @RequestMapping(value = "/getBook/{bookId:\\d+}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Integer bookId) {
        Book book = null;
        List<Book> books = new ArrayList<>();
        try {
            Book book1 = new Book(1, "平凡的世界", "路遥", "2010-01-01");
            Book book2 = new Book(2, "人生", "路遥", "2011-01-01");

            books.add(book1);
            books.add(book2);

            book = books.get(bookId - 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return book;
    }
}
