package com.spring.boot.springbootjparelations2.Service;

import com.spring.boot.springbootjparelations2.Api.ApiException;
import com.spring.boot.springbootjparelations2.Model.Teacher;
import com.spring.boot.springbootjparelations2.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Integer teacherId){
        return teacherRepository.findTeacherById(teacherId);
    }

    public void updateTeacher(Integer teacherId, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(teacherId);

        if (oldTeacher == null){
            throw new ApiException("Error, teacher not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer teacherId){
        Teacher oldTeacher = teacherRepository.findTeacherById(teacherId);

        if (oldTeacher == null){
            throw new ApiException("Error, teacher not found");
        }

        teacherRepository.delete(oldTeacher);
    }

    public Teacher getTeacherDetails(Integer teacherId){
        Teacher teacher = getTeacher(teacherId);

        if (teacher == null){
            throw new ApiException("Error, teacher not found");
        }

        return teacher;
    }
}
