package gfg.miniproject2.DigitalLibrarySystem.controller;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateAuthorResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/getAuthorById/{id}")
    public CreateAuthorResponseModel getAuthorById(@PathVariable UUID id){
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("/deleteAuthorById/{id}")
    public String deleteAuthorById(@PathVariable UUID id){
        return authorService.deleteAuthorById(id);
    }

    @PutMapping("/updateAuthorById/{id}")
    public void updateAuthorById(@PathVariable UUID id, @RequestBody CreateAuthorRequestModel createAuthorRequestModel){
         authorService.updateAuthorById(id,createAuthorRequestModel);
    }
}
