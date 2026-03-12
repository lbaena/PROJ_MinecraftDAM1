package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;

public abstract class BirdAnimal extends Animal {
    public BirdAnimal() {
        super(AnimalType.BIRD, AnimalHabitat.AIR, 50);
    }

    public abstract void Fly();
}
