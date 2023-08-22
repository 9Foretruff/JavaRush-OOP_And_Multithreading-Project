package main;

import animals.AbstractAnimal;
import enums.Configuration;
import islands.AbstractIsland;

import java.util.HashSet;

public class Settings {
    private AbstractIsland island;
    private HashSet<AbstractAnimal> animalsThatChosenByThePlayer; //filling the island with animals

    public Settings(Configuration configuration, AbstractIsland island) {
        this.island = island;
        switch (configuration){
            case DEFAULT -> setDefaultSettings(island);
            case CUSTOM -> setCustomSettings(island);
        }
    }

    private void setCustomSettings(AbstractIsland island) {
        chooseWhichAnimalsToAdd();
    }

    private void setDefaultSettings(AbstractIsland island) {

    }

    private void chooseWhichAnimalsToAdd() {

    }

}


