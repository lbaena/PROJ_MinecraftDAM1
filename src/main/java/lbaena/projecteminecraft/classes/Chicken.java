
package lbaena.projecteminecraft.classes;

import java.io.IOException;
import java.util.List;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Chicken extends BirdAnimal implements IAnimalFunctions {

    @Override
    public void fly() {

    }

    @Override
    public void sound() {

    }

    public static List<Chicken> getChickens() {
        return (List<Chicken>)AnimalHandler.getAnimals("chicken.dat");
    }

    @Override
    public String getFilePath() {
        return "chicken.dat";
    }
}
