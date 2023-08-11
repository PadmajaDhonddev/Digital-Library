package gfg.miniproject2.DigitalLibrarySystem.model;

import gfg.miniproject2.DigitalLibrarySystem.entity.Transaction;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateCardResponseModel {
    private UUID cardId;

    private String cardStatus;

    private String cardEmail;

    private Date cardValidUpto;

    private Date cardCreatedOn;

    private Date cardUpdatedOn;

    private List<Transaction> transactions;
}
