package lbaena.projecteminecraft.classes;

import java.io.IOException;

import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Cow extends MammalAnimal implements IAnimalFunctions {

    @Override
    public void walk() {

    }

    @Override
    public void sound() {

    }

    @Override
    public String getFilePath() {
        return "cow.dat";
    }
}
