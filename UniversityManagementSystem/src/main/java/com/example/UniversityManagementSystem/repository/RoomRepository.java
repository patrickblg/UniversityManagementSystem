package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Room;
import org.springframework.stereotype.Repository;


@Repository
public class RoomRepository  extends InFileRepo<Room>{
    public RoomRepository() {
        super("room.json",Room.class);
    }
}
