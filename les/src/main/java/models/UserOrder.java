package models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_user_order")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

   // @Column(name="date_created", nullable=true,length = 250)
    private Date created;

    @Column(nullable=false,length = 250)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private AppUser user;

    public UserOrder(Date created, String transactionId, int user_id) {
        this.created = created;
        this.transactionId = transactionId;
        this.user = new AppUser();
        this.user.setId(user_id);
    }

    public UserOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
