package main;

import animals.Animal;
import animals.herbivorous.Boar;
import enums.Configuration;
import exceptions.IncorrectIslandSizeException;
import islands.variationsOfIslands.IslandFromConsole;
import islands.variationsOfIslands.IslandWithRiverAndMountains;
import plants.Mint;
import plants.Plant;

public class Main {
    public static void main(String[] args) throws IncorrectIslandSizeException, InterruptedException {
        IslandWithRiverAndMountains islandWithRiver = new IslandWithRiverAndMountains(30, 30, "Kiev", 10, 10);
        Settings settings = new Settings(Configuration.DEFAULT, islandWithRiver);
        islandWithRiver.setSettings(settings);
        Animal.setIsland(islandWithRiver);
        Plant.setIsland(islandWithRiver);
        Menu menu = new Menu(islandWithRiver, settings);
    }
}
