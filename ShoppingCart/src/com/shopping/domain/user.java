package com.shopping.domain;

/**
 * Created by 22arsh on 1/25/17.
 */
public class user {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String address;


    public user(int id,String userName,String firstName,String lastName,String address)
    {
        this.id = id;
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
