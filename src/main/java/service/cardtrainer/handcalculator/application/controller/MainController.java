package service.cardtrainer.handcalculator.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.cardtrainer.handcalculator.domain.Card;
import service.cardtrainer.handcalculator.domain.HandCalculator;
import service.cardtrainer.handcalculator.infrastructure.dto.Score;

import java.util.ArrayList;

@RestController
public class MainController
{
    @Autowired
    HandCalculator handCalculator;

    @PostMapping(path = "/score-cards", produces = "application/json")
    public Score scoreCards(@RequestBody ArrayList<service.cardtrainer.handcalculator.infrastructure.dto.Card> dtoCards)
    {
        ArrayList<Card> cards = new ArrayList<>();
        for (service.cardtrainer.handcalculator.infrastructure.dto.Card dtoCard : dtoCards) {
            cards.add(new Card(dtoCard.figure, dtoCard.color));
        }

        Score result = new Score();

        result.value = handCalculator.scoreHand(cards);

        return result;
    }
}
