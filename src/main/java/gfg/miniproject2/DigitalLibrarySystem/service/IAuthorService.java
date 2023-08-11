package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorResponseModel;

import java.util.List;
import java.util.UUID;

public interface IAuthorService {
    public String testAuthorAPI();
    public CreateAuthorResponseModel createAuthor(CreateAuthorRequestModel createAuthorRequestModel);
    public List<CreateAuthorResponseModel> getAllAuthors();
    public CreateAuthorResponseModel getAuthorById(UUID authorId);
    public String deleteAuthorById(UUID authorId);
    public void updateAuthorById(UUID authorId, CreateAuthorRequestModel createAuthorRequestModel);
}
