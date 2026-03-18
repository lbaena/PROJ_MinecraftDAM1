package lbaena.projecteminecraft.classes;

import java.io.IOException;
import java.util.List;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.interficies.IAnimalFunctions;

public class Cow extends MammalAnimal implements IAnimalFunctions {

    public int milkPoints;

    @Override
    public void walk() {
        System.out.println("La vaca pot caminar");
    }

    @Override
    public void sound() {
        System.out.println("Muuuuu");
    }

    public void changeMilkPoints(int amount) {
        milkPoints += amount;
        milkPoints = Math.max(milkPoints, 0);
    }

    @Override
    public String[] getParameters() {
        String[] params = super.getParameters();
        String[] newparams = new String[params.length + 1];

        System.arraycopy(newparams, 0, params, 0, params.length);

        newparams[params.length] = "Punts de llet: " + milkPoints;
        return newparams;
    }

    public static List<Cow> getCows() {
        return (List<Cow>) AnimalHandler.getAnimals("cow.dat");
    }

    @Override
    public String getFilePath() {
        return "cow.dat";
    }
}
