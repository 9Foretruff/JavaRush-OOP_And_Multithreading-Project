package animals.predators;

import animals.Animal;
import animals.herbivorous.Boar;
import animals.herbivorous.Duck;
import animals.herbivorous.Mouse;
import animals.herbivorous.Rabbit;
import exceptions.InterruptedWhileRunningException;
import islands.fieldTypes.Ground;
import plants.Plant;

import java.util.HashMap;
import java.util.Random;

public class Eagle extends Predator {
    private final String pictureOfAnimal = "🦅";
    private final String nameOfAnimal = "eagle";
    private final double weightOfAnimal = 6d;
    private final double kilogramsOfFoodForCompleteSaturation = 1d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 3;
    private final HashMap<Animal, Integer> animalsThatCanBeEaten = new HashMap<>();
    private final int chanceToKillFox = 10;
    private final int chanceToKillRabbit = 90;
    private final int chanceToKillMouse = 90;
    private final int chanceToKillDuck = 80;
    private double kilogramsOfFoodsInTheStomach = 0.5d;

    {
        animalsThatCanBeEaten.put(new Fox(), chanceToKillFox);
        animalsThatCanBeEaten.put(new Rabbit(), chanceToKillRabbit);
        animalsThatCanBeEaten.put(new Mouse(), chanceToKillMouse);
        animalsThatCanBeEaten.put(new Duck(), chanceToKillDuck);
    }

    public Eagle() {
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

    @Override
    public void dieFromStarvation() {

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
        return false;
    }

    @Override
    public void reproduce(Animal animal) {
        if (animal instanceof Eagle && !animal.equals(this)) {
            newbornAnimals.add(new Eagle());
        }
    }

    protected void getHungry() {
        double hungry = getKilogramsOfFoodForCompleteSaturation() / 100 * 10;
        setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() - hungry);
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
                throw new InterruptedWhileRunningException("Thread was interrupted while running");
            }
        }
    }
}
