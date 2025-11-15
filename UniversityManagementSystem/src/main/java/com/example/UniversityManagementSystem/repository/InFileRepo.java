package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Identifiable;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InFileRepo<T extends Identifiable> implements BaseRepo<T> {

    private final ObjectMapper mapper = new ObjectMapper();
    private final String filePath;
    private final Class<T> type;

    public InFileRepo(String filePath,Class<T> type ) {
        this.filePath = filePath;
        this.type = type;
    }


    private List<T> readAll() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();

            var javaType = mapper.getTypeFactory()
                    .constructCollectionType(List.class, type);
            return mapper.readValue(file, javaType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeAll(List<T> data) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        return readAll();
    }

    @Override
    public T findById(String id) {
        return readAll().stream()
                .filter(e -> id.equals(e.getId()) )
                .findFirst()
                .orElse(null);
    }

    @Override
    public T save(T entity) {
        List<T> all = readAll();
        all.add(entity);
        writeAll(all);
        return entity;
    }



    @Override
    public void delete(String id) {
        List<T> all = readAll();
        boolean removed = all.removeIf(e -> id.equals(e.getId()));
        System.out.println("Deleting entity with id=" + id + " success=" + removed);
        writeAll(all);
    }
}

