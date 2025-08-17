package com.spring.boot.springbootjparelations2.Service;

import com.spring.boot.springbootjparelations2.Api.ApiException;
import com.spring.boot.springbootjparelations2.Model.Course;
import com.spring.boot.springbootjparelations2.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course getCourse(Integer courseId){
        return courseRepository.findCourseById(courseId);
    }

    public void updateCourse(Integer courseId, Course course){
        Course oldCourse = courseRepository.findCourseById(courseId);

        if (oldCourse == null){
            throw new ApiException("Error, course not found");
        }

        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer courseId){
        Course oldCourse = courseRepository.findCourseById(courseId);

        if (oldCourse == null){
            throw new ApiException("Error, course not found");
        }

        courseRepository.delete(oldCourse);
    }
}
