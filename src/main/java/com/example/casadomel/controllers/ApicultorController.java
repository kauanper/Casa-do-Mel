package com.example.casadomel.controllers;

import com.example.casadomel.dtos.SaveApicultoDTO;
import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.services.ApicultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apicultor")
public class ApicultorController {

    @Autowired
    ApicultorService apicultorService;

    @GetMapping
    public ResponseEntity<List<Apicultor>> getApicultor() {

        List<Apicultor> response = apicultorService.todosApicultores();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Apicultor> addApicultor(@RequestBody SaveApicultoDTO apicultor) {
        String nome = apicultor.nome();
        String email = apicultor.email();
        String senha = apicultor.senha();
        apicultorService.adicionarApicultor(nome, email, senha);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
