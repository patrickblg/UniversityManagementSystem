package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Room;

import java.util.List;
import java.util.ArrayList;

public class RoomRepository  implements BaseRepo<Room>{
    private final List<Room> rooms = new ArrayList<>();

    @Override
    public Room save(Room r) {
        rooms.add(r);
        return r;
    }
    @Override
    public List<Room> findAll() {
        return rooms;
    }

    @Override
    public Room findById(String roomId) {
        for (Room r : rooms) {
            if (r.getRoomId().equals(roomId)) {
                return r;
            }
        }
        return null;
    }
    @Override
    public void delete(String roomId) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomId().equals(roomId)) {
                rooms.remove(i);
                i--;
            }
        }
    }
}
