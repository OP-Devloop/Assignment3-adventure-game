package se.iths.oscarp.adventuregame.model;

import se.iths.oscarp.adventuregame.view.UI;

public class DungeonCellRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsecell. En kobold står i cellen!");
        EnemyAngry kobold = new EnemyAngry("Kobold", 20, 0, 5);

        while (player.isAlive() && kobold.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera, (h)åna eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(kobold);
                ui.showMessage("Du attackerar kobold! Kobolds HP: " + kobold.getHealth());
                if (kobold.isAlive()) {
                    kobold.attack(player);
                    ui.showMessage("Kobold attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade kobold!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            } else if (choice.equalsIgnoreCase("h")) {
                kobold.addStrength(2);
                ui.showMessage("Kobold blir arg!! Hans styrka ökar till: " + kobold.getStrength());
            }
        }
    }
}

