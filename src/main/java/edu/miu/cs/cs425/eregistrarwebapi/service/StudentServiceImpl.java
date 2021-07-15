package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Student editedStudent, Long studentId) {
        return studentRepository.findById(studentId)
                .map(studentToUpdate->{
                    studentToUpdate.setStudentNumber(editedStudent.getStudentNumber());
                    studentToUpdate.setFirstName(editedStudent.getFirstName());
                    studentToUpdate.setMiddleName(editedStudent.getMiddleName());
                    studentToUpdate.setLastName(editedStudent.getLastName());
                    studentToUpdate.setCgpa(editedStudent.getCgpa());
                    studentToUpdate.setEnrollmentDate(editedStudent.getEnrollmentDate());
                    studentToUpdate.setIsInternational(editedStudent.getIsInternational());
                    return studentRepository.save(studentToUpdate);
                }).orElseGet(()->{
                    return studentRepository.save(editedStudent);
                });
    }
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
