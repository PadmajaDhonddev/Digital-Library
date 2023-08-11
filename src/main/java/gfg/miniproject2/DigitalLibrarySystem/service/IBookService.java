package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookResponseModel;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    public String testBookAPI();
    public CreateBookResponseModel createBook(CreateBookRequestModel createBookRequestModel);
    public List<CreateBookResponseModel> getAllBooks();
    public CreateBookResponseModel getBookById(UUID id);
    public UUID deleteBookById(UUID id);
    public void updateBookById(UUID id, CreateBookRequestModel createBookRequestModel);

}
