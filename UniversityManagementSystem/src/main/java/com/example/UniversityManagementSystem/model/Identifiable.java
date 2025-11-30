package com.example.UniversityManagementSystem.model;

import java.io.Serializable;

public interface Identifiable extends Serializable {
    String getId();
    void setId(String id);
}
