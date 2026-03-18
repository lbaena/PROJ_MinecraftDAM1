package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
public abstract class Animal implements Serializable {
    @Getter
    public final AnimalType type;
    @Getter
    public final AnimalHabitat habitat;

    public String name;
    public String description;
    public String age;
    public String gender;
    public String weight;

    @Getter
    public UUID uuid;

    private int healthPoints;
    private int hunger;

    public abstract void sound();

    public void changeHealth(int amount) {
        healthPoints = Math.max(healthPoints - amount, 0);
    }

    public void eat(int amount) {
        amount = Math.max(amount, 0);
        hunger = Math.max(hunger - amount, 0);
    }

    public Animal(AnimalType type, AnimalHabitat habitat, int healthPoints) {
        this.type = type;
        this.habitat = habitat;
        this.healthPoints = healthPoints;
        uuid = UUID.randomUUID();
        hunger = 0;
    }

    public void saveToFile() {
        AnimalHandler.addAnimal(this);
    }

    public void updateFile() {
        AnimalHandler.updateAnimal(this);
    }

    public void removeFromFile() {
        AnimalHandler.removeAnimal(this);
    }

    public abstract String getFilePath();

    public String[] getParameters() {
        return new String[] {
                "Tipus: " + type.name(),
                "Nom: " + name,
                "Descripcio: " + description,
                "Edat: " + age,
                "Sexe: " + gender,
                "Pes: " + weight,
                "UUID: " + uuid.toString(),
                "Punts de vida: " + healthPoints,
                "Menjar: " + hunger
        };
    }
}