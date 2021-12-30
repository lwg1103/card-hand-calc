package service.cardtrainer.handcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{
    @Test
    public void itReturnsCardFigureOrder()
    {
        assertEquals(5, (new Card("5", "diamond")).getFigureOrder());
        assertEquals(2, (new Card("2", "diamond")).getFigureOrder());
        assertEquals(10, (new Card("10", "diamond")).getFigureOrder());
        assertEquals(11, (new Card("j", "diamond")).getFigureOrder());
        assertEquals(14, (new Card("a", "diamond")).getFigureOrder());
    }
}