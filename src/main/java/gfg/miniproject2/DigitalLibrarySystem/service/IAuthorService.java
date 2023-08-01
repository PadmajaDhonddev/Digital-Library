package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorResponseModel;

import java.util.List;

public interface IAuthorService {
    public String testAuthorAPI();
    public CreateAuthorResponseModel createAuthor(CreateAuthorRequestModel createAuthorRequestModel);
    public List<CreateAuthorResponseModel> getAllAuthors();
}
