package se.iths.oscarp.adventuregame;

import se.iths.oscarp.adventuregame.dao.FileStatisticsDao;
import se.iths.oscarp.adventuregame.dao.StatisticsDao;
import se.iths.oscarp.adventuregame.model.Player;
import se.iths.oscarp.adventuregame.model.StartRoom;
import se.iths.oscarp.adventuregame.model.Statistics;
import se.iths.oscarp.adventuregame.service.StatisticsService;
import se.iths.oscarp.adventuregame.view.ScannerUI;
import se.iths.oscarp.adventuregame.view.UI;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        UI ui = new ScannerUI();
        Path file = Path.of("data/config.properties");
        ui.showMessage("Välkommen till Äventyrsspelet!");
        AppInfo appInfo = AppInfo.getInstance();
        appInfo.ensureFileExists(file);
        ui.showMessage("Version: " + appInfo.getProperty("app.version"));
        ui.showMessage("Author: " + appInfo.getProperty("app.author"));
        String name = ui.getInput("Ange ditt namn:");

        Player player = new Player.Builder()
                            .name(name)
                            .health(100)
                            .score(0)
                            .strength(10)
                            .build();

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

