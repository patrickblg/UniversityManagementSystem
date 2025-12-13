package com.example.UniversityManagementSystem.repository;


import com.example.UniversityManagementSystem.model.University;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University,String> {

    List<University> findByNameContainingIgnoreCase(String name, Sort sort);

    List<University> findByCityContainingIgnoreCase(String city, Sort sort);

    List<University> findByNameContainingIgnoreCaseAndCityIsContainingIgnoreCase(String name, String city, Sort sort);


}
