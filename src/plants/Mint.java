package plants;

public class Mint extends AbstractPlant{
    private String nameOfFlower = "mint";
    private String pictureOfFlower = "🌿";
    private double weightOfFlower = 2.5;

    public Mint() {
        setNameOfPlant(nameOfFlower);
        setPictureOfPlant(pictureOfFlower);
        setWeightOfPlant(weightOfFlower);
    }

    @Override
    void flowering() {

    }

    @Override
    public void run() {

    }
}
