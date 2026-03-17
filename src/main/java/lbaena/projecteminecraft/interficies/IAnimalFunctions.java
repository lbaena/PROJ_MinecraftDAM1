package lbaena.projecteminecraft.interficies;

import lbaena.projecteminecraft.enums.AnimalHabitat;
import lbaena.projecteminecraft.enums.AnimalType;

public interface IAnimalFunctions {
    public void sound();

    public void eat(int amount);
    public void changeHealth(int amount);
}
