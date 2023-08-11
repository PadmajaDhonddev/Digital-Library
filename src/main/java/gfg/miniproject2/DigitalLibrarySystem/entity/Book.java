package gfg.miniproject2.DigitalLibrarySystem.entity;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateBookRequestModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Proj2Book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "BINARY(16)")
    private UUID bookId;

    @Column(name = "Name")
    private String bookName;

    @Column(name = "NumberOfPages")
    private int numberOfPages;

    @Column(name = "Language")
    private String bookLanguage;

    @Column(name = "isAvailable")
    private boolean available;

    @Column(name = "Genre")
    private String bookGenre;

    @Column(name = "ISBNNumber")
    private String bookISBNNumber;

    @Column(name = "PublishedDate")
    private Date bookPublishedDate;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "`id`")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Book(String bookName, int numberOfPages, String bookLanguage, boolean available, String bookGenre, String bookISBNNumber, Date bookPublishedDate) {
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.bookLanguage = bookLanguage;
        this.available = available;
        this.bookGenre = bookGenre;
        this.bookISBNNumber = bookISBNNumber;
        this.bookPublishedDate = bookPublishedDate;
    }

    public Book(String bookName, int numberOfPages, String bookLanguage, boolean available, String bookGenre, String bookISBNNumber, Date bookPublishedDate, Author author) {
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.bookLanguage = bookLanguage;
        this.available = available;
        this.bookGenre = bookGenre;
        this.bookISBNNumber = bookISBNNumber;
        this.bookPublishedDate = bookPublishedDate;
        this.author = author;
    }

}
