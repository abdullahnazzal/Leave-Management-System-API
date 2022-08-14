package com.example.Leave.Management.System.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(
    name = "users", 
    uniqueConstraints = {
        @UniqueConstraint(name = "users_user_name_unique", columnNames = "user_name"),
        @UniqueConstraint(name = "users_email_unique", columnNames = "email")
})
public class User {
    @Id
    @SequenceGenerator(
        name = "user_sequence", 
        sequenceName = "user_sequence", 
        allocationSize = 1
        )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "user_sequence"
        )

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_name", nullable = false, columnDefinition = "TEXT")
    private String userName;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "staff", nullable = false, columnDefinition = "TEXT")
    private String staff;

    public User() {
    }

    public User(Long id, String userName, String firstName, String lastName, String email, String password,
            String staff) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.staff = staff;
    }

    public User(String userName, String firstName, String lastName, String email, String password, String staff) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.staff = staff;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaff() {
        return this.staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", userName='" + getUserName() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                ", staff='" + getStaff() + "'" +
                "}";
    }

}
