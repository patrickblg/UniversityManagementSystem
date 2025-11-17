package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Room;
import org.springframework.stereotype.Repository;


@Repository
public class RoomRepository  extends InFileRepo<Room>{
    public RoomRepository() {
        super("UniversityManagementSystem/src/main/resources/data/room.json",Room.class);
    }
}
