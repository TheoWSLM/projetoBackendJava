package com.javaproject.projetocontrolecontatos.controllers;


import java.util.Optional;

import com.javaproject.projetocontrolecontatos.dto.PessoaMalaDiretaDTO;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Pessoa/")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoas = pessoaService.getAll();
        if (pessoas == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable UUID id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if(pessoa.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> getPessoaMalaDireta(@PathVariable UUID id) {
        Optional<Pessoa> pessoa = pessoaService.getById(id);

        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PessoaMalaDiretaDTO pessoaDTO = PessoaMalaDiretaDTO.fromPessoa(pessoa);

        return ResponseEntity.ok(pessoaDTO);
    }
}

