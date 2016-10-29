/**
 * Class representation of a card
 *
 * @author Josh Ting
 */
public class Unit extends Card {
    String creatureType;
    int attack;
    int maxHealth;
    int curHealth;

    public Unit(int cost, String text, int attack, int maxHealth, String creatureType) {
        super(CardType.SHIP, cost, text);
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.curHealth = maxHealth;
        this.creatureType = creatureType;
    }
}