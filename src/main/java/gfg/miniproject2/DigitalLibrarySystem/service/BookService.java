package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Book;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.IBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    public String testBookAPI(){
        return "Book Test API works!";
    }
    public CreateBookResponseModel createBook(CreateBookRequestModel createBookRequestModel){
        Book book = new Book(
                createBookRequestModel.getBookName(),
                createBookRequestModel.getNumberOfPages(),
                createBookRequestModel.getBookLanguage(),
                createBookRequestModel.isAvailable(),
                createBookRequestModel.getBookGenre(),
                createBookRequestModel.getBookISBNNumber(),
                createBookRequestModel.getBookPublishedDate(),
                createBookRequestModel.getAuthor());
        try{bookRepository.save(book);}
        catch (Exception e){
            e.printStackTrace();
        }
        CreateBookResponseModel createBookResponseModel = new CreateBookResponseModel(book.getBookId(),
                book.getBookName(), book.getNumberOfPages(), book.getBookLanguage(), book.isAvailable(), book.getBookGenre(),
                book.getBookISBNNumber(), book.getBookPublishedDate(), book.getAuthor());
        return createBookResponseModel;
    }

    public List<CreateBookResponseModel> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<CreateBookResponseModel> createBookResponseModels = new ArrayList<>();
        for (Book book:books) {
            CreateBookResponseModel createBookResponseModel = new CreateBookResponseModel(book.getBookId(),
                    book.getBookName(), book.getNumberOfPages(), book.getBookLanguage(), book.isAvailable(), book.getBookGenre(),
                    book.getBookISBNNumber(), book.getBookPublishedDate(), book.getAuthor());
            createBookResponseModels.add(createBookResponseModel);
        }
        return createBookResponseModels;
    }

    public CreateBookResponseModel getBookById(UUID id) {
        Book book = bookRepository.findById(id).get();
        return new CreateBookResponseModel(book.getBookId(),
                book.getBookName(), book.getNumberOfPages(), book.getBookLanguage(), book.isAvailable(), book.getBookGenre(),
                book.getBookISBNNumber(), book.getBookPublishedDate(), book.getAuthor());
    }
        public UUID deleteBookById(UUID id) {
            CreateBookResponseModel createBookResponseModel = getBookById(id);
            bookRepository.deleteById(id);

            return createBookResponseModel.getBookId();
        }

    public void updateBookById(UUID id, CreateBookRequestModel createBookRequestModel) {
        Book book = bookRepository.findById(id).get();
        book.setBookName(createBookRequestModel.getBookName());
        book.setNumberOfPages(createBookRequestModel.getNumberOfPages());
        book.setBookLanguage(createBookRequestModel.getBookLanguage());
        book.setAvailable(createBookRequestModel.isAvailable());
        book.setBookGenre(createBookRequestModel.getBookGenre());
        book.setBookISBNNumber(createBookRequestModel.getBookISBNNumber());
        book.setBookPublishedDate(createBookRequestModel.getBookPublishedDate());
        book.setAuthor(createBookRequestModel.getAuthor());
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(book);     // This will persist the Book entity
        entityManager.persist(book.getAuthor());     // This will persist the Author entity

        bookRepository.save(book);
    }
}
