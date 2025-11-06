package se.iths.oscarp.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.view.FakeUI;
import se.iths.oscarp.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.*;

class CabinRoomTest {
    private FakeUI ui;
    private CabinRoom cabinRoom;
    private Player player;

    @BeforeEach
    public void setUp() {
        ui = new FakeUI();
        cabinRoom = new CabinRoom();
        player = new Player.Builder()
                .name("player")
                .health(100)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void enterRoom() {
        ui.setInput("ja");

        cabinRoom.enterRoom(player, ui);

        assertEquals(15, player.getStrength());
    }
}