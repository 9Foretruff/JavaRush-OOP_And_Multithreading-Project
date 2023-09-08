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

public class Boa extends Predator {
    private final String pictureOfAnimal = "🐍";
    private final String nameOfAnimal = "boa";
    private final double weightOfAnimal = 15d;
    private final double kilogramsOfFoodForCompleteSaturation = 3d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 1;
    private final HashMap<Animal, Integer> animalsThatCanBeEaten = new HashMap<>();
    private final int chanceToKillFox = 15;
    private final int chanceToKillRabbit = 20;
    private final int chanceToKillMouse = 40;
    private final int chanceToKillDuck = 10;
    private double kilogramsOfFoodsInTheStomach = 1.5d;

    {
        animalsThatCanBeEaten.put(new Fox(), chanceToKillFox);
        animalsThatCanBeEaten.put(new Rabbit(), chanceToKillRabbit);
        animalsThatCanBeEaten.put(new Mouse(), chanceToKillMouse);
        animalsThatCanBeEaten.put(new Duck(), chanceToKillDuck);
    }

    public Boa() {
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
        if (kilogramsOfFoodsInTheStomach <= 0){
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
        return false;
    }

    @Override
    public void reproduce(Animal animal) {
        if (animal instanceof Boa && !animal.equals(this)) {
            newbornAnimals.add(new Boa());
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
