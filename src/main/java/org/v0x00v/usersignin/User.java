package org.v0x00v.usersignin;

import jakarta.persistence.*;


@Table(name = "Users")
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column(nullable = false)
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
}



