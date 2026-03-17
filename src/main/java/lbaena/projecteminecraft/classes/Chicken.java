
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
    public void guardaAnimal() throws IOException {
        files.escriuFitxerText("a", false
        );
    }

    @Override
    public void eliminaAnimal() throws IOException {
        //  files.eliminaRegistreFitxerObjecte(this);
    }
}
