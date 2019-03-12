/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author enigmasck
 */
@RestController
@RequestMapping("/noAuth/rest/")
public class NoAuthController {
 
      @GetMapping("/sayHi")
	public String sayHi() {
		return "hi";
	}

}
