package plants;

public class Rose extends AbstractPlant{
    private String nameOfFlower = "rose";
    private String pictureOfFlower = "🌹";
    private double weightOfFlower = 1.5;

    public Rose() {
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
