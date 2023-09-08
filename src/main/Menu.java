package main;

import animals.Animal;
import islands.Island;
import islands.fieldTypes.Ground;
import plants.*;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Menu implements Runnable {
    protected final int timeDelay = 3000;
    private volatile Island island;
    private boolean isRunning = true;
    private Settings settings;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public Menu(Island island, Settings settings) {
        this.island = island;
        this.settings = settings;
        beginEvolution();
    }

    private void beginEvolution() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        island.setMapFields();
        for (int i = 0; i < island.fields.length; i++) {
            for (int j = 0; j < island.fields[i].length; j++) {
                if (island.fields[i][j] instanceof Ground) {
                    island.fields[i][j].plantsOnField.add(new Sunflower());
                    island.fields[i][j].plantsOnField.add(new Rose());
                    island.fields[i][j].plantsOnField.add(new Mint());
                    island.fields[i][j].plantsOnField.add(new Chamomile());
                }
            }
        }
        for (Map.Entry<Animal, Integer> entry : settings.animalsThatChosenByThePlayer.entrySet()) {
            Animal animal = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                Thread thread = new Thread(animal);
                thread.start();
            }
        }
        while (isRunning) {
            try {
                Thread.sleep(timeDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            island.getMapFields();
            island.getStatistic();
            if (Animal.newbornAnimals.size() > 0) {
                for (Animal animal : Animal.newbornAnimals) {
                    Thread thread = new Thread(animal);
                    thread.start();
                }
                Animal.newbornAnimals.clear();
            }
            if (Plant.newbornPlants.size() > 0) {
                for (Plant plant : Plant.newbornPlants) {
                    Thread thread = new Thread(plant);
                    thread.start();
                }
                Plant.newbornPlants.clear();
            }
        }
    }
}
