package islands.fieldTypes;

import animals.Animal;
import plants.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Field {
    public volatile CopyOnWriteArrayList<Animal> animalsOnField = new CopyOnWriteArrayList<>();
    public volatile CopyOnWriteArrayList<Plant> plantsOnField = new CopyOnWriteArrayList<>();

    private volatile String pictureOfField;

    public String getPictureOfField() {
        if (animalsOnField.size() > 0) {
            Map<Animal, Integer> animalCountMap = new HashMap<>();
            for (Animal animal : animalsOnField) {
                if (animalCountMap.containsKey(animal)) {
                    animalCountMap.put(animal, animalCountMap.get(animal) + 1);
                } else {
                    animalCountMap.put(animal, 1);
                }
            }
            int maxCount = 0;
            Animal maxDuplicateAnimal = null;
            for (Map.Entry<Animal, Integer> entry : animalCountMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxDuplicateAnimal = entry.getKey();
                }
            }
            return maxDuplicateAnimal.getPictureOfAnimal();
        } else if (plantsOnField.size() > 0) {
            Map<Plant, Integer> plantCountMap = new HashMap<>();
            for (Plant animal : plantsOnField) {
                if (plantCountMap.containsKey(animal)) {
                    plantCountMap.put(animal, plantCountMap.get(animal) + 1);
                } else {
                    plantCountMap.put(animal, 1);
                }
            }
            int maxCount = 0;
            Plant maxDuplicatePlant = null;
            for (Map.Entry<Plant, Integer> entry : plantCountMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxDuplicatePlant = entry.getKey();
                }
            }
            return maxDuplicatePlant.getPictureOfPlant();
        } else {
            return pictureOfField;
        }
    }

    public void setPictureOfField(String pictureOfField) {
        this.pictureOfField = pictureOfField;
    }

    abstract void setPicture();

}
