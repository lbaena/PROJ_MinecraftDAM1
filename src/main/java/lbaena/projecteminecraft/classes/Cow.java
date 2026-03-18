package lbaena.projecteminecraft.classes;

import java.io.IOException;
import java.util.List;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Cow extends MammalAnimal implements IAnimalFunctions {

    @Override
    public void walk() {

    }

    @Override
    public void sound() {

    }

    public static List<Cow> getCows() {
        return (List<Cow>) AnimalHandler.getAnimals("cow.dat");
    }

    @Override
    public String getFilePath() {
        return "cow.dat";
    }
}
