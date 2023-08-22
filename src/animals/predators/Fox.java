package animals.predators;

import animals.AbstractAnimal;
import plants.AbstractPlant;

public class Fox extends AbstractPredator {
    @Override
    public boolean eat(AbstractAnimal animal) {
        return false;
    }

    @Override
    public boolean eat(AbstractPlant plant) {
        return false;
    }

    @Override
    public void eatAnimal(AbstractAnimal animal) {

    }

    @Override
    public void run() {

    }
}
