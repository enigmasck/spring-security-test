/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.security.api.model;

/**
 *
 * @author enigmasck
 */
public class CustomerProfile {
    private String username;
    private String name;

    public CustomerProfile() {
        super();
    }

    public CustomerProfile(String username, String name) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
