package gfg.miniproject2.DigitalLibrarySystem.model;

import gfg.miniproject2.DigitalLibrarySystem.entity.Book;
import gfg.miniproject2.DigitalLibrarySystem.entity.Card;
import lombok.*;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateTransactionResponseModel {
    private UUID transactionId;

    private Book book;

    private Card card;

    private Instant transactionDate;

    private Instant transactionBookDueDate;

    private boolean transactionIssued;

    private boolean transactionReturned;

    private long transactionFineAmount;

    private String transactionStatus;

    private Instant transactionCreatedOn;

    private Instant transactionUpdatedOn;
}
