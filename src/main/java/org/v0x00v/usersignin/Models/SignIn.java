package org.v0x00v.usersignin.Models;

public class SignIn {
    private String username;
    private String password;

    public SignIn()
    {}


    public String getUsername(){return username;}
    public String getPassword()
    {
        return password;
    }
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password)
    {
        this.password = password;
    }

}
