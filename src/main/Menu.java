package main;

import islands.AbstractIsland;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Menu {
    private final AbstractIsland island;
    private boolean isRunning = true;
    private Settings settings;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);

    public Menu(AbstractIsland island, Settings settings) {
        this.island = island;
        this.settings = settings;
        beginEvolution();
    }

    private void beginEvolution(){
        island.setMapFields();
        while (isRunning){
            island.getMapFields();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
