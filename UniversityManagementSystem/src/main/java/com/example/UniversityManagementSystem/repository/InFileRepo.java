package com.example.UniversityManagementSystem.repository;

import java.util.List;

public class InFileRepo<T> implements BaseRepo<T>{

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T findById(String id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }
}
