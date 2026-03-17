package lbaena.projecteminecraft.animals;

import lbaena.projecteminecraft.classes.Animal;
import lbaena.projecteminecraft.fitxers.Fitxers;

public class AnimalHandler {
    public static void addAnimal(Animal animal) {
        Fitxers file = new Fitxers("./" + animal.getFilePath());

        try {
            file.escriuObjecteFitxer(animal, true);
        } catch (Exception e) {
            return;
        }
    }

    public static void updateAnimal(Animal animal) {
        removeAnimal(animal);
        addAnimal(animal);
    }

    public static void printAnimals() {

    }

    public static boolean removeAnimal(Animal animal) {
        Fitxers file = new Fitxers("./" + animal.getFilePath());

        try {
            file.eliminaRegistreFitxerObjecte(new AnimalComparator(animal));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}