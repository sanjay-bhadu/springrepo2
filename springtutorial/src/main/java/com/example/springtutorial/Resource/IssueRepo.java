package com.example.springtutorial.Resource;

import com.example.springtutorial.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IssueRepo extends JpaRepository<Issue,String> {
    List<Issue> findAll();
}
