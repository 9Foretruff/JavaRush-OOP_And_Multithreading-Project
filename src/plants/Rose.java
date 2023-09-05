package plants;

public class Rose extends Plant {
    private final String nameOfFlower = "rose";
    private final String pictureOfFlower = "🌹";
    private final double weightOfFlower = 1.5;


    public Rose() {
        setNameOfPlant(nameOfFlower);
        setPictureOfPlant(pictureOfFlower);
        setWeightOfPlant(weightOfFlower);
    }

    @Override
    void flowering() {
        newbornPlants.add(new Rose());
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
