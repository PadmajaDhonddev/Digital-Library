package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateCardRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateCardResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ICardService {
    public String testCardAPI();

    public CreateCardResponseModel createCard( CreateCardRequestModel createCardRequestModel);
    public List<CreateCardResponseModel> getAllCards();
    public CreateCardResponseModel getCardById( UUID id);
    public void deleteCardById( UUID id);

    public void updateCardById( UUID id, CreateCardRequestModel createCardRequestModel);
}
