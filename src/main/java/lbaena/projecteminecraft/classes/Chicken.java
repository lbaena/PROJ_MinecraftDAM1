
package lbaena.projecteminecraft.classes;

import java.io.IOException;

public class Chicken extends BirdAnimal {

    @Override
    public void Fly() {

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
