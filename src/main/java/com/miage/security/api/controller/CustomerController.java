/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.security.api.controller;

import com.miage.security.api.model.CustomerProfile;
import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author enigmasck
 */
@RestController
public class CustomerController {

    @Secured("ROLE_USER")
    @GetMapping(value = "/user/hello")
    public String welcomeAppUser(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value = "/user/hello4")
    public String welcomeAppUser4(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/user/hello1")
    public String welcomeAppUser1(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }


    @PreAuthorize("hasRole('USER') AND hasRole('ADMIN')")
    @GetMapping(value = "/user/hello2")
    public String welcomeAppUser2(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }

    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    @GetMapping(value = "/user/hello3")
    public String welcomeAppUser3(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/user/hello5")
    public CustomerProfile welcomeAppUser5(@AuthenticationPrincipal User user) {
        return new CustomerProfile("Miage", "TOULOUSE");
    }


    @RolesAllowed("USER")
    @GetMapping(value = "/user/hello6")
    public String welcomeAppUser6(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }


    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping(value = "/user/hello7")
    public String welcomeAppUser7(@AuthenticationPrincipal User user) {
        return "Welcome User " + user.getUsername();
    }

    @GetMapping(value = "/rest/user")
    public CustomerProfile guestUser() {
        return new CustomerProfile("carthage","123");
    }
}

