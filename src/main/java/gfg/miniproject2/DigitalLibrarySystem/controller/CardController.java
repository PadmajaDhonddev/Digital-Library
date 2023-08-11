package gfg.miniproject2.DigitalLibrarySystem.controller;

import gfg.miniproject2.DigitalLibrarySystem.model.CreateCardRequestModel;
import gfg.miniproject2.DigitalLibrarySystem.model.CreateCardResponseModel;
import gfg.miniproject2.DigitalLibrarySystem.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/testCardAPI")
    public String testCardAPI(){
        return "Card Test API works!";
    }

    @PostMapping("/createCard")
    public CreateCardResponseModel createCard(@RequestBody CreateCardRequestModel createCardRequestModel){
        return cardService.createCard(createCardRequestModel);
    }
    @GetMapping("/getAllCards")
    public List<CreateCardResponseModel> getAllCards(){
        return cardService.getAllCards();
    }
    @GetMapping("/getCardById/{id}")
    public CreateCardResponseModel getCardById(@PathVariable UUID id){
        return cardService.getCardById(id);
    }
    @DeleteMapping("/deleteCardById/{id}")
    public void deleteCardById(@PathVariable UUID id){
        cardService.deleteCardById(id);
    }

    @PutMapping("/updateCardById/{id}")
    public void updateCardById(@PathVariable UUID id, @RequestBody CreateCardRequestModel createCardRequestModel){
        cardService.updateCardById(id,createCardRequestModel);
    }
}
