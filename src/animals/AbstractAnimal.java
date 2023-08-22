package animals;


import plants.AbstractPlant;

public abstract class AbstractAnimal implements Runnable{
    private boolean isAlive = true;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract boolean eat(AbstractAnimal animal);

    public abstract boolean eat(AbstractPlant plant);

}
