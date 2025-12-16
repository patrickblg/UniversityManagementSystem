package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.ManagingRole;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.repository.AssistantRepository;
import com.example.UniversityManagementSystem.repository.CourseRepository;
import com.example.UniversityManagementSystem.repository.TeacherRepository;
import com.example.UniversityManagementSystem.repository.TeachingAssignmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TeachingAssignmentService {
    private final TeachingAssignmentRepository teachingAssignmentRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final AssistantRepository assistantRepository;

    public TeachingAssignmentService(TeachingAssignmentRepository teachingAssignmentRepository,CourseRepository courseRepository,TeacherRepository teacherRepository,AssistantRepository assistantRepository) {
        this.teachingAssignmentRepository= teachingAssignmentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.assistantRepository = assistantRepository;
    }


    public void saveTeachingAssignment(TeachingAssignment t){

        if (t.getCourse() == null || t.getCourse().getId() == null || !courseRepository.existsById(t.getCourse().getId())) {
            throw new IllegalArgumentException("Nu se poate salva asignarea: Cursul asociat nu există.");
        }
        boolean staffExists = teacherRepository.existsById(t.getStaff().getId()) || assistantRepository.existsById(t.getStaff().getId());
        if (!staffExists) {
            throw new IllegalArgumentException("Nu se poate salva asignarea: Membrul de personal (Staff) asociat nu există.");
        }
        teachingAssignmentRepository.save(t);
    }

    public List<TeachingAssignment> findAllTeachingAssignments(){
        return teachingAssignmentRepository.findAll();
    }
    public List<TeachingAssignment> findAllTeachingAssignments(ManagingRole role, String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        if(role!=null){
            return teachingAssignmentRepository.findByManaging(role,sort);
        }else{
            return teachingAssignmentRepository.findAll(sort);
        }
    }

    public TeachingAssignment findTeachingAssignmentById(String id){
        return teachingAssignmentRepository.findById(id).orElse(null);
    }

    public void deleteteachingAssignment(String id){
        teachingAssignmentRepository.deleteById(id);
    }

    public void updateTeachingAssignment(TeachingAssignment t){
        if (t.getCourse() == null || t.getCourse().getId() == null || !courseRepository.existsById(t.getCourse().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza asignarea: Cursul asociat nu există.");
        }
        boolean staffExists = teacherRepository.existsById(t.getStaff().getId()) || assistantRepository.existsById(t.getStaff().getId());
        if (!staffExists) {
            throw new IllegalArgumentException("Nu se poate actualiza asignarea: Membrul de personal (Staff) asociat nu există.");
        }
        teachingAssignmentRepository.save(t);
    }

}