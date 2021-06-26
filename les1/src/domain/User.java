package domain;

import com.sun.deploy.panel.IProperty;

public class User extends Person{
    private String email;

    public User(String lastName, String name, String email) {
        super(lastName, name);
        this.email = email;
    }

    public User(String lastName, String name) {
        super(lastName, name);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
       // this.toString();
        String str = "User{ ";
                str += super.toString();
        str +="\n";
        str +=  "email='" + email + '\'' +
                '}';
        return str;
    }

    public String getEmail() {
        return email;
    }
}
