package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;
    private Author author;

    @Override
    public String testAuthorAPI() {
        return "Author Test API works!";
    }

    public CreateAuthorResponseModel createAuthor(CreateAuthorRequestModel createAuthorRequestModel){
        author = new Author(
                createAuthorRequestModel.getAuthorName(),
                createAuthorRequestModel.getAuthorEmail(),
                createAuthorRequestModel.getAuthorAge(),
                createAuthorRequestModel.getAuthorCountry());
        System.out.println(author);
        authorRepository.save(author);
        CreateAuthorResponseModel createAuthorResponseModel = new CreateAuthorResponseModel(author.getAuthorId(),
                author.getAuthorName(), author.getAuthorEmail(),author.getAuthorAge(), author.getAuthorCountry());
        System.out.println(createAuthorResponseModel);
        return createAuthorResponseModel;
    }

    public List<CreateAuthorResponseModel> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        List<CreateAuthorResponseModel> createAuthorResponseModels = new ArrayList<>();
        for (Author author:authors) {
            CreateAuthorResponseModel createAuthorResponseModel = new CreateAuthorResponseModel(author.getAuthorId(),
                    author.getAuthorName(), author.getAuthorEmail(),author.getAuthorAge(), author.getAuthorCountry());
            createAuthorResponseModels.add(createAuthorResponseModel);
        }
        return createAuthorResponseModels;
    }

}
