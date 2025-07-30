package com.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intranet.entity.ClassRoom;
import com.intranet.repository.ClassRoomRepository;

@Service
public class ClassRoomService  {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    public ClassRoom createClassRoom(ClassRoom classRoom) {
    	classRoom.setId(null);
        return classRoomRepository.save(classRoom);
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    public ClassRoom getClassRoomById(Long id) {
        return classRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassRoom not found with id: " + id));
    }

    public ClassRoom updateClassRoom(Long id, ClassRoom classRoom) {
        ClassRoom existing = classRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassRoom not found with id: " + id));
        existing.setName(classRoom.getName());
        return classRoomRepository.save(existing);
    }

    public void deleteClassRoom(Long id) {
        ClassRoom existing = classRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassRoom not found with id: " + id));
        classRoomRepository.delete(existing);
    }
}
