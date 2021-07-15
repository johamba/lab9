package edu.miu.cs.cs425.eregistrarwebapi.controller;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/eregistrar/api/student")
//@CrossOrigin(origins = {"http://127.0.0.1:5500/", "http://localhost:5500/"}, allowedHeaders = "*")
@CrossOrigin(allowedHeaders = "*")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Displays JSON array of Students data.
    @GetMapping("/list")
    public List<Student> findStudents() {
        return studentService.findAllStudents();
    }

    //Register a new Student into the system
    @PostMapping("/register")
    public Student registerStudent(@Valid @RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    // Read/display a Student data for student with ID, 1.
    @GetMapping("/get/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return studentService.findStudentById(studentId);
    }

    //Retrieves and Updates Student data for student with ID, 1.
    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody Student editedStudent, @PathVariable Long studentId){
        return studentService.updateStudent(editedStudent,studentId);
    }
    //Delete the student data for student with ID, 3.
    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

}
