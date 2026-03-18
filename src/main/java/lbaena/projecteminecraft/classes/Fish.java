
package lbaena.projecteminecraft.classes;

import java.io.IOException;
import java.util.List;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Fish extends AquaticAnimal implements IAnimalFunctions {

    @Override
    public void swim() {

    }

    @Override
    public void sound() {

    }

    public static List<Fish> getFishes() {
        return (List<Fish>) AnimalHandler.getAnimals("fish.dat");
    }

    @Override
    public String getFilePath() {
        return "fish.dat";
    }
}
