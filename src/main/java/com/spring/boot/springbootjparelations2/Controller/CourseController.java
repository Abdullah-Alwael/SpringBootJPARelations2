package com.spring.boot.springbootjparelations2.Controller;

import com.spring.boot.springbootjparelations2.Api.ApiResponse;
import com.spring.boot.springbootjparelations2.Model.Course;
import com.spring.boot.springbootjparelations2.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addCourse(@Valid @RequestBody Course course, @PathVariable Integer teacherId){
        courseService.addCourse(course, teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Course added successfully"));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourses());

    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @Valid @RequestBody Course course){
        courseService.updateCourse(courseId, course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Course updated successfully"));

    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Course deleted successfully"));

    }
}
