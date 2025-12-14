package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository  extends JpaRepository<Room,String> {
    // nume sala
    List<Room> findByNameContainingIgnoreCase(String name, Sort sort);

    // numar sala
    List<Room> findByNumberContainingIgnoreCase(String number, Sort sort);

    // capacitate minima
    List<Room> findByCapacityGreaterThanEqual(double capacity, Sort sort);

    // nume universitate
    List<Room> findByUniversity_NameContainingIgnoreCase(String universityName, Sort sort);

    //nume univ + capacitate minima
    List<Room> findByCapacityGreaterThanEqualAndUniversity_NameContainingIgnoreCase(double capacity, String universityName, Sort sort);

    // toate
    List<Room> findByNumberContainingIgnoreCaseAndCapacityGreaterThanEqualAndNameContainingIgnoreCaseAndUniversity_NameContainingIgnoreCase(
            String number, double capacity, String name, String universityName, Sort sort);

    // fara nume sala
    List<Room> findByNumberContainingIgnoreCaseAndCapacityGreaterThanEqualAndUniversity_NameContainingIgnoreCase(
            String number, double capacity, String universityName, Sort sort);

    // fara numar
    List<Room> findByCapacityGreaterThanEqualAndNameContainingIgnoreCaseAndUniversity_NameContainingIgnoreCase(
            double capacity, String name, String universityName, Sort sort);

    // fara universitate
    List<Room> findByNumberContainingIgnoreCaseAndCapacityGreaterThanEqualAndNameContainingIgnoreCase(
            String number, double capacity, String name, Sort sort);

}




