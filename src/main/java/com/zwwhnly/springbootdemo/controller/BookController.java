package com.zwwhnly.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.zwwhnly.springbootdemo.jdbc.Book;
import com.zwwhnly.springbootdemo.jdbc.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/jdbc/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "getBookList", method = RequestMethod.GET)
    public Map<String, Object> getBookList() {
        List<Book> bookList = this.bookService.findBookList();
        Map<String, Object> param = new HashMap<>();
        param.put("total", bookList.size());
        param.put("rows", bookList);
        return param;
    }

    @RequestMapping(value = "/getBook/{bookId:\\d+}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Integer bookId) {
        Book book = this.bookService.findBook(bookId);
        if (book == null) {
            throw new RuntimeException("查询错误aaaaaaa");
        }
        return book;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
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

    @RequestMapping(value = "/update/{bookId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer bookId, @RequestBody JSONObject jsonObject) {
        Book book = this.bookService.findBook(bookId);
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

    @RequestMapping(value = "/delete/{bookId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer bookId) {
        try {
            this.bookService.delete(bookId);
        } catch (Exception e) {
            throw new RuntimeException("删除错误");
        }
    }
}
