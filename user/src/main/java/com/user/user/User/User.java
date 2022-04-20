package com.user.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="User")
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    String Name;
    
    @Column(nullable = false,unique = true)
    String Email;

    @Column(nullable = false)
    String Password;

    String DoB;

    String Number;

    public User() {
    }

    
    public User(int id, String name, String email, String password, String doB, String number) {
        this.id = id;
        Name = name;
        Email = email;
        Password = password;
        DoB = doB;
        Number = number;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }


    @Override
    public String toString() {
        return "User [DoB=" + DoB + ", Email=" + Email + ", Name=" + Name + ", Number=" + Number + ", Password="
                + Password + ", id=" + id + "]";
    }

   
}
