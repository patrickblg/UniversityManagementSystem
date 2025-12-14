package com.example.UniversityManagementSystem.converter;

import com.example.UniversityManagementSystem.model.Staff;
import com.example.UniversityManagementSystem.repository.StaffRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToStaffConverter implements Converter<String, Staff> {

    private final StaffRepository staffRepository;

    public StringToStaffConverter(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        return staffRepository.findById(source).orElse(null);
    }
}