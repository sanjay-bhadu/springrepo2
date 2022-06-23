package com.example.springtutorial.Controller;

import com.example.springtutorial.Model.Book;
import com.example.springtutorial.Model.Issue;
import com.example.springtutorial.Resource.BookRepo;
import com.example.springtutorial.Resource.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    IssueRepo issueRepo;

    @GetMapping("/start")
    public String initialBooks()
    {
       Book book=new Book();
       book.setBookName("Ramayana");
       book.setBookAuthor("Valmiki");
       book.setId(1);
       bookRepo.save(book);
        Book book2=new Book();
        book2.setBookName("The Final Dance");
        book2.setBookAuthor("Micheal Jordan");
        book2.setId(2);
       bookRepo.save(book2);
       return "Done...Started";
    }

    @GetMapping("/book")
    public List<Book> books()
    {
        return bookRepo.findAll();
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book)
    {
        bookRepo.save(book);
        return book;
    }
    @GetMapping("/issue")
    public List<Issue> issues()
    {
        return issueRepo.findAll();
    }

    @PostMapping("/issue/{id}")
    public Issue issueBook(@PathVariable String id,@RequestParam String name)
    {
        Book book =new Book();
                book=bookRepo.findById(Integer.parseInt(id));
        Issue issue=new Issue();
        issue.setBook(book);
        issue.setPersonName(name);
        issueRepo.save(issue);
        return issue;
    }

}
