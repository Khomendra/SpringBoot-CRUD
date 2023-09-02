package com.crud.repo;

import com.crud.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookByBookName(String bookName);
}
