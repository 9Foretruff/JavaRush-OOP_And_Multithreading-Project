package plants;

public class Sunflower extends AbstractPlant{

    private String nameOfFlower = "sunflower";
    private String pictureOfFlower = "🌻";
    private double weightOfFlower = 2.0;

    public Sunflower() {
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
