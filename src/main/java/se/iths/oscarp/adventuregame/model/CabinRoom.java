package se.iths.oscarp.adventuregame.model;

import se.iths.oscarp.adventuregame.view.UI;

public class CabinRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går in i stugan");
        String choice = ui.getInput("Där ser du en kista vill du öppna den (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            player.addStrength(5);
            player.addScore(50);
            ui.showMessage("Du hittar ett svärd!!" + "\nDu gör skada: " + player.getStrength());
            ui.showMessage("Du går tillbaka till där du startade");
        } else {
            ui.showMessage("Du ignorerar kistan och går ut ur stugan.");
        }
    }
}

