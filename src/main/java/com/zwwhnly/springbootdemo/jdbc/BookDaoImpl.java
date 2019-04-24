package com.zwwhnly.springbootdemo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Book book) {
        return jdbcTemplate.update("INSERT INTO book_list values (NULL, ?, ?, ?);",
                book.getBookName(), book.getBookAuthor(), book.getPurchaseDate());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE book_list SET book_name=?,book_author=?,purchase_date=? WHERE book_id = ?;",
                new Object[]{book.getBookName(), book.getBookAuthor(), book.getPurchaseDate(), book.getBookId()});
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM book_list where book_id = ?", id);
    }

    @Override
    public Book findBook(Integer id) {
        List<Book> list = jdbcTemplate.query("SELECT * FROM book_list where book_id = ?", new Object[]{id}, new BeanPropertyRowMapper<Book>(Book.class));
        if (null != list && list.size() > 0) {
            Book book = list.get(0);
            return book;
        } else {
            return null;
        }
    }

    @Override
    public List<Book> findBookList() {
        List<Book> list = jdbcTemplate.query("SELECT * FROM book_list", new Object[]{}, new BeanPropertyRowMapper<Book>(Book.class));
        return list;
    }
}
