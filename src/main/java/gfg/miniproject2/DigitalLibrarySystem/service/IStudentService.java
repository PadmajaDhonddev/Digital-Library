package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentResponseModel;

import java.util.List;
import java.util.UUID;

public interface IStudentService {
    public CreateStudentResponseModel createStudent(CreateStudentRequestModel createStudentRequestModel);
    public List<CreateStudentResponseModel> getAllStudents();
    public CreateStudentResponseModel getStudentById(UUID id);
    public UUID deleteStudentById(UUID id);
    public void updateStudentById(UUID id, CreateStudentRequestModel createStudentRequestModel);

    }
