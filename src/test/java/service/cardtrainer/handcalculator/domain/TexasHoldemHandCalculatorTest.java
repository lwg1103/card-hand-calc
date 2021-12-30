package service.cardtrainer.handcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.cardtrainer.handcalculator.domain.exception.InvalidHandException;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TexasHoldemHandCalculatorTest
{
    TexasHoldemHandCalculator testSubject;

    @Test
    public void itThrowsExceptionIfHandInvalid()
    {
        ArrayList<Card> tooFewCards = new ArrayList<>();
        tooFewCards.add(new Card("a", "diamond"));

        assertThrows(InvalidHandException.class, () -> testSubject.scoreHand(tooFewCards));

        ArrayList<Card> tooManyCards = new ArrayList<>();
        tooManyCards.add(new Card("a", "diamond"));
        tooManyCards.add(new Card("a", "diamond"));
        tooManyCards.add(new Card("a", "diamond"));

        assertThrows(InvalidHandException.class, () -> testSubject.scoreHand(tooManyCards));
    }

    @ParameterizedTest
    @MethodSource("itScoresHandProvider")
    public void itScoresHand(Card card1, Card card2, int expectedScore)
    {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        assertEquals(expectedScore, testSubject.scoreHand(cards));
    }

    public static Stream<Arguments> itScoresHandProvider()
    {
        return Stream.of(
                Arguments.of(new Card("a", "diamond"), new Card("5", "spade"), 21),
                Arguments.of(new Card("7", "diamond"), new Card("2", "spade"), 9),
                Arguments.of(new Card("a", "diamond"), new Card("5", "diamond"), 25),
                Arguments.of(new Card("7", "diamond"), new Card("2", "diamond"), 13),
                Arguments.of(new Card("7", "diamond"), new Card("6", "spade"), 16),
                Arguments.of(new Card("a", "diamond"), new Card("k", "spade"), 33),
                Arguments.of(new Card("9", "diamond"), new Card("7", "spade"), 18),
                Arguments.of(new Card("9", "diamond"), new Card("6", "spade"), 16),
                Arguments.of(new Card("9", "diamond"), new Card("5", "spade"), 14),
                Arguments.of(new Card("9", "diamond"), new Card("9", "spade"), 28),
                Arguments.of(new Card("a", "diamond"), new Card("a", "spade"), 42)
        );
    }

    @BeforeEach
    void setUp()
    {
        testSubject = new TexasHoldemHandCalculator();
    }
}