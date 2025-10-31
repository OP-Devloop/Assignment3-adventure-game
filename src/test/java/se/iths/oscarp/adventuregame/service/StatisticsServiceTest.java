package se.iths.oscarp.adventuregame.service;

import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.dao.FileStatisticsDao;
import se.iths.oscarp.adventuregame.dao.FileStatisticsDaoTest;
import se.iths.oscarp.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {

    @Test
    void getSortedStatistics() {
        FileStatisticsDaoTest fileDaoTest = new FileStatisticsDaoTest();
        StatisticsService statServ = new StatisticsService(fileDaoTest);

        List<Statistics> sorted = statServ.getSortedStatistics();
        List<Statistics> unsorted = fileDaoTest.loadAll();

        assertNotNull(sorted, "Sorted list should not be null");
        assertNotEquals(unsorted, sorted, "Sorted list has not been sorted");
        
        assertEquals("test", sorted.get(0).getPlayerName());
        assertEquals("test4", sorted.get(1).getPlayerName());
        assertEquals("test2", sorted.get(2).getPlayerName());
        assertEquals("test3", sorted.get(3).getPlayerName());
    }
}