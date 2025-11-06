package se.iths.oscarp.adventuregame.model;

import se.iths.oscarp.adventuregame.view.UI;

public class DungeonRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsehåla. En vätte står i vägen!");
        Enemy goblin = new Enemy("Vätte", 20, 0, 5);

        while (player.isAlive() && goblin.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(goblin);
                ui.showMessage("Du attackerar vätten! Vättens HP: " + goblin.getHealth());
                if (goblin.isAlive()) {
                    goblin.attack(player);
                    ui.showMessage("Vätten attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade vätten!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
        ui.showMessage("Du ser nonthing i både cell på höger och på vänster");
        String choice = ui.getInput("Vill du undersöka (ja/nej)?");
        if (choice.equalsIgnoreCase("ja")) {
            String choice2 = ui.getInput("Vilken (h)öger eller (v)änster");
            if (choice2.equalsIgnoreCase("h")) {
                new DungeonCellRoom().enterRoom(player, ui);
            } else if (choice2.equalsIgnoreCase("v")) {
                new DungeonCellRoom2().enterRoom(player, ui);
            }

        } else {
            ui.showMessage("Du ignorerar det och går vidare.");
        }
    }
}

