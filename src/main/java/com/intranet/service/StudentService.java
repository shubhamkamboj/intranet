package com.intranet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intranet.entity.Parent;
import com.intranet.entity.Section;
import com.intranet.entity.Student;
import com.intranet.exception.BusinessException;
import com.intranet.repository.ParentRepository;
import com.intranet.repository.SectionRepository;
import com.intranet.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private ParentRepository parentRepository;

	public Student createStudent(Student student) {

		
		boolean sectionPresent=false;
		boolean parentPresent = false;
		
		
		// check section available
		if (student.getSection() != null && student.getSection().getId() != null && student.getSection().getId() != 0) {
			Optional<Section> sectionDetails = sectionRepository.findById(student.getSection().getId());
			if (sectionDetails.isPresent()) {
				sectionPresent = true;
			} else {
				throw new BusinessException("section not found with sectionDetails ID: " + sectionDetails.get().getId());
			}
		} else {
			throw new BusinessException("section not found with ID: " + student.getSection().getId());
		}
		
		
		// check parent available
		
		if(student.getParent() != null && student.getParent().getId() != null && student.getParent().getId() != 0) {
			Optional<Parent> parentDetails = parentRepository.findById(student.getParent().getId());
			if(parentDetails.isPresent()) {
				parentPresent = true;
			}else {
				throw new BusinessException("parent not found with parentDetails ID: " + parentDetails.get().getId());
			}
		}else {
			throw new BusinessException("parent not found with ID: " + student.getParent().getId());
		}
		
		if(sectionPresent && parentPresent && student != null) {
			student.setId(null);
			return studentRepository.save(student);
		}else {
			return null;
		}
		

	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	}

	public Student updateStudent(Long id, Student studentDetails) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

		existingStudent.setName(studentDetails.getName());
		existingStudent.setEmail(studentDetails.getEmail());
		existingStudent.setPhone(studentDetails.getPhone());
		existingStudent.setClassRoom(studentDetails.getClassRoom());
		existingStudent.setSection(studentDetails.getSection());
		existingStudent.setParent(studentDetails.getParent());

		return studentRepository.save(existingStudent);
	}

	public void deleteStudent(Long id) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		studentRepository.delete(existingStudent);
	}
}
