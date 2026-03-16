package lbaena.projecteminecraft.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vicent.Bellver.Fitxers;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    public String name;
    public String email;
    public String password;

    private Fitxers f = new Fitxers("./users.dat");

    public boolean Login() {
        try {
            List<User> users = (List<User>) f.retornaObjectesFitxer(this);
            if (users != null && !users.isEmpty()) {
                for (User user : users) {
                    if (user.getEmail().equals(this.email) && user.getPassword().equals(this.password)) {
                        System.out.println("Login ok per usuari: " + user.getName());
                        return true;
                    }
                }
            }
            System.out.println("Login fallat: Contraseya o correu incorrecte");
            return false;
        } catch (Exception e) {
            System.err.println("Error fent login: " + e.getMessage());
            return false;
        }
    }

    public void Logout() {
        System.out.println("Logout:" + this.name + "has tancat sessió correctament");
    }

    public boolean Register() {
        try {
            // Check if user with this email already exists
            List<User> existingUsers = (List<User>) f.retornaObjectesFitxer(this);
            if (existingUsers != null) {
                for (Object obj : existingUsers) {
                    if (obj instanceof User) {
                        User existingUser = (User) obj;
                        if (existingUser.getEmail().equals(this.email)) {
                            System.out.println("Usuari amb correu" + this.email + "ja existeix");
                            return false;
                        }
                    }
                }
            }

            f.escriuObjecteFitxer(this, true);
            System.out.println("Usuari " + this.name + " registrat correctament");
            return true;
        } catch (Exception e) {
            System.err.println("Error registrant: " + e.getMessage());
            return false;
        }
    }
}
