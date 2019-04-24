package com.zwwhnly.springbootdemo.jdbc;

import java.util.List;

public interface BookService {
    int add(Book book);

    int update(Book book);

    int delete(Integer id);

    Book findBook(Integer id);

    List<Book> findBookList();
}
