
package lbaena.projecteminecraft.classes;

import java.io.IOException;
import java.util.List;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Octupus extends AquaticAnimal implements IAnimalFunctions {

    @Override
    public void swim() {

    }

    @Override
    public void sound() {

    }

    public static List<Octupus> getOctopuses() {
        return (List<Octupus>) AnimalHandler.getAnimals("octopus.dat");
    }

    @Override
    public String getFilePath() {
        return "octopus.dat";
    }
}
