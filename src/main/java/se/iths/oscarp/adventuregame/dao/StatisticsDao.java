package se.iths.oscarp.adventuregame.dao;

import se.iths.oscarp.adventuregame.model.Statistics;

import java.util.List;

public interface StatisticsDao {
    void save(Statistics stat);

    List<Statistics> loadAll();
}

