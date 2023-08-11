package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Book;
import gfg.miniproject2.DigitalLibrarySystem.entity.Card;
import gfg.miniproject2.DigitalLibrarySystem.entity.Transaction;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateTransactionRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateTransactionResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.IBookRepository;
import gfg.miniproject2.DigitalLibrarySystem.repository.ICardRepository;
import gfg.miniproject2.DigitalLibrarySystem.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ICardRepository cardRepository;

    public CreateTransactionResponseModel createTransaction(CreateTransactionRequestModel createTransactionRequestModel) {
        Transaction transaction = new Transaction();
        transaction.setBook(createTransactionRequestModel.getBook());
        transaction.setCard(createTransactionRequestModel.getCard());
        transaction.setTransactionDate(createTransactionRequestModel.getTransactionDate());
        transaction.setTransactionBookDueDate(createTransactionRequestModel.getTransactionBookDueDate());
        transaction.setTransactionIssued(createTransactionRequestModel.isTransactionIssued());
        transaction.setTransactionReturned(createTransactionRequestModel.isTransactionReturned());
        transaction.setTransactionFineAmount(createTransactionRequestModel.getTransactionFineAmount());
        transaction.setTransactionStatus(createTransactionRequestModel.getTransactionStatus());
        transaction.setTransactionCreatedOn(createTransactionRequestModel.getTransactionCreatedOn());
        transaction.setTransactionUpdatedOn(createTransactionRequestModel.getTransactionUpdatedOn());
        transactionRepository.save(transaction);
        CreateTransactionResponseModel createTransactionResponseModel = new CreateTransactionResponseModel(
                transaction.getTransactionId(), transaction.getBook(), transaction.getCard(),
                transaction.getTransactionDate(), transaction.getTransactionBookDueDate(), transaction.isTransactionIssued(),
                transaction.isTransactionReturned(), transaction.getTransactionFineAmount(), transaction.getTransactionStatus(),
                transaction.getTransactionCreatedOn(), transaction.getTransactionUpdatedOn());
        return createTransactionResponseModel;
    }

    public List<CreateTransactionResponseModel> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<CreateTransactionResponseModel> createTransactionResponseModels = new ArrayList<>();
        for (Transaction transaction : transactions) {
            CreateTransactionResponseModel createTransactionResponseModel = new CreateTransactionResponseModel(
                    transaction.getTransactionId(), transaction.getBook(), transaction.getCard(),
                    transaction.getTransactionDate(), transaction.getTransactionBookDueDate(), transaction.isTransactionIssued(),
                    transaction.isTransactionReturned(), transaction.getTransactionFineAmount(), transaction.getTransactionStatus(),
                    transaction.getTransactionCreatedOn(), transaction.getTransactionUpdatedOn());
            createTransactionResponseModels.add(createTransactionResponseModel);
        }
        return createTransactionResponseModels;
    }

    public CreateTransactionResponseModel getTransactionById(UUID id) {
        Transaction transaction = transactionRepository.findById(id).get();
        CreateTransactionResponseModel createTransactionResponseModel = new CreateTransactionResponseModel(
                transaction.getTransactionId(), transaction.getBook(), transaction.getCard(),
                transaction.getTransactionDate(), transaction.getTransactionBookDueDate(), transaction.isTransactionIssued(),
                transaction.isTransactionReturned(), transaction.getTransactionFineAmount(), transaction.getTransactionStatus(),
                transaction.getTransactionCreatedOn(), transaction.getTransactionUpdatedOn());
        return createTransactionResponseModel;
    }

    public UUID deleteTransactionById(UUID id) {
        CreateTransactionResponseModel createTransactionResponseModel = getTransactionById(id);
        transactionRepository.deleteById(id);
        return id;
    }

    /* public void updateTransactionById(UUID id, CreateTransactionRequestModel createTransactionRequestModel){
         Transaction transaction = transactionRepository.findById(id).get();
         transaction.setBook(createTransactionRequestModel.getBook());
         transaction.setCard(createTransactionRequestModel.getCard());
         transaction.setTransactionDate(createTransactionRequestModel.getTransactionDate());
         transaction.setTransactionBookDueDate(createTransactionRequestModel.getTransactionBookDueDate());
         transaction.setTransactionIssued(createTransactionRequestModel.isTransactionIssued());
         transaction.setTransactionReturned(createTransactionRequestModel.isTransactionReturned());
         transaction.setTransactionFineAmount(createTransactionRequestModel.getTransactionFineAmount());
         transaction.setTransactionStatus(createTransactionRequestModel.getTransactionStatus());
         transaction.setTransactionCreatedOn(createTransactionRequestModel.getTransactionCreatedOn());
         transaction.setTransactionUpdatedOn(createTransactionRequestModel.getTransactionUpdatedOn());
         transactionRepository.save(transaction);
     }
 */
    public void issueBook(UUID bookId, UUID cardId) {
        Book book;
        Card card;
        try{
             book = bookRepository.findById(bookId).get();
             card = cardRepository.findById(cardId).get();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }

        if (card.getCardStatus().equals("Issued")
                && book.isAvailable()
                && card.getTransactions().stream().count() <= 3) {
            card.setCardStatus("Issued");
            cardRepository.save(card);
            book.setAvailable(false);
            bookRepository.save(book);
            Instant transactionDate = Instant.now();
            Duration duration = Duration.ofDays(30);
            Instant transactionDueDate = transactionDate.plus(duration);
            Transaction transaction = new Transaction(
                    book,
                    card,
                    transactionDate,
                    transactionDueDate,
                    false,
                    false,
                    0,
                    "Success",
                    transactionDate,
                    null);
            try {
                transactionRepository.save(transaction);
            } catch (Exception e) {
                e.printStackTrace();
                Transaction transactionFailed = new Transaction(
                        book,
                        card,
                        transactionDate,
                        null,
                        false,
                        false,
                        0,
                        "Failed",
                        transactionDate,
                        null);
                transactionRepository.save(transactionFailed);
            }
        }
    }
}
