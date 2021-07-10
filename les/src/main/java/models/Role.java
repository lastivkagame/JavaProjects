package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="name", nullable=false,length = 250)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> users;

    public Role(String name) {
        this.name = name;
        users = new ArrayList<AppUser>();
    }

    public Role() {
        users = new ArrayList<AppUser>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
