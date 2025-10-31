package se.iths.oscarp.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void attack() {
        Player player = new Player.Builder()
                .name("player")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        Enemy enemy = new Enemy(
                "test",
                20,
                0,
                5);
        player.attack(enemy);

        assertEquals(10, enemy.getHealth(), "Health should be 10");
    }
}