package lbaena.projecteminecraft.animals;

import lbaena.projecteminecraft.classes.Animal;
import lbaena.projecteminecraft.fitxers.Fitxers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AnimalHandler {
    public static Object getAnimals(String path) {
        Fitxers file = new Fitxers("./" + path);
        return file.retornaObjectesFitxer(Animal.class);
    }

    public static void addAnimal(Animal animal) {
        Fitxers file = new Fitxers("./" + animal.getFilePath());

        try {
            file.escriuObjecteFitxer(animal, true);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

    public static void updateAnimal(Animal animal) {
        removeAnimal(animal);
        addAnimal(animal);
    }

    public static void printAnimals(Animal animal) {
        Fitxers file = new Fitxers("./" + animal.getFilePath());
        try {
            List<Animal> t = (List<Animal>)file.retornaObjectesFitxer(Animal.class);

            for (Animal tt : t) {
                System.out.println(tt.uuid);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean removeAnimal(Animal animal) {
        Fitxers file = new Fitxers("./" + animal.getFilePath());
        List<Animal> animals = (List<Animal>)file.retornaObjectesFitxer(Animal.class);

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getUuid().equals(animal.getUuid())) {
                animals.remove(i);
                break;
            }
        }

        try {
            file.eliminarFitxerDirectori();

            for (Animal value : animals) {
                file.escriuObjecteFitxer(value,true);
            }

        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    public static boolean removeAnimalByTypeAndName(String animalType, String name) {
        String filePath = animalType.trim().toLowerCase(Locale.ROOT) + ".dat";

        if (filePath == null || name == null || name.trim().isEmpty()) {
            return false;
        }

        Fitxers file = new Fitxers("./" + filePath);
        List<Animal> animals = (List<Animal>) file.retornaObjectesFitxer(Animal.class);

        if (animals == null) {
            animals = new ArrayList<>();
        }

        String normalizedName = name.trim();
        boolean removed = false;

        for (int i = 0; i < animals.size(); i++) {
            Animal current = animals.get(i);
            if (current.name != null && current.name.equalsIgnoreCase(normalizedName)) {
                animals.remove(i);
                removed = true;
                break;
            }
        }

        if (!removed) {
            return false;
        }

        try {
            file.eliminarFitxerDirectori();
            for (Animal animal : animals) {
                file.escriuObjecteFitxer(animal, true);
            }
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}