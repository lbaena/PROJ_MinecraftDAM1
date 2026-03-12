package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;
import lombok.Getter;

public abstract class Animal {
    @Getter
    public final AnimalType type;
    @Getter
    public final AnimalHabitat habitat;

    private int healthPoints;
    private int hunger;

    public Animal(AnimalType type, AnimalHabitat habitat, int healthPoints) {
        this.type = type;
        this.habitat = habitat;
        this.healthPoints = healthPoints;
        hunger = 0;
    }

    public abstract void Sound();

    public void ChangeHealth(int amount) {
        healthPoints = Math.max(healthPoints - amount, 0);
    }

    public void Eat(int amount) {
        amount = Math.max(amount, 0);
        hunger = Math.max(hunger - amount, 0);
    }
}