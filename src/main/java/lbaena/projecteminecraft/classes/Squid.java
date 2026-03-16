
package lbaena.projecteminecraft.classes;

import lombok.ToString;
import vicent.Bellver.Fitxers;

import java.io.IOException;

public class Squid extends AquaticAnimal {

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
