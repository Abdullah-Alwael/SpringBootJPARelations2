package com.spring.boot.springbootjparelations2.Service;

import com.spring.boot.springbootjparelations2.Api.ApiException;
import com.spring.boot.springbootjparelations2.Model.Course;
import com.spring.boot.springbootjparelations2.Model.Student;
import com.spring.boot.springbootjparelations2.Model.Teacher;
import com.spring.boot.springbootjparelations2.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherService teacherService;

    public void addCourse(Course course, Integer teacherId){

        Teacher teacher = teacherService.getTeacher(teacherId);

        if (teacher == null){
            throw new ApiException("Error, teacher does not exist");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course getCourse(Integer courseId){
        return courseRepository.findCourseById(courseId);
    }

    public void updateCourse(Integer courseId, Course course){
        Course oldCourse = getCourse(courseId);

        if (oldCourse == null){
            throw new ApiException("Error, course does not exist");
        }

        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer courseId){
        Course oldCourse = getCourse(courseId);

        if (oldCourse == null){
            throw new ApiException("Error, course does not exist");
        }

//        oldCourse.setTeacher(null);   // will this also work? just like delete address?
//        oh, there is no need
        courseRepository.delete(oldCourse);
    }

    public String getCourseTeacher(Integer courseId){
        Course course = getCourse(courseId);

        if (course == null){
            throw new ApiException("Error, course does not exist");
        }

        Teacher teacher = course.getTeacher();

        if (teacher == null){
            throw new ApiException("Error, teacher does not exist");
        }

        return teacher.getName();
    }

    public List<Student> getCourseStudents(Integer courseId){
        Course course = getCourse(courseId);

        if (course == null){
            throw new ApiException("Error, course does not exist");
        }

        return new ArrayList<>(course.getStudents());
    }
}
