package main;

import animals.Animal;
import animals.herbivorous.*;
import animals.predators.*;
import enums.Configuration;
import islands.Island;

import java.util.HashMap;
import java.util.Map;
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
    private Island island;
    private Scanner userChoice = new Scanner(System.in);
    private HashMap<Animal, Integer> availableAnimals = new HashMap<>();
    protected HashMap<Animal, Integer> animalsThatChosenByThePlayer = new HashMap<>();
    private int countOfBoars = 1;
    private int countOfBuffaloes = 1;
    private int countOfCaterpillars = 1;
    private int countOfDeer = 1;
    private int countOfDucks = 1;
    private int countOfGoats = 1;
    private int countOfHorses = 1;
    private int countOfMouses = 1;
    private int countOfRabbits = 1;
    private int countOfSheep = 1;
    private int countOfBear = 1;
    private int countOfBoas = 1;
    private int countOfEagles = 1;
    private int countOfFoxes = 1;
    private int countOfWolfs = 1;

    {
        availableAnimals.put(new Boar(), countOfBoars);
        availableAnimals.put(new Buffalo(), countOfBuffaloes);
        availableAnimals.put(new Caterpillar(), countOfCaterpillars);
        availableAnimals.put(new Deer(), countOfDeer);
        availableAnimals.put(new Duck(), countOfDucks);
        availableAnimals.put(new Goat(), countOfGoats);
        availableAnimals.put(new Horse(), countOfHorses);
        availableAnimals.put(new Mouse(), countOfMouses);
        availableAnimals.put(new Rabbit(), countOfRabbits);
        availableAnimals.put(new Sheep(), countOfSheep);
        availableAnimals.put(new Bear(), countOfBear);
        availableAnimals.put(new Boa(), countOfBoas);
        availableAnimals.put(new Eagle(), countOfEagles);
        availableAnimals.put(new Fox(), countOfFoxes);
        availableAnimals.put(new Wolf(), countOfWolfs);
    }

    public Settings(Configuration configuration, Island island) {
        this.island = island;
        switch (configuration) {
            case DEFAULT -> setDefaultSettings(island);
            case CUSTOM -> setCustomSettings(island);
        }
    }

    private void setCustomSettings(Island island) {
        chooseWhichAnimalsToAdd();
    }

    private void setDefaultSettings(Island island) {
        animalsThatChosenByThePlayer = availableAnimals;
    }

    private void chooseWhichAnimalsToAdd() {
        for (Map.Entry<Animal, Integer> entry : availableAnimals.entrySet()) {
            System.out.println(COMMANDS);
            System.out.println("𝙔𝙤𝙪 𝙬𝙖𝙣𝙩 𝙩𝙤 𝙖𝙙𝙙 " + entry.getKey().getNameOfAnimal() + " " + entry.getKey().getPictureOfAnimal() + "?");
            String answerFromConsole = userChoice.nextLine().toLowerCase();
            if (processOfAdding(entry.getKey(), answerFromConsole)) {
                break;
            }
        }
    }

    private boolean processOfAdding(Animal animal, String answerFromConsole) {
        boolean defaultSettings = false;
        switch (answerFromConsole) {
            case ADD_ANIMAL -> {
                System.out.println("𝙀𝙣𝙩𝙚𝙧 𝙝𝙤𝙬 𝙢𝙪𝙘𝙝 𝙩𝙤 𝙖𝙙𝙙");
                int countOfAnimal = userChoice.nextInt();
                animalsThatChosenByThePlayer.put(animal, countOfAnimal);
            }
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


