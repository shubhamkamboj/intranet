package com.intranet.controller;

import com.intranet.entity.ClassRoom;
import com.intranet.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    // Create
    @PostMapping
    public ResponseEntity<ClassRoom> createClassRoom(@RequestBody ClassRoom classRoom) {
        return ResponseEntity.ok(classRoomService.createClassRoom(classRoom));
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<ClassRoom>> getAllClassRooms() {
        return ResponseEntity.ok(classRoomService.getAllClassRooms());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> getClassRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(classRoomService.getClassRoomById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom classRoom) {
        return ResponseEntity.ok(classRoomService.updateClassRoom(id, classRoom));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassRoom(@PathVariable Long id) {
        classRoomService.deleteClassRoom(id);
        return ResponseEntity.noContent().build();
    }
}
