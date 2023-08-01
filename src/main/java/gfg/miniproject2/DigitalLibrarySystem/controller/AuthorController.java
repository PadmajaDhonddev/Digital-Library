package gfg.miniproject2.DigitalLibrarySystem.controller;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/testAuthor")
    public String testAuthorAPI(){
        return "Author Test API works!";
    }
    @PostMapping("/createAuthor")
    public CreateAuthorResponseModel createAuthor(@RequestBody CreateAuthorRequestModel createAuthorRequestModel){
        return authorService.createAuthor(createAuthorRequestModel);
    }

    @GetMapping("/getAllAuthors")
    public List<CreateAuthorResponseModel> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
