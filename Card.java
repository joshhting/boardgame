/**
 * Class representation of a card
 *
 * @author Josh Ting
 */
public class Card {
    CardType type;
    int cost;
    String text;

    public Card(CardType type, int cost String text) {
        this.type = type;
        this.cost = cost;
        this.text = text;
    }

}

private enum CardType {
    OPERATION,
    SHIP,
    ASSET
};