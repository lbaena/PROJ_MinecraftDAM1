package lbaena.projecteminecraft;

import lbaena.projecteminecraft.animals.AnimalHandler;
import lbaena.projecteminecraft.classes.Cow;
import lbaena.projecteminecraft.javafx.Application;
import lbaena.projecteminecraft.users.User;

import java.util.List;
import java.util.Scanner;

public class Launcher {
    private static User user;

    public static void main(String[] args) {


        /*
        while (true) {
            System.out.println("Iniciar sessio o crear usuari? i/c");
            String in = scanner.nextLine();

            UserHandler handler = new UserHandler();

            if (in.equals("i")) {
                System.out.println("Email: ");
                String email = scanner.nextLine();

                System.out.println("Password: ");
                String password = scanner.nextLine();

                user = handler.getUserByLogin(email, password);
                if (user != null) break;

                System.out.println("email o contrasenya invalids");

            } else {
                System.out.println("Username: ");
                String name = scanner.nextLine();

                System.out.println("Email: ");
                String email = scanner.nextLine();

                System.out.println("Password: ");
                String password = scanner.nextLine();

                if (!handler.addNewUser(name, email, password)) {
                    System.out.println("Error al crear usuari");
                    continue;
                }

                user = handler.getUserByLogin(email, password);
                if (user != null) break;

                System.out.println("Error al crear o iniciar sessio");
            }
        }

         */
        //System.out.println("iniciat sessio amb: " + user.name);
        javafx.application.Application.launch(Application.class, args);
    }
}
