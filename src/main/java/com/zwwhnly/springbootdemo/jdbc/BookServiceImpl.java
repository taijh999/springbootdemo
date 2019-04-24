package com.zwwhnly.springbootdemo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public int add(Book book) {
        return this.bookDao.add(book);
    }

    @Override
    public int update(Book book) {
        return this.bookDao.update(book);
    }

    @Override
    public int delete(Integer id) {
        return this.bookDao.delete(id);
    }

    @Override
    public Book findBook(Integer id) {
        return this.bookDao.findBook(id);
    }

    @Override
    public List<Book> findBookList() {
        return this.bookDao.findBookList();
    }
}
