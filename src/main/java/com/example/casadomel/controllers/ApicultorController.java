package com.example.casadomel.controllers;

import com.example.casadomel.entities.Apicultor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apicultor")
public class ApicultorController {

    @GetMapping
    public ResponseEntity<List<Apicultor>> getApicultor() {

        return null;
    }
}
