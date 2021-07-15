package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> findAllStudents();
    public abstract Student registerStudent(Student student);
    public abstract Student findStudentById(Long studentId);
    public abstract void deleteStudentById(Long studentId);
    public abstract Student updateStudent(Student student, Long studentId);

//    http://localhost/eregistrar/api/student/get/1 - Retrieves and Updates Student data for student with ID, 1.



}
