package gfg.miniproject2.DigitalLibrarySystem.entity;

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
@Table(name = "Proj2Card")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "BINARY(16)")
    private UUID cardId;

    @Column(name = "Status")
    private String cardStatus;

    @Column(name = "Email")
    private String cardEmail;

    @Column(name = "ValidUpto")
    private Date cardValidUpto;

    @Column(name = "CreatedOn")
    private Date cardCreatedOn;

    @Column(name = "UpdatedOn")
    private Date cardUpdatedOn;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

}
