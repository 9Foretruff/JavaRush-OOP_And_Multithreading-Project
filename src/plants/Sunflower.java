package plants;

public class Sunflower extends Plant {

    private final String nameOfFlower = "sunflower";
    private final String pictureOfFlower = "🌻";
    private final double weightOfFlower = 2.0;


    public Sunflower() {
        setNameOfPlant(nameOfFlower);
        setPictureOfPlant(pictureOfFlower);
        setWeightOfPlant(weightOfFlower);
    }

    @Override
    void flowering() {
        newbornPlants.add(new Sunflower());
    }

    @Override
    public void run() {
        while (isAlive()) {
            flowering();
            try {
                this.wait(timeDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
