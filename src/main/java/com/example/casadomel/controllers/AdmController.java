package com.example.casadomel.controllers;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.services.AdmSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmSercive admSercive;

    @GetMapping("/login")
    public ResponseEntity<List<Apicultor>> login(@RequestParam("email") String email, @RequestParam("senha") String senha) {

        List<Apicultor> response = admSercive.admLogin(email, senha);
        if(response == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(response);
    }
}
