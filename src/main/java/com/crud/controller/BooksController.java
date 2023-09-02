package com.crud.controller;

import com.crud.model.Book;
import com.crud.model.BookPayload;
import com.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(@Qualifier("bookService")BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add", consumes = "application/json;charset=utf-8")
    public @ResponseBody Book saveBooks(@RequestBody BookPayload bookPayload){
        Book book = new Book();
        book.setBookName(bookPayload.getBookName());
        book.setAuthor(bookPayload.getAuthor());
        book.setPrice(bookPayload.getPrice());
        book = bookService.saveBook(book);
        return book;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addMultiple", consumes = "application/json; charset=utf-8")
    public @ResponseBody List<Book> saveListOfBooks(@RequestBody List<Book> books){
        return bookService.saveListOfBooks(books);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllBooks", produces = "application/json; charset=utf-8")
    public @ResponseBody List<Book> findAllBooks(){
        return bookService.getBooks();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getBookById/{id}", produces = "application/json; charset=utf-8")
    public @ResponseBody Book findBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getBookByName/{bookName}", produces = "application/json; charset=utf-8")
    public @ResponseBody Book findBookByName(@PathVariable("bookName") String bookName){
        return bookService.getBookByName(bookName);
    }

    @RequestMapping(method = RequestMethod.PUT, path="/updateBook")
    public @ResponseBody Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteBook/{id}")
    public @ResponseBody String deleteBookById(@PathVariable("id") int id){
        return bookService.deleteBook(id);
    }
}

