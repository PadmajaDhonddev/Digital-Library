package gfg.miniproject2.DigitalLibrarySystem.controller;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/testBookAPI")
    public String testBookAPI(){
        return "Book Test API works!";
    }

    @PostMapping("/createBook")
    public CreateBookResponseModel createBook(@RequestBody CreateBookRequestModel createBookRequestModel){
        return bookService.createBook(createBookRequestModel);
    }
    @GetMapping("/getAllBooks")
    public List<CreateBookResponseModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public CreateBookResponseModel getBookById(@PathVariable UUID id){
        return bookService.getBookById(id);
    }
    @DeleteMapping("/deleteBookById/{id}")
    public UUID deleteBookById(@PathVariable UUID id){
        return bookService.deleteBookById(id);
    }
    @PutMapping("/updateBookById/{id}")
    public void updateBookById(@PathVariable UUID id, @RequestBody CreateBookRequestModel createBookRequestModel){
        bookService.updateBookById(id,createBookRequestModel);
    }
}
