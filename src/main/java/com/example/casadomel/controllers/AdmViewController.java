package com.example.casadomel.controllers;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.services.AdmSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ CORRETO!
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adm")
public class AdmViewController {

    @Autowired
    private AdmSercive admSercive;

    @GetMapping("/login-view")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login-view")
    public String processarLogin(@RequestParam String email,
                                 @RequestParam String senha,
                                 Model model) {
        List<Apicultor> apicultores = admSercive.admLogin(email, senha);
        if (apicultores == null) {
            return "redirect:/adm/login-view?erro=true";
        }
        List<String> nomes = admSercive.listarApicultorsPorNome();
        model.addAttribute("nomes", nomes);
        return "painel";
    }

    @PostMapping("/mel-view")
    public String alterarMel(@RequestParam String nome,
                             @RequestParam Double valor,
                             Model model) {
        admSercive.alterarMel(nome, valor);
        List<String> nomes = admSercive.listarApicultorsPorNome();
        model.addAttribute("nomes", nomes);
        return "painel";
    }

    @PostMapping("/pagou-view")
    public String marcarComoPago(@RequestParam String nome, Model model) {
        admSercive.atualizarPagamento(nome);
        List<String> nomes = admSercive.listarApicultorsPorNome();
        model.addAttribute("nomes", nomes);
        return "painel";
    }
}
