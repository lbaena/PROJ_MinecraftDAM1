package lbaena.projecteminecraft.animals;

import lbaena.projecteminecraft.classes.Animal;
import lbaena.projecteminecraft.fitxers.ObjecteAComparar;

public class AnimalComparator extends ObjecteAComparar {
    private final Animal animal;

    public AnimalComparator(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object var1) {
        Animal other = (Animal)var1;
        return other != null && other.getUuid() == animal.getUuid();
    }
}
