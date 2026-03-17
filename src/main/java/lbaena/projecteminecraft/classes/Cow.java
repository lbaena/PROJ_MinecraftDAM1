package lbaena.projecteminecraft.classes;

import lbaena.projecteminecraft.fitxers.Fitxers;

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
    public void guardaAnimal() throws IOException {
        files.escriuFitxerText("a", false
        );
    }

    @Override
    public void eliminaAnimal() throws IOException {
        //  files.eliminaRegistreFitxerObjecte(this);
    }
}
