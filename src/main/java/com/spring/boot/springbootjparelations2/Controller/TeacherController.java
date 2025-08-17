package com.spring.boot.springbootjparelations2.Controller;

import com.spring.boot.springbootjparelations2.Api.ApiResponse;
import com.spring.boot.springbootjparelations2.Model.Teacher;
import com.spring.boot.springbootjparelations2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher added successfully"));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());

    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer teacherId, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(teacherId, teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher updated successfully"));

    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher deleted successfully"));

    }

    @GetMapping("/details/{teacherId}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer teacherId){
        return ResponseEntity.status(HttpStatus.OK).body(
                teacherService.getTeacherDetails(teacherId));

    }
}
