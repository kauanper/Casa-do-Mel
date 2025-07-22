package com.example.casadomel.controllers;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.services.ListarApicultores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apicultor")
public class ApicultorController {

    @Autowired
    ListarApicultores listarApicultores;

    @GetMapping
    public ResponseEntity<List<Apicultor>> getApicultor() {

        System.out.println("aaaaaa");
        List<Apicultor> response = listarApicultores.execute();
        return ResponseEntity.ok(response);
    }
}
