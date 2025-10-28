package se.iths.oscarp.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class TreasureRoomTest {

    @Test
    void enterRoom() {
        FakeUI ui = new FakeUI();
        ui.setInput("ja");
        TreasureRoom treasureRoom = new TreasureRoom();
        Player player = new Player.Builder()
                .name("player")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        player.setFoundKey(true);
        treasureRoom.enterRoom(player, ui);
        assertEquals(true, player.hasOpenedChest());


    }
}