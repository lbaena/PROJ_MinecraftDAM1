
package lbaena.projecteminecraft.classes;

import java.io.IOException;

import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Chicken extends BirdAnimal implements IAnimalFunctions {

    @Override
    public void fly() {

    }

    @Override
    public void sound() {

    }

    @Override
    public String getFilePath() {
        return "chicken.dat";
    }
}
