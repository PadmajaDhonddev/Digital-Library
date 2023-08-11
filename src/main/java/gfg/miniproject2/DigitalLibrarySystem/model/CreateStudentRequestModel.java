package gfg.miniproject2.DigitalLibrarySystem.model;

import gfg.miniproject2.DigitalLibrarySystem.entity.Card;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentRequestModel {

    private UUID studentId;
    private int studentAge;
    private String studentName;
    private String studentCountry;
    private String studentEmail;
    private String studentPhoneNumber;
    private Date studentCreatedOn;
    private Date studentUpdatedOn;
    private Card card;
}
