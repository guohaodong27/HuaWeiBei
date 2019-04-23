package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userInformation", schema = "goodthing")

public class UserInformationEntity {
    private String email;
    private String id;
    private String password;

    public UserInformationEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserInformationEntity() {
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        UserInformationEntity that = (UserInformationEntity) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id, password);
    }
}
