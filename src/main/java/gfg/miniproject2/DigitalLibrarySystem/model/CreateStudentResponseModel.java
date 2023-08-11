package gfg.miniproject2.DigitalLibrarySystem.model;

import gfg.miniproject2.DigitalLibrarySystem.entity.Card;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentResponseModel {
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
