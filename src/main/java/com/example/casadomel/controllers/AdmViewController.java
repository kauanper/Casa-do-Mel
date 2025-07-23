package com.example.casadomel.controllers;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.services.AdmSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adm")
public class AdmViewController {

    @Autowired
    private AdmSercive admSercive;

    @GetMapping("/painel")
    public String painel(Model model) {
        List<Apicultor> apicultores = admSercive.buscarTodos();
        model.addAttribute("apicultores", apicultores);
        return "painel";
    }

    @PostMapping("/mel-view")
    public String alterarMel(@RequestParam("nome") String nome, @RequestParam("valor") double valor) {
        admSercive.alterarMel(nome, valor);
        return "redirect:/adm/painel";
    }

    @PostMapping("/pagou-view")
    public String marcarComoPago(@RequestParam("nome") String nome) {
        admSercive.atualizarPagamento(nome);
        return "redirect:/adm/painel";
    }
}
