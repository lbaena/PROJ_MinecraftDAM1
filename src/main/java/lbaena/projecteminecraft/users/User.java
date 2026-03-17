package lbaena.projecteminecraft.users;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String email;
    public String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean hasSameEmail(String email) {
        return this.email.equals(email);
    }

    public boolean hasValidCredentials(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}
