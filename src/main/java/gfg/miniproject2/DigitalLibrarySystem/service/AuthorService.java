package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.IAuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public String testAuthorAPI() {
        return "Author Test API works!";
    }

    public CreateAuthorResponseModel createAuthor(CreateAuthorRequestModel createAuthorRequestModel){
        Author author = new Author(
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

    public CreateAuthorResponseModel getAuthorById(UUID authorId) {

        Author author = authorRepository.findById(authorId).get();
        return new CreateAuthorResponseModel(author.getAuthorId(),
                author.getAuthorName(), author.getAuthorEmail(),author.getAuthorAge(), author.getAuthorCountry());
    }

    public String deleteAuthorById(UUID authorId){
        CreateAuthorResponseModel createAuthorResponseModel = getAuthorById(authorId);
        authorRepository.deleteById(authorId);
        return createAuthorResponseModel.getAuthorId().toString();
    }

    public void updateAuthorById(UUID authorId, CreateAuthorRequestModel createAuthorRequestModel){

        Author author = authorRepository.findById(authorId).get();
        author.setAuthorName(createAuthorRequestModel.getAuthorName());
        author.setAuthorEmail(createAuthorRequestModel.getAuthorEmail());
        author.setAuthorAge(createAuthorRequestModel.getAuthorAge());
        author.setAuthorCountry(createAuthorRequestModel.getAuthorCountry());
        authorRepository.save(author);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(author);     // This will persist the Author entity
    }
}
