package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import vicent.Bellver.Fitxers;

import java.io.IOException;

@AllArgsConstructor
public abstract class Animal {
    @Getter
    public final AnimalType type;
    @Getter
    public final AnimalHabitat habitat;

    public String name;
    public String description;
    public String age;
    public String gender;
    public String weight;

    private int healthPoints;
    private int hunger;

    protected Fitxers files = new Fitxers("./arxius_animals/" + getClass().getSimpleName().toLowerCase() + ".dat");  // fitxer per guardar dads de cada animal

    public abstract void Sound();

    public void ChangeHealth(int amount) {
        healthPoints = Math.max(healthPoints - amount, 0);
    }

    public void Eat(int amount) {
        amount = Math.max(amount, 0);
        hunger = Math.max(hunger - amount, 0);
    }

    public Animal(AnimalType type, AnimalHabitat habitat, int healthPoints) {
        this.type = type;
        this.habitat = habitat;
        this.healthPoints = healthPoints;
        hunger = 0;
    }

    protected abstract void guardaAnimal() throws IOException;

    protected abstract void  eliminaAnimal() throws IOException;

    protected void mostraAnimals() throws IOException, InterruptedException {
        files.mostraContingutFitxer();
    }
}