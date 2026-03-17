package lbaena.projecteminecraft;

import javafx.application.Application;
import lbaena.projecteminecraft.users.UserHandler;

public class Launcher {
    public static void main(String[] args) {
        UserHandler handler = new UserHandler();
        handler.PrintUsers();

        Application.launch(HelloApplication.class, args);
    }
}
