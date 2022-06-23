package com.example.springtutorial.Model;

import javax.persistence.*;


@Entity
public class Issue {
    @Id
   private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
   @JoinColumn(name = "book_id")
   private Book book;
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
