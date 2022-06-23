package com.example.springtutorial.Controller;

import com.example.springtutorial.Model.Book;
import com.example.springtutorial.Model.Issue;
import com.example.springtutorial.Resource.BookRepo;
import com.example.springtutorial.Resource.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MyController {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    IssueRepo issueRepo;

    @GetMapping("/start")
    public String initialBooks() {
        Book book = new Book();
        book.setBookName("Ramayana");
        book.setBookAuthor("Valmiki");
        book.setId(1);
        book.setAvailable(true);
        bookRepo.save(book);
        Book book2 = new Book();
        book2.setBookName("The Final Dance");
        book2.setBookAuthor("Micheal Jordan");
        book2.setId(2);
        book2.setAvailable(true);
        bookRepo.save(book2);
        return "Done...Started";
    }

    @GetMapping("/book")
    public List<Book> books() {
        return bookRepo.findAll();
    }

    @GetMapping("/available")
    public List<Book> availableBook()
    {
        List<Book> list=bookRepo.findAll();
       list= list.stream()
                .filter(s-> s.isAvailable())
                .collect(Collectors.toList());
       return list;
    }


    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        bookRepo.save(book);
        return book;
    }

    @GetMapping("/issue")
    public List<Issue> issues() {
        return issueRepo.findAll();
    }

    @PostMapping("/issue")
    public Issue issueBook(@RequestParam String id, @RequestParam String name) {
        Book book = bookRepo.findById(Integer.parseInt(id));
        book.setAvailable(false);
        Issue issue = new Issue();
        issue.setId(book.getId());
        issue.setBook(book);
        issue.setPersonName(name);
        issueRepo.save(issue);
        return issue;
    }

    @GetMapping("/getbook")
    public Book getBook(@RequestParam String id)
    {
        Book book=bookRepo.findById(Integer.parseInt(id));
        return book;
    }

    @GetMapping("/getissue")
    public Book getIssue(@RequestParam String id)
    {
        Issue issue=issueRepo.findByBookId(Integer.parseInt(id));
        if(issue==null)
            return null;
        return issue.getBook();
    }
    @PostMapping("/return")
    public Book returnBook(@RequestParam String id)
    {
        Book book=bookRepo.findById(Integer.parseInt(id));
        if(book!=null)
            book.setAvailable(true);
        bookRepo.save(book);
        issueRepo.delete(issueRepo.findByBookId(Integer.parseInt(id)));
        return book;
    }
}
