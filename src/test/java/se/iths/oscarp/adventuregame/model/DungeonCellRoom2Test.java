package se.iths.oscarp.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class DungeonCellRoom2Test {
    private FakeUI ui;
    private DungeonCellRoom2 dungeonCellRoom2;
    private Player player;

    @BeforeEach
    public void setUp() {
        ui = new FakeUI();
        dungeonCellRoom2 = new DungeonCellRoom2();
        player = new Player.Builder()
                .name("player")
                .health(100)
                .score(20)
                .strength(10)
                .build();
    }

    @Test
    void enterRoom() {
        ui.setInput("p");

        dungeonCellRoom2.enterRoom(player, ui);

        assertEquals(10, player.getScore());
    }
}