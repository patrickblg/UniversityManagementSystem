package com.example.UniversityManagementSystem.repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BaseRepo<T> {

    T save(T t);
    T findById(String id);
    List<T>findAll();
    void delete(String id);

}
