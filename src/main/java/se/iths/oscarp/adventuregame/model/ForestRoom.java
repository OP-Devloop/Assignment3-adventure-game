package se.iths.oscarp.adventuregame.model;

import se.iths.oscarp.adventuregame.view.UI;

public class ForestRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kliver in i en mörk skog. Något glimmar i mossan...");
        String choice = ui.getInput("Vill du undersöka glittret? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Du hittar en nyckel!");
            player.setFoundKey(true);
            player.addScore(20);
        } else {
            ui.showMessage("Du ignorerar glittret och går vidare.");
        }
        ui.showMessage("Nu när du är djupare i skogen kan du se en stuga");
        String choice2 = ui.getInput("Vill du undersöka (ja/nej)?");
        if (choice2.equalsIgnoreCase("ja")) {
            new CabinRoom().enterRoom(player, ui);
        } else {
            ui.showMessage("Du ignorerar det och går vidare.");
        }
    }
}

