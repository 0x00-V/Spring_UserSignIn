package org.v0x00v.usersignin.Models;

import jakarta.persistence.*;


@Table
@Entity(name = "Users")
public class User {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="username", nullable=false)
    private String username;

    @Column(name="email", unique=true ,nullable=false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    public User(){}
    public User(Long id, String name, String email, String password)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() { return this.id; }
    public String getUsername() { return this.username; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    public void setUsername(String username) { this.username = username;}
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}


