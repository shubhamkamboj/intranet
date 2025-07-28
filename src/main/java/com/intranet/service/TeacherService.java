package com.intranet.service;

import com.intranet.entity.Teacher;
import com.intranet.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        existingTeacher.setName(teacherDetails.getName());
        existingTeacher.setSubjectSpecialization(teacherDetails.getSubjectSpecialization());
        existingTeacher.setEmail(teacherDetails.getEmail());

        return teacherRepository.save(existingTeacher);
    }

    public void deleteTeacher(Long id) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        teacherRepository.delete(existingTeacher);
    }
}
