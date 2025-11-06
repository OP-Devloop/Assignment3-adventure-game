package se.iths.oscarp.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class DungeonCellRoomTest {
    private FakeUI ui;
    private DungeonCellRoom dungeonCellRoom;
    private Player player;

    @BeforeEach
    public void setUp() {
        ui = new FakeUI();
        dungeonCellRoom = new DungeonCellRoom();
        player = new Player.Builder()
                .name("player")
                .health(100)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void enterRoom() {
        ui.setInput("a");

        dungeonCellRoom.enterRoom(player, ui);

        assertTrue(player.hasDefeatedEnemy());
    }
}