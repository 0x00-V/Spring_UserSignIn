package org.v0x00v.usersignin.Models;

public class SignIn {
    private String email;
    private String password;

    public SignIn()
    {}


    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

}
