package se.iths.oscarp.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class DungeonRoomTest {

    @Test
    void enterRoom() {
        FakeUI ui = new FakeUI();
        ui.setInput("a");
        DungeonRoom dungeonRoom = new DungeonRoom();
        Player player = new Player.Builder()
                .name("player")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        dungeonRoom.enterRoom(player, ui);

        assertTrue(player.hasDefeatedEnemy());
    }
}