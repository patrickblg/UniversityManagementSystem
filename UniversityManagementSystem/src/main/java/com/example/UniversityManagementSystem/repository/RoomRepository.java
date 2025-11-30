package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// public class RoomRepository  extends JpaRepository<Room>{

public interface RoomRepository  extends JpaRepository<Room,String> {


}
//rel m:m -> se creeaza un tabel nou
//@ManyToMany(mappedBy = "course")
//private List<Room> rooms;

//in service
//public Scene addDeviceToScene (Long deviceId, Long sceneId){
//  Optional <Device> deviceOptional = deviceRepository.findById(deviceId)
//           .orElseThrow(() -> new RuntimeException("not found"));
//   Optional <Device> deviceOptional = deviceRepository.findById(deviceId)
//           .orElseThrow(() -> new RuntimeException("not found"));
// scene.setDevices(List.of(device));



