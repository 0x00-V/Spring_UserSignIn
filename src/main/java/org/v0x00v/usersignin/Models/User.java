package org.v0x00v.usersignin.Models;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column(nullable = false)
    private String password;


    protected User(){}
    public User(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

}
