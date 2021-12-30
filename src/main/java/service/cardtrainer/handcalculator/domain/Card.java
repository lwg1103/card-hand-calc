package service.cardtrainer.handcalculator.domain;

public class Card
{
    private String figure;
    private String color;

    public Card(String figure, String color)
    {
        this.figure = figure;
        this.color = color;
    }

    public String getFigure()
    {
        return figure;
    }

    public int getFigureOrder()
    {
        try {
            return Integer.parseInt(figure);
        } catch (NumberFormatException e) {
            switch (figure) {
                case "j":
                    return 11;
                case "q":
                    return 12;
                case "k":
                    return 13;
                case "a":
                    return 14;
                default:
                    return 0;
            }
        }
    }

    public String getColor()
    {
        return color;
    }
}
