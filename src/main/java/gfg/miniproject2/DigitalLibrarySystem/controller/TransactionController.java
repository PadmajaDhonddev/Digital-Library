package gfg.miniproject2.DigitalLibrarySystem.controller;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateStudentResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateTransactionRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateTransactionResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.ITransactionRepository;
import gfg.miniproject2.DigitalLibrarySystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
     TransactionService transactionService;
    @GetMapping("/testTransactionAPI")
    public String testTransactionAPI(){
        return "Transaction API works!";
    }

    @GetMapping("/createTransaction")
    public CreateTransactionResponseModel createTransaction(@RequestBody CreateTransactionRequestModel createTransactionRequestModel) {
        return  transactionService.createTransaction(createTransactionRequestModel);
    }

    @GetMapping("/getAllTransactions")
    public List<CreateTransactionResponseModel> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @PostMapping("/issueBook")
    public void issueBook(@RequestParam("bookId") UUID bookId, @RequestParam("cardId") UUID cardId){
        transactionService.issueBook(bookId, cardId);
    }
}
