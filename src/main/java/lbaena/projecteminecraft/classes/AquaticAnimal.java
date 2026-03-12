package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;

public abstract class AquaticAnimal extends Animal {
    public AquaticAnimal() {
        super(AnimalType.AQUATIC, AnimalHabitat.WATER, 75);
    }

    public abstract void Swim();
}
