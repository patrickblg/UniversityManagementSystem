package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Room;

import java.util.List;
import java.util.ArrayList;

public class RoomRepository {
    private final List<Room> rooms = new ArrayList<>();
    public Room save(Room r) {
        rooms.add(r);
        return r;
    }
    public List<Room> findAll() {
        List<Room> roomsTemp = new ArrayList<>();
        for (Room r : rooms) {
            roomsTemp.add(r);
        }
        return roomsTemp;
    }
    public List<Room> findById(String roomId) {
        for (Room r : rooms) {
            if (r.getRoomId().equals(roomId)) {
                return rooms;
            }
        }
        return null;
    }
    public void delete(String roomId) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomId().equals(roomId)) {
                rooms.remove(i);
                i--;
            }
        }
    }
}
