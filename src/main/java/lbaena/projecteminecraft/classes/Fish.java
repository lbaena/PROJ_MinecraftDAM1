
package lbaena.projecteminecraft.classes;

import java.io.IOException;

import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Fish extends AquaticAnimal implements IAnimalFunctions {

    @Override
    public void swim() {

    }

    @Override
    public void sound() {

    }

    @Override
    public String getFilePath() {
        return "fish.dat";
    }
}
