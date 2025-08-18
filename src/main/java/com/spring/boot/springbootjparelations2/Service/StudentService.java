package com.spring.boot.springbootjparelations2.Service;

import com.spring.boot.springbootjparelations2.Api.ApiException;
import com.spring.boot.springbootjparelations2.Model.Student;
import com.spring.boot.springbootjparelations2.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student){
        // TODO should the courses be assigned here?
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Integer studentId){
        return studentRepository.findStudentById(studentId);
    }

    public void updateStudent(Integer studentId, Student student){
        Student oldStudent = getStudent(studentId);

        if (oldStudent == null){
            throw new ApiException("Error, student not found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());

        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer studentId){
        Student oldStudent = getStudent(studentId);

        if (oldStudent == null){
            throw new ApiException("Error, student not found");
        }

        studentRepository.delete(oldStudent);
    }

    public void updateStudentMajor(Integer studentId, String major){
        Student student = getStudent(studentId);

        if (student == null){
            throw new ApiException("Error, student not found");
        }

        student.setCourses(null); // will the database be erased?
        student.setMajor(major);

    }
}
