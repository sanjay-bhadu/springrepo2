package com.example.springtutorial.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Issue {
    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @Id
    private String personName;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "book=" + book +
                ", personName='" + personName + '\'' +
                '}';
    }
}
