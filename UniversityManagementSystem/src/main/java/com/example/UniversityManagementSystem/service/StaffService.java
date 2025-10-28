package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Staff;
import com.example.UniversityManagementSystem.repository.StaffRepository;


import java.util.List;

public class StaffService {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }
    public Staff save(Staff staff){
        return staffRepository.save(staff);
    }

    public Staff findById(String id){
        return staffRepository.findById(id);
    }
    public List<Staff> findAll(){
        return staffRepository.findAll();
    }
    public void delete(String id){
        staffRepository.delete(id);
    }

}
