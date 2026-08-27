package com.spring.mvc.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.spring.mvc.models.Book;
import com.spring.mvc.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book b){
        return bookRepository.save(b);
    }

    public Book findBook(long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        } else{
            return null;
        }
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages){
        Book book = findBook(id);
        book.setTitle(title);
        book.setDescription(desc);
        book.setLanguage(lang);
        book.setNumberOfPages(numOfPages);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
