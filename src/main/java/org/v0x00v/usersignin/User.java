package org.v0x00v.usersignin;

import jakarta.persistence.*;


@Table(name = "Users")
@Entity
public class User {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="email", unique=true ,nullable=false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    protected User(){}
    public User(Long id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    public void setName(String name) { this.name = name;}
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}



