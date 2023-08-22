package plants;

public class Chamomile extends AbstractPlant{

    private String nameOfFlower = "chamomile";
    private String pictureOfFlower = "🌼";
    private double weightOfFlower = 1.0;


    public Chamomile() {
        setNameOfPlant(nameOfFlower);
        setPictureOfPlant(pictureOfFlower);
        setWeightOfPlant(weightOfFlower);
    }

    @Override
    public void run() {

    }

    @Override
    void flowering() {

    }
}
