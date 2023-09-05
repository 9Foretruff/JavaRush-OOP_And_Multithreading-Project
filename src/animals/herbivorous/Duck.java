package animals.herbivorous;

import animals.Animal;
import interfaces.EatAnimal;
import islands.fieldTypes.Ground;
import plants.Plant;

import java.util.HashMap;
import java.util.Random;

public class Duck extends Herbivorous implements EatAnimal {
    private final String pictureOfAnimal = "🦆";
    private final String nameOfAnimal = "duck";
    private final double weightOfAnimal = 1d;
    private final double kilogramsOfFoodForCompleteSaturation = 0.15d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 4;
    private final HashMap<Animal, Integer> animalsThatCanBeEaten = new HashMap<>();
    private final int chanceToKillCaterpillar = 90;
    private double kilogramsOfFoodsInTheStomach = 0.10d;

    {
        animalsThatCanBeEaten.put(new Caterpillar(), chanceToKillCaterpillar);
    }


    public Duck() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(maxStepsPerMove);
    }

    @Override
    public void eatAnimal(Animal animal) {
        int chanceNotToKill;
        if (animalsThatCanBeEaten.containsKey(animal)) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceNotToKill = random.nextInt(0, 100 + 1);
                if (animalsThatCanBeEaten.get(animal) >= chanceNotToKill) {
                    kilogramsOfFoodsInTheStomach += animal.getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }
    }

    protected void getHungry() {
        double hungry = getKilogramsOfFoodForCompleteSaturation() / 100 * 10;
        setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() - hungry);
    }

    @Override
    public void dieFromStarvation() {
        if (kilogramsOfFoodsInTheStomach <= 0) {
            setAlive(false);
        }
    }

    @Override
    public boolean eat(Animal animal) {
        if (animalsThatCanBeEaten.containsKey(animal)) {
            eatAnimal(animal);
        }
        return true;
    }

    @Override
    public boolean eat(Plant plant) {
        eatPlant(plant);
        return true;
    }

    @Override
    public void reproduce(Animal animal) {
        if (animal instanceof Duck) {
            newbornAnimals.add(new Duck());
        }
    }

    @Override
    public void run() {
        while (true) {
            setY(random.nextInt(island.getHeight()));
            setX(random.nextInt(island.getWidth()));
            if (!(island.fields[getY()][getY()].getPictureOfField().equals("🟦")||island.fields[getY()][getY()].getPictureOfField().equals("⛰️"))){
                break;
            }
        }
        island.fields[getY()][getX()].animalsOnField.add(this);
        while (isAlive()) {
            island.moveAnimal(this);

            for (Animal animal : island.fields[getY()][getX()].animalsOnField) {
                this.reproduce(animal);
            }

            for (Plant plant : island.fields[getY()][getX()].plantsOnField) {
                this.eat(plant);
            }

            for (Animal animal : island.fields[getY()][getX()].animalsOnField) {
                this.eat(animal);
            }

            getHungry();
            dieFromStarvation();


            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
