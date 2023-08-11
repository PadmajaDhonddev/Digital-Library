package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.entity.Book;
import gfg.miniproject2.DigitalLibrarySystem.entity.Student;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.IStudentRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    public CreateStudentResponseModel createStudent(CreateStudentRequestModel createStudentRequestModel) {
        Student student = new Student(createStudentRequestModel.getStudentId(),
                createStudentRequestModel.getStudentAge(),
                createStudentRequestModel.getStudentName(),
                createStudentRequestModel.getStudentCountry(),
                createStudentRequestModel.getStudentEmail(),
                createStudentRequestModel.getStudentPhoneNumber(),
                createStudentRequestModel.getStudentCreatedOn(),
                createStudentRequestModel.getStudentUpdatedOn(),createStudentRequestModel.getCard());
        studentRepository.save(student);
        CreateStudentResponseModel createStudentResponseModel = new CreateStudentResponseModel(
                student.getStudentId(),student.getStudentAge(),
                student.getStudentName(), student.getStudentEmail(), student.getStudentCountry(),
                student.getStudentPhoneNumber(), student.getStudentCreatedOn(), student.getStudentUpdatedOn(),
                student.getCard());
        return createStudentResponseModel;
    }
    public List<CreateStudentResponseModel> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<CreateStudentResponseModel> createStudentResponseModels = new ArrayList<>();
        for (Student student:students) {
            CreateStudentResponseModel createStudentResponseModel = new CreateStudentResponseModel(
                    student.getStudentId(),
                    student.getStudentAge(),
                    student.getStudentName(),
                    student.getStudentCountry(),
                    student.getStudentEmail(),
                    student.getStudentPhoneNumber(),
                    student.getStudentCreatedOn(),
                    student.getStudentUpdatedOn(),
                    student.getCard());
            createStudentResponseModels.add(createStudentResponseModel);
        }
        return createStudentResponseModels;
    }
    public CreateStudentResponseModel getStudentById(UUID id) {
        Student student = studentRepository.findById(id).get();
        return new CreateStudentResponseModel(student.getStudentId(),student.getStudentAge(),
                student.getStudentName(), student.getStudentEmail(), student.getStudentCountry(),
                student.getStudentPhoneNumber(), student.getStudentCreatedOn(), student.getStudentUpdatedOn(),
                student.getCard());
    }
    public UUID deleteStudentById(UUID id) {
        CreateStudentResponseModel createStudentResponseModel = getStudentById(id);
        studentRepository.deleteById(id);
        return createStudentResponseModel.getStudentId();
    }
    public void updateStudentById(UUID studentId, CreateStudentRequestModel createStudentRequestModel){

        Student student = studentRepository.findById(studentId).get();
        student.setStudentName(createStudentRequestModel.getStudentName());
        student.setStudentCountry(createStudentRequestModel.getStudentCountry());
        student.setStudentEmail(createStudentRequestModel.getStudentEmail());
        student.setStudentPhoneNumber(createStudentRequestModel.getStudentPhoneNumber());
        student.setStudentCreatedOn(createStudentRequestModel.getStudentCreatedOn());
        student.setStudentUpdatedOn(createStudentRequestModel.getStudentUpdatedOn());
        student.setCard(createStudentRequestModel.getCard());
        studentRepository.save(student);
    }
}
