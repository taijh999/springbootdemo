package com.zwwhnly.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.zwwhnly.springbootdemo.jdbc.Book;
import com.zwwhnly.springbootdemo.jdbc.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/data/jdbc/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getBookList(HttpServletRequest request) {
        List<Book> bookList = this.bookService.findBookList();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("total", bookList.size());
        param.put("rows", bookList);
        return param;
    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Integer userId, HttpServletRequest request) {
        Book author = this.bookService.findBook(userId);
        if (author == null) {
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody JSONObject jsonObject) {
        String bookName = jsonObject.getString("bookName");
        String bookAuthor = jsonObject.getString("bookAuthor");
        String purchaseDate = jsonObject.getString("purchaseDate");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Book book = new Book();
            book.setBookName(bookName);
            book.setBookAuthor(bookAuthor);
            book.setPurchaseDate(simpleDateFormat.parse(purchaseDate));
            this.bookService.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer userId, @RequestBody JSONObject jsonObject) {
        Book book = this.bookService.findBook(userId);
        String bookName = jsonObject.getString("bookName");
        String bookAuthor = jsonObject.getString("bookAuthor");
        String purchaseDate = jsonObject.getString("purchaseDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            book.setBookName(bookName);
            book.setBookAuthor(bookAuthor);
            book.setPurchaseDate(simpleDateFormat.parse(purchaseDate));
            this.bookService.update(book);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }
    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer userId) {
        try {
            this.bookService.delete(userId);
        } catch (Exception e) {
            throw new RuntimeException("删除错误");
        }
    }
}
