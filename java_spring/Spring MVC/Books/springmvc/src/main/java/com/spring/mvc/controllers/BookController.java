package com.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.spring.mvc.models.Book;
import com.spring.mvc.services.BookService;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;



@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping(value="/add/books", method=RequestMethod.POST)
    public String addBook(
        @Valid @ModelAttribute("book") Book book,
        BindingResult result,
        Model model) {

    if(result.hasErrors()) {
        model.addAttribute("books", bookService.allBooks());
        return "index";
    }

    bookService.createBook(book);
    return "redirect:/books";
    }

    @RequestMapping("/books")
    public String showAllBooks(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "index";
    }
    
    
    @RequestMapping("/books/{id}")
    public String showBook(HttpSession session,@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        session.setAttribute("id", id);
        session.setAttribute("title", book.getTitle());
        session.setAttribute("desc", book.getDescription());
        session.setAttribute("lang", book.getLanguage());
        session.setAttribute("numOfPages", book.getNumberOfPages());
        return "show";
    }

    @RequestMapping(value="delete/book/{id}", method=RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/book/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(
        @Valid @ModelAttribute("book") Book book,
        BindingResult result,
        Model model) {
        if(result.hasErrors()) {
        model.addAttribute("book", book);
        return "edit";
    }else{
        bookService.updateBook(book.getId(), book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
        return "redirect:/books";
    }
    }
    
    
}
