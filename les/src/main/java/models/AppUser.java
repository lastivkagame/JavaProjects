package models;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_appUser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="name", nullable=false,length = 250)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserOrder> orders;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="tblUserRoles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="roleId", referencedColumnName = "id")}
    )
    private List<Role> roles;

    public AppUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }

    public AppUser(String name) {
        orders = new ArrayList<UserOrder>();
        roles = new ArrayList<Role>();
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public AppUser() {
        orders = new ArrayList<UserOrder>();
        roles = new ArrayList<Role>();
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
