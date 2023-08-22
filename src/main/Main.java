package main;

import animals.AbstractAnimal;
import animals.herbivorous.Boar;
import animals.herbivorous.Deer;
import animals.predators.Bear;
import enums.Configuration;
import exceptions.IncorrectIslandSizeException;
import islands.variationsOfIslands.IslandWithRiverAndMountains;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IncorrectIslandSizeException {
        IslandWithRiverAndMountains islandWithRiver = new IslandWithRiverAndMountains(10, 10, "My Island 1", 1, 1);
        Settings settings = new Settings(Configuration.DEFAULT , islandWithRiver);
        Menu menu = new Menu(islandWithRiver, settings);
    }
}