package se.iths.oscarp.adventuregame.model;

import se.iths.oscarp.adventuregame.view.UI;

public class DungeonCellRoom2 implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsecell. En gubbe står i cellen!");
        Npc gubben = new Npc("Gubbe", 15, 0, 5);

        while (player.isAlive() && gubben.isAlive()) {
            String choice2 = ui.getInput("Vill du (p)rata, (a)ttackera eller (r)etirera?");
            if (choice2.equalsIgnoreCase("a")) {
                player.attack(gubben);
                ui.showMessage("Du attackerar gubben! Gubbens HP: " + gubben.getHealth());
                if (gubben.isAlive()) {
                    gubben.attack(player);
                    ui.showMessage("Gubben attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade gubben!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice2.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            } else if (choice2.equalsIgnoreCase("p")) {
                gubben.speak();
                ui.showMessage("Du bilr shockad och springer där ifrån");
                player.loseScore(10);
                break;
            }
        }
    }
}

