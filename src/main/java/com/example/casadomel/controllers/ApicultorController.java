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

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        if(apicultorService.login(email, senha)) {
            return ResponseEntity.ok("Login bem-sucedido!");
        }else {
            return ResponseEntity.status(401).body("Email ou senha incorretos.");
        }
    }
}
