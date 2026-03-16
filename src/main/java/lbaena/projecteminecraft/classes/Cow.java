package lbaena.projecteminecraft.classes;

import vicent.Bellver.Fitxers;

import java.io.IOException;

public class Cow extends MammalAnimal {

    @Override
    public void Walk() {

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
