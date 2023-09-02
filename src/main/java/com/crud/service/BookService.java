package com.crud.service;

import com.crud.model.Book;
import com.crud.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//Defining business Logics

@Component
@Service("bookService")
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //Save 1 Book
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    //Save List of Books
    public List<Book> saveListOfBooks(List<Book> listOfBooks){
        return (List<Book>) bookRepository.saveAll(listOfBooks);
    }

    //Read List of Books
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    //Read Book by id
    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }

    //Read Book by name
    //findBookByName is a manually created method to get the Book by it name
    public Book getBookByName(String bookName){
        return bookRepository.findBookByBookName(bookName);
    }

    //Update Books
    public Book updateBook(Book book){
        Book existingBook = bookRepository.findById(book.getId()).orElse(book);
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook = bookRepository.save(existingBook);
        return existingBook;
    }

    //Delete Books
    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "Book Removed "+id;
    }

}