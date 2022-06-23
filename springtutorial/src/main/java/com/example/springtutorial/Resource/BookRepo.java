package com.example.springtutorial.Resource;

import com.example.springtutorial.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends CrudRepository<Book,Integer> {
@Override
List<Book> findAll();
Book findById(int i);
}
