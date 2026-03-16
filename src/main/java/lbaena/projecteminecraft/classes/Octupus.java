
package lbaena.projecteminecraft.classes;

import java.io.IOException;

public class Octupus extends AquaticAnimal {

    @Override
    public void Swim() {

    }

    @Override
    public void Sound() {

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
