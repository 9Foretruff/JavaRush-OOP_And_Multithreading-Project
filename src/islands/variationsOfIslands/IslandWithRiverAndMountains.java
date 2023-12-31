package islands.variationsOfIslands;

import exceptions.IncorrectIslandSizeException;
import islands.Island;

public class IslandWithRiverAndMountains extends Island {
    private final int countOfLakes;
    private final int countOfMountains;
    private final int formatPosition = 4;

    public IslandWithRiverAndMountains(int width, int height, String nameOfIsland, int countOfLakes, int countOfMountains) throws IncorrectIslandSizeException {
        super(width, height, nameOfIsland);
        setIsland(this);
        this.countOfLakes = countOfLakes;
        this.countOfMountains = countOfMountains;
    }

    @Override
    public void setMapFields() {
        setGroundOnFields();
        setRiversOnFields(countOfLakes);
        setMountainsOnFields(countOfMountains);
    }

    @Override
    public void getMapFields() {
        for (int i = 0; i < getWidth() / formatPosition; i++) {
            System.out.print("\t");
        }
        System.out.println(getNameOfIsland());
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(fields[i][j].getPictureOfField());
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }


}
