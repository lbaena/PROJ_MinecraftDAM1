package lbaena.projecteminecraft;

import javafx.application.Application;
import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.classes.Cow;
import lbaena.projecteminecraft.users.UserHandler;

public class Launcher {
    public static void main(String[] args) {
        UserHandler handler = new UserHandler();
        handler.PrintUsers();

        Cow cow = new Cow();
        cow.updateFile();
        cow.removeFromFile();

        Application.launch(HelloApplication.class, args);
    }
}
