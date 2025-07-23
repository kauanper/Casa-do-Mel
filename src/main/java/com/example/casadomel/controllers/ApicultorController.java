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
    public ResponseEntity<Apicultor> login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        Apicultor response = apicultorService.login(email, senha);
        if(response != null) {
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PatchMapping("/adicionar")
    public ResponseEntity<Apicultor> adicionarColmeia(
            @RequestParam("nome") String nome,
            @RequestParam("valor") int valor){

        Apicultor ap = apicultorService.adicionarColmeia(nome, valor);

        if(ap != null) {
            return ResponseEntity.ok(ap);
        }

        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/remover")
    public ResponseEntity<Apicultor> removerColmeia(
            @RequestParam("nome") String nome,
            @RequestParam("valor") int valor){
        Apicultor ap = apicultorService.removerColmeia(nome, valor);
        if(ap != null) {
            return ResponseEntity.ok(ap);
        }
        return ResponseEntity.status(404).build();
    }
}
