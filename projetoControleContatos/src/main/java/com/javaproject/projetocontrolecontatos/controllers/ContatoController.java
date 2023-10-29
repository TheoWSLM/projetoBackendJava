package com.javaproject.projetocontrolecontatos.controllers;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> getAll(){
        List<Contato> contatos = contatoService.getAll();
        if(contatos == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contatos);
    }

}
