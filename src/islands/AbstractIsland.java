package islands;

import exceptions.IncorrectIslandSizeException;
import islands.fieldTypes.AbstractField;
import islands.fieldTypes.Ground;
import islands.fieldTypes.Mountains;
import islands.fieldTypes.Water;

import java.util.Random;

public abstract class AbstractIsland {
    private final int minWidth = 10;
    private final int minHeight = 10;
    private final Random random = new Random();
    private final int width;
    private final int height;
    private final String nameOfIsland;
    protected AbstractField[][] fields;
    private int countOfAnimalsOnIsland = 0;
    public AbstractIsland(int width, int height, String nameOfIsland) throws IncorrectIslandSizeException {
        if (minWidth > width || height > height) throw new IncorrectIslandSizeException("Incorrect parameters ! Min width = 10 , Min height = 10");
        this.width = width;
        this.height = height;
        this.nameOfIsland = nameOfIsland;
        this.fields = new AbstractField[width][height];
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

    public int howMuchAnimalsOnIsland(AbstractIsland abstractIsland) {
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

}
