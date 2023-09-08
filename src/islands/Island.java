package islands;

import animals.Animal;
import exceptions.IncorrectIslandSizeException;
import islands.fieldTypes.Field;
import islands.fieldTypes.Ground;
import islands.fieldTypes.Mountains;
import islands.fieldTypes.Water;
import main.Settings;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Island {
    private final int minWidth = 10;
    private final int minHeight = 10;
    private final Random random = new Random();
    private final int width;
    private final int height;
    private final String nameOfIsland;
    private final int STAY = 0;
    private final int LEFT = 1;
    private final int RIGHT = 2;
    private final int UP = 3;
    private final int DOWN = 4;
    public volatile Field[][] fields;
    protected Island island;
    private int countOfAnimalsOnIsland = 0;
    private Settings settings;

    public Island(int height, int width, String nameOfIsland) throws IncorrectIslandSizeException {
        if (minWidth > width || height > height)
            throw new IncorrectIslandSizeException("Incorrect parameters ! Min width = 10 , Min height = 10");
        this.width = width;
        this.height = height;
        this.nameOfIsland = nameOfIsland;
        this.fields = new Field[height][width];
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Island getIsland() {
        return island;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public abstract void setMapFields();

    public abstract void getMapFields();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getNameOfIsland() {
        return nameOfIsland;
    }

    public int getCountOfAnimalsOnIsland() {
        return countOfAnimalsOnIsland;
    }

    public void setCountOfAnimalsOnIsland(int countOfAnimalsOnIsland) {
        this.countOfAnimalsOnIsland = countOfAnimalsOnIsland;
    }

    public int howMuchAnimalsOnIsland(Island island) {
        return getCountOfAnimalsOnIsland();
    }

    protected void setRiversOnFields(int countOfLakes) {
        for (int lake = 0; lake < countOfLakes; lake++) {
            int lakeWidth = random.nextInt(4) + 2;
            int lakeHeight = random.nextInt(4) + 2;

            int startX = random.nextInt(getWidth() - lakeWidth + 1);
            int startY = random.nextInt(getHeight() - lakeHeight + 1);

            for (int i = startY; i < startY + lakeHeight; i++) {
                for (int j = startX; j < startX + lakeWidth; j++) {
                    fields[i][j] = new Water();
                }
            }
        }
    }

    protected void setMountainsOnFields(int countOfMountains) {
        for (int mountain = 0; mountain < countOfMountains; mountain++) {
            int mountainWidth = random.nextInt(4) + 1;
            int mountainHeight = random.nextInt(4) + 1;

            int startX = random.nextInt(getWidth() - mountainWidth + 1);
            int startY = random.nextInt(getHeight() - mountainHeight + 1);

            for (int i = startY; i < startY + mountainHeight; i++) {
                for (int j = startX; j < startX + mountainWidth; j++) {
                    if (fields[i][j] instanceof Water) {
                        continue;
                    }
                    fields[i][j] = new Mountains();
                }
            }
        }
    }

    protected void setGroundOnFields() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                fields[i][j] = new Ground();
            }
        }
    }

    public void moveAnimal(Animal animal) {
        int newX = animal.getX();
        int newY = animal.getY();
        int direction = random.nextInt(5);
        int steps = random.nextInt(animal.getMaxStepsPerMove() + 1);
        switch (direction) {
            case UP -> newY = animal.getY() + steps;
            case RIGHT -> newX = animal.getX() + steps;
            case DOWN -> newY = animal.getY() - steps;
            case LEFT -> newX = animal.getX() - steps;
        }
        if (isValidMove(newX, newY, width, height)) {
            fields[animal.getY()][animal.getX()].animalsOnField.remove(animal);
            animal.setX(newX);
            animal.setY(newY);
            fields[newY][newX].animalsOnField.add(animal);
        }
    }

    private boolean isValidMove(int newX, int newY, int maxX, int maxY) {
        if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY) {
            if (fields[newY][newX] instanceof Ground){
                return true;
            }
        }
        return false;
    }

    public void getStatistic(){
        int countOfAnimals = 0;
        for (int i = 0; i < fields.length ; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                for (int k = 0; k < fields[i][j].animalsOnField.size(); k++) {
                    countOfAnimals++;
                }
            }
        }
        System.out.println("countOfAnimals = " + countOfAnimals);

        int countOfPlants = 0;
        for (int i = 0; i < fields.length ; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                for (int k = 0; k < fields[i][j].plantsOnField.size(); k++) {
                    countOfPlants++;
                }
            }
        }
        System.out.println("countOfPlants = " + countOfPlants);
    }

}
