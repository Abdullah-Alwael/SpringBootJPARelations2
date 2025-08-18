package com.spring.boot.springbootjparelations2.Repository;

import com.spring.boot.springbootjparelations2.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}
