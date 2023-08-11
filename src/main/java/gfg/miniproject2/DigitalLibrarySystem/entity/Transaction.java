package gfg.miniproject2.DigitalLibrarySystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Proj2Transaction")
public class Transaction {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "BINARY(16)")
    private UUID transactionId;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "Book_Id", referencedColumnName = "id")
    private Book book;

    @ManyToOne(targetEntity = Card.class)
    @JoinColumn(name = "Card_Id", referencedColumnName = "id")
    private Card card;

    @Column(name = "TransactionDate")
    private Instant transactionDate;

    @Column(name = "BookDueDate")
    private Instant transactionBookDueDate;

    @Column(name = "isIssued")
    private boolean transactionIssued;

    @Column(name = "isReturned")
    private boolean transactionReturned;

    @Column(name = "FineAmount")
    private long transactionFineAmount;

    @Column(name = "Status")
    private String transactionStatus;

    @Column(name = "CreatedOn")
    private Instant transactionCreatedOn;

    @Column(name = "UpdatedOn")
    private Instant transactionUpdatedOn;

    public Transaction(Book book, Card card, Instant transactionDate, Instant transactionBookDueDate, boolean transactionIssued, boolean transactionReturned, long transactionFineAmount, String transactionStatus, Instant transactionCreatedOn, Instant transactionUpdatedOn) {
        this.book = book;
        this.card = card;
        this.transactionDate = transactionDate;
        this.transactionBookDueDate = transactionBookDueDate;
        this.transactionIssued = transactionIssued;
        this.transactionReturned = transactionReturned;
        this.transactionFineAmount = transactionFineAmount;
        this.transactionStatus = transactionStatus;
        this.transactionCreatedOn = transactionCreatedOn;
        this.transactionUpdatedOn = transactionUpdatedOn;
    }
}
