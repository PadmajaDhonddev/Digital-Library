package gfg.miniproject2.DigitalLibrarySystem.model;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBookRequestModel {

    private UUID bookId;
    private String bookName;
    private int numberOfPages;
    private String bookLanguage;
    private boolean available;
    private String bookGenre;
    private String bookISBNNumber;
    private Date bookPublishedDate;
    private Author author;

}
