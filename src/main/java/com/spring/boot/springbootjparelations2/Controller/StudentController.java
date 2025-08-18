package com.spring.boot.springbootjparelations2.Controller;

import com.spring.boot.springbootjparelations2.Api.ApiResponse;
import com.spring.boot.springbootjparelations2.Model.Student;
import com.spring.boot.springbootjparelations2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Student added successfully"));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());

    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer studentId, @Valid @RequestBody Student student){
        studentService.updateStudent(studentId, student);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Student updated successfully"));

    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Student deleted successfully"));

    }

    public ResponseEntity<?> updateStudentMajor(@PathVariable Integer studentId, @PathVariable String major){
        studentService.updateStudentMajor(studentId, major);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Student major updated successfully"));

    }
}
