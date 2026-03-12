package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;

public abstract class MammalAnimal extends Animal {
    public MammalAnimal() {
        super(AnimalType.MAMMAL, AnimalHabitat.GROUND, 100);
    }

    public abstract void Walk();
}
