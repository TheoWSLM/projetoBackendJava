package com.javaproject.projetocontrolecontatos.controllers;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService){

        this.contatoService = contatoService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
