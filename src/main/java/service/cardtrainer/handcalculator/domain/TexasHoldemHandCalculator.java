package service.cardtrainer.handcalculator.domain;

import org.springframework.stereotype.Component;
import service.cardtrainer.handcalculator.domain.exception.InvalidHandException;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class TexasHoldemHandCalculator implements HandCalculator
{
    @Override
    public int scoreHand(ArrayList<Card> cards)
    {
        if (cards.size() != 2) {
            throw new InvalidHandException();
        }

        return addCardRawValue(cards.get(0)) + addCardRawValue(cards.get(1)) + addColorBonus(cards) + addDistanceBonus(cards);
    }

    private int addCardRawValue(Card card)
    {
        if (card.getFigureOrder() == 14) {
            return 16;
        } else if (card.getFigureOrder() >= 10) {
            return card.getFigureOrder()+1;
        }

        return card.getFigureOrder();
    }

    private int addColorBonus(ArrayList<Card> cards)
    {
        if (Objects.equals(cards.get(0).getColor(), cards.get(1).getColor())) {
            return 4;
        }

        return 0;
    }

    private int addDistanceBonus(ArrayList<Card> cards)
    {
        int distance = Math.abs(cards.get(0).getFigureOrder() - cards.get(1).getFigureOrder());

        switch (distance) {
            case 0:
                return 10;
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 1;
            default:
                return 0;
        }
    }
}
