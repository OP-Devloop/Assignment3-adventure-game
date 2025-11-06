package se.iths.oscarp.adventuregame.model;

public class Npc extends AbstractCharacter {

    public Npc(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }

    public void speak() {
        System.out.println("Du där!");
        wait(500);
        System.out.println("Ja DU!!");
        wait(300);
        System.out.println("VARFÖR ÄR DU SÅ FUL!!!");
        wait(1000);
        System.out.println("HA HA HA HA HA HA HA HAHAHAHAHAHA!!!");
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {}
    }
}
