package se.iths.oscarp.adventuregame.service;

import se.iths.oscarp.adventuregame.dao.StatisticsDao;
import se.iths.oscarp.adventuregame.model.Statistics;

import java.util.Comparator;
import java.util.List;

public class StatisticsService {
    private final StatisticsDao dao;

    public StatisticsService(StatisticsDao dao) {
        this.dao = dao;
    }

    /**
     * @return Lista med statistik sorterad efter högst score
     */
    public List<Statistics> getSortedStatistics() {
        List<Statistics> stats = dao.loadAll();
        stats.sort(Comparator.comparingInt(Statistics::getScore).reversed());
        return stats;
    }
}

