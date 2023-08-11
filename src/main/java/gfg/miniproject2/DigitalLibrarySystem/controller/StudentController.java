package gfg.miniproject2.DigitalLibrarySystem.controller;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/testStudentAPI")
    public String testStudentAPI(){
        return "Student Test API works!";
    }

    @PostMapping("/createStudent")
    public CreateStudentResponseModel createStudent(@RequestBody CreateStudentRequestModel createStudentRequestModel){
        return  studentService.createStudent(createStudentRequestModel);
    }
    @GetMapping("/getAllStudents")
    public List<CreateStudentResponseModel> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentById")
    public CreateStudentResponseModel getStudentById(UUID id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deleteStudent")
    public UUID deleteStudentById(UUID id){
        return studentService.deleteStudentById(id);
    }
}
