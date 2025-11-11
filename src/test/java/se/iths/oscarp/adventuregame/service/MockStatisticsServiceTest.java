package se.iths.oscarp.adventuregame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.oscarp.adventuregame.dao.FileStatisticsDao;
import se.iths.oscarp.adventuregame.dao.FileStatisticsDaoTest;
import se.iths.oscarp.adventuregame.dao.StatisticsDao;
import se.iths.oscarp.adventuregame.model.Player;
import se.iths.oscarp.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MockStatisticsServiceTest {
    @Mock
    private FileStatisticsDao dao;
    @InjectMocks
    private StatisticsService statServ;


    @Test
    void getSortedStatistics() {
        List<Statistics> mockedList = new ArrayList<>();
        mockedList.add(new Statistics("PlayerName1", 141 ));
        mockedList.add(new Statistics("PlayerName2", 6 ));
        mockedList.add(new Statistics("PlayerName3", 666 ));
        mockedList.add(new Statistics("PlayerName4", 2999 ));
        mockedList.add(new Statistics("PlayerName5", 30 ));

        Mockito.when(dao.loadAll()).thenReturn(mockedList);

        List<Statistics> result = statServ.getSortedStatistics();

        assertEquals(dao.loadAll(), result, "Sorted list has been sorted");

        assertEquals("PlayerName4", result.get(0).getPlayerName());
        assertEquals("PlayerName3", result.get(1).getPlayerName());
        assertEquals("PlayerName1", result.get(2).getPlayerName());
        assertEquals("PlayerName5", result.get(3).getPlayerName());
        assertEquals("PlayerName2", result.get(4).getPlayerName());





    }
}