package islands.variationsOfIslands;

import exceptions.IncorrectIslandSizeException;
import islands.Island;

public class IslandWithoutNothing extends Island {
    private final int formatPosition = 4;

    public IslandWithoutNothing(int width, int height, String nameOfIsland) throws IncorrectIslandSizeException {
        super(width, height, nameOfIsland);
    }

    @Override
    public void setMapFields() {
        setGroundOnFields();
    }

    @Override
    public void getMapFields() {
        for (int i = 0; i < getWidth() / formatPosition; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                System.out.print(fields[i][j].getPictureOfField());
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
