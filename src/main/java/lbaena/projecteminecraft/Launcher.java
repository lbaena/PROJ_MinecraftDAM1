package lbaena.projecteminecraft;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.classes.Cow;
import lbaena.projecteminecraft.javafx.Application;
import lbaena.projecteminecraft.users.User;

import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Cow cow1 = new Cow();
        Cow cow2 = new Cow();
        Cow cow3 = new Cow();

        cow1.saveToFile();
        cow2.saveToFile();
        cow3.saveToFile();

        javafx.application.Application.launch(Application.class, args);
    }
}
