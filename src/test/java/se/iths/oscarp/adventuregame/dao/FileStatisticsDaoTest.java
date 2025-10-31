package se.iths.oscarp.adventuregame.dao;

import org.junit.jupiter.api.Test;
import se.iths.oscarp.adventuregame.model.Statistics;
import se.iths.oscarp.adventuregame.service.StatisticsService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileStatisticsDaoTest implements StatisticsDao{

    @Override
    public void save(Statistics stat) {

    }

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> stats = new ArrayList<>();
        stats.add(new Statistics("test3", 3));
        stats.add(new Statistics("test2", 500));
        stats.add(new Statistics("test", 10000));
        stats.add(new Statistics("test4", 3000));
        return stats;
    }
}