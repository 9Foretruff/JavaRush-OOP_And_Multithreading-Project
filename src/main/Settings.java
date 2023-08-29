package main;

import animals.AbstractAnimal;
import animals.herbivorous.*;
import animals.predators.*;
import enums.Configuration;
import islands.AbstractIsland;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Settings {
    private final String ADD_ANIMAL = "1";
    private final String DELETE_ANIMAL = "2";
    private final String DEFAULT = "default";
    private final String EXIT = "exit";
    private final String COMMANDS = "𝐒𝐞𝐭𝐭𝐢𝐧𝐠𝐬 : 𝐜𝐨𝐦𝐦𝐚𝐧𝐝𝐬\n" +
            "𝟏 - 𝐚𝐝𝐝 𝐚𝐧𝐢𝐦𝐚𝐥\n" +
            "𝟐 - 𝐝𝐞𝐥𝐞𝐭𝐞 𝐚𝐧𝐢𝐦𝐚𝐥\n" +
            "𝐝𝐞𝐟𝐚𝐮𝐥𝐭 - 𝐝𝐞𝐟𝐚𝐮𝐥𝐭 𝐬𝐞𝐭𝐭𝐢𝐧𝐠𝐬\n" +
            "𝐞𝐱𝐢𝐭 - 𝐞𝐱𝐢𝐭 𝐭𝐡𝐞 𝐩𝐫𝐨𝐠𝐫𝐚𝐦";
    private AbstractIsland island;
    private Scanner userChoice = new Scanner(System.in);
    private HashSet<AbstractAnimal> availableAnimals = new HashSet<>(); //filling the island with animals
    private HashSet<AbstractAnimal> animalsThatChosenByThePlayer = new HashSet<>();
    private int numberOfBoars = 5;
    private int numberOfBuffaloes = 5;
    private int numberOfCaterpillars = 5;
    private int numberOfDeer = 5;
    private int numberOfDucks = 5;
    private int numberOfGoats = 5;
    private int numberOfHorses = 5;
    private int numberOfMouses = 5;
    private int numberOfRabbits = 5;
    private int numberOfSheep = 5;
    private int numberOfBear = 5;
    private int numberOfBoas = 5;
    private int numberOfEagles = 5;
    private int numberOfFoxes = 5;
    private int numberOfWolfs = 5;

    {
        availableAnimals.add(new Boar());
        availableAnimals.add(new Buffalo());
        availableAnimals.add(new Caterpillar());
        availableAnimals.add(new Deer());
        availableAnimals.add(new Duck());
        availableAnimals.add(new Goat());
        availableAnimals.add(new Horse());
        availableAnimals.add(new Mouse());
        availableAnimals.add(new Rabbit());
        availableAnimals.add(new Sheep());
        availableAnimals.add(new Bear());
        availableAnimals.add(new Boa());
        availableAnimals.add(new Eagle());
        availableAnimals.add(new Fox());
        availableAnimals.add(new Wolf());
    }

    public Settings(Configuration configuration, AbstractIsland island) {
        this.island = island;
        switch (configuration) {
            case DEFAULT -> setDefaultSettings(island);
            case CUSTOM -> setCustomSettings(island);
        }
    }

    private void setCustomSettings(AbstractIsland island) {
        chooseWhichAnimalsToAdd();
    }

    private void setDefaultSettings(AbstractIsland island) {
        animalsThatChosenByThePlayer = availableAnimals;
    }

    private void chooseWhichAnimalsToAdd() {
        Iterator<AbstractAnimal> iterator = availableAnimals.iterator();
        while (iterator.hasNext()) {
            AbstractAnimal animal = iterator.next();
            System.out.println(COMMANDS);
            System.out.println("𝙔𝙤𝙪 𝙬𝙖𝙣𝙩 𝙩𝙤 𝙖𝙙𝙙 " + animal.getNameOfAnimal() + " " + animal.getPictureOfAnimal() + "?");
            String answerFromConsole = userChoice.nextLine().toLowerCase();
            if (processOfAdding(animal, answerFromConsole)) {
                break;
            }
        }
    }

    private boolean processOfAdding(AbstractAnimal animal, String answerFromConsole) {
        boolean defaultSettings = false;
        switch (answerFromConsole) {
            case ADD_ANIMAL -> animalsThatChosenByThePlayer.add(animal);
            case DELETE_ANIMAL -> {
            }
            case DEFAULT -> {
                setDefaultSettings(island);
                defaultSettings = true;
            }
            case EXIT -> System.exit(1);
            default -> {
                String anotherAnswer = userChoice.nextLine().toLowerCase();
                defaultSettings = processOfAdding(animal, anotherAnswer);
            }
        }
        return defaultSettings;
    }

}


