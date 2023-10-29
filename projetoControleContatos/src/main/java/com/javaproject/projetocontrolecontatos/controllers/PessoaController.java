package com.javaproject.projetocontrolecontatos.controllers;


import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.PessoaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Pessoa")
public class PessoaController {

    private PessoaService pessoaService;
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }
}
