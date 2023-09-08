package plants;

public class Chamomile extends Plant {

    private final String nameOfFlower = "chamomile";
    private final String pictureOfFlower = "🌼";
    private final double weightOfFlower = 1.0;


    public Chamomile() {
        setNameOfPlant(nameOfFlower);
        setPictureOfPlant(pictureOfFlower);
        setWeightOfPlant(weightOfFlower);
    }

    @Override
    public void run() {
        while (true) {
            setY(random.nextInt(island.getHeight()));
            setX(random.nextInt(island.getWidth()));
            if (!(island.fields[getY()][getY()].getPictureOfField().equals("🟦") || island.fields[getY()][getY()].getPictureOfField().equals("⛰️"))) {
                break;
            }
        }
        while (isAlive()) {
            flowering();
            try {
                this.wait(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    void flowering() {
        newbornPlants.add(new Chamomile());
    }
}
