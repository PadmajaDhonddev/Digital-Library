package gfg.miniproject2.DigitalLibrarySystem.service;

import gfg.miniproject2.DigitalLibrarySystem.entity.Card;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateCardRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateCardResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.repository.ICardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CardService implements ICardService{
    @Autowired
    private ICardRepository cardRepository;
    public String testCardAPI(){
        return "Card Test API works!";
    }
    public CreateCardResponseModel createCard(CreateCardRequestModel createCardRequestModel){
        Card card = new Card(
                createCardRequestModel.getCardId(),
                createCardRequestModel.getCardStatus(),
                createCardRequestModel.getCardEmail(),
                createCardRequestModel.getCardValidUpto(),
                createCardRequestModel.getCardCreatedOn(),
                createCardRequestModel.getCardUpdatedOn(),
                createCardRequestModel.getTransactions());
        try{cardRepository.save(card);}
        catch (Exception e){
            e.printStackTrace();
        }
        CreateCardResponseModel createCardResponseModel = new CreateCardResponseModel(card.getCardId(),card.getCardStatus(),
                card.getCardEmail(),card.getCardValidUpto(),card.getCardCreatedOn(),card.getCardUpdatedOn(),card.getTransactions());
        return createCardResponseModel;
    }

    public List<CreateCardResponseModel> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        List<CreateCardResponseModel> createCardResponseModels = new ArrayList<>();
        for (Card card:cards) {
            CreateCardResponseModel createCardResponseModel = new CreateCardResponseModel(card.getCardId(),card.getCardStatus(),
                    card.getCardEmail(),card.getCardValidUpto(),card.getCardCreatedOn(),card.getCardUpdatedOn(),card.getTransactions());
            createCardResponseModels.add(createCardResponseModel);
        }
        return createCardResponseModels;
    }

    public CreateCardResponseModel getCardById(UUID id) {
        Card card = cardRepository.findById(id).get();
        return new CreateCardResponseModel(card.getCardId(),card.getCardStatus(),
                card.getCardEmail(),card.getCardValidUpto(),card.getCardCreatedOn(),card.getCardUpdatedOn(),card.getTransactions());
    }
    public void deleteCardById(UUID id){
        cardRepository.deleteById(id);
    }

    public void deleteAllCards(){
        cardRepository.deleteAll();
    }
    public void updateCardById(UUID id, CreateCardRequestModel createCardRequestModel){
        Card card = cardRepository.findById(id).get();
        card.setCardStatus(createCardRequestModel.getCardStatus());
        card.setCardEmail(createCardRequestModel.getCardEmail());
        card.setCardValidUpto(createCardRequestModel.getCardValidUpto());
        card.setCardCreatedOn(createCardRequestModel.getCardCreatedOn());
        card.setCardUpdatedOn(createCardRequestModel.getCardUpdatedOn());
        card.setTransactions(createCardRequestModel.getTransactions());
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(card);     // This will persist the Card entity
        entityManager.persist(card.getTransactions());     // This will persist the Transactions entity

        cardRepository.save(card);
    }
}
