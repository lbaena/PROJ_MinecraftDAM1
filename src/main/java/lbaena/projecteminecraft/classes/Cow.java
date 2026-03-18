package lbaena.projecteminecraft.classes;

import java.io.IOException;
import java.util.ArrayList;
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
        return super.getParameters();
    }

    public static List<Cow> getCows() {
        return (List<Cow>) AnimalHandler.getAnimals("cow.dat");
    }

    @Override
    public String getFilePath() {
        return "cow.dat";
    }
}
