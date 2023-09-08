package plants;

public class Mint extends Plant {
    private final String nameOfFlower = "mint";
    private final String pictureOfFlower = "🌿";
    private final double weightOfFlower = 2.5;

    public Mint() {
        setNameOfPlant(nameOfFlower);
        setPictureOfPlant(pictureOfFlower);
        setWeightOfPlant(weightOfFlower);
    }

    @Override
    void flowering() {
        newbornPlants.add(new Mint());
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
}
