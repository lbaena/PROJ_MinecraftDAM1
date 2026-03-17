package lbaena.projecteminecraft.users;

import lbaena.projecteminecraft.fitxers.Fitxers;

import java.io.IOException;
import java.util.List;

public class UserHandler {
    public Fitxers file = new Fitxers("./users.dat");
    private List<User> users;

    public UserHandler() {
        reloadUsers();
    }

    public void PrintUsers() {
        for (User user : users) {
            System.out.println(user.name + " " + user.email + " " + user.password);
        }
    }

    private void reloadUsers() {
        //noinspection unchecked
        users = (List<User>)file.retornaObjectesFitxer(User.class);
    }

    public boolean isEmailRegistered(String email) {
        return getUserByEmail(email) != null;
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.hasSameEmail(email)) {
                return user;
            }
        }

        return null;
    }

    public User getUserByLogin(String email, String password) {
        User user = getUserByEmail(email);
        return user.hasValidCredentials(email, password) ? user : null;
    }

    public boolean addNewUser(String username, String email, String password){
        User newUser = new User(username, email, password);
        if (isEmailRegistered(email)) return false;

        try {
            file.escriuObjecteFitxer(newUser, true);
            reloadUsers();
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
