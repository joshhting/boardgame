/**
 * Class representation of a card
 *
 * @author Josh Ting
 */
public class Unit extends Card{
    String creatureType;
    int attack;
    int maxHealth;
    int curHealth;

    public Unit(int attack, int maxHealth, int cost, String creatureType) {
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.curHealth = maxHealth;
        this.creatureType = creatureType;
    }
}