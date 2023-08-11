package gfg.miniproject2.DigitalLibrarySystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Proj2Student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "BINARY(16)")
    private UUID studentId;
    @Column(name = "Age")
    private int studentAge;
    @Column(name = "Name")
    private String studentName;
    @Column(name = "Country")
    private String studentCountry;
    @Column(name = "Email")
    private String studentEmail;
    @Column(name = "PhoneNumber")
    private String studentPhoneNumber;
    @Column(name = "CreatedOn")
    private Date studentCreatedOn;
    @Column(name = "UpdatedOn")
    private Date studentUpdatedOn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CardId", referencedColumnName = "id")
    private Card card;

    public Student(String studentName, String studentEmail, int studentAge, String studentCountry, String studentPhoneNumber, Date studentCreatedOn, Date studentUpdatedOn, Card card) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAge = studentAge;
        this.studentCountry = studentCountry;
    }
}
