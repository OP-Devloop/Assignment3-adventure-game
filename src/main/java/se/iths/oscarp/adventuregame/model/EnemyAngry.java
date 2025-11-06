package se.iths.oscarp.adventuregame.model;

public class EnemyAngry extends AbstractCharacter {

    public EnemyAngry(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }

    public void Mock() {
        System.out.println("Du hånar varelsen" + "\nDen blir arg");

    }
}
