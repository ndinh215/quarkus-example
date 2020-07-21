package db.quarkus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="USER")
public class User implements java.io.Serializable {
    private long id;
    private String firstName;
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date added;
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="ADDED")
    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @Column(name="BIRTH_DAY")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
