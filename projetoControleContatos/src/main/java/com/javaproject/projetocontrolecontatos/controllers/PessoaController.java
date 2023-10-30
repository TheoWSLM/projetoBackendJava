package com.javaproject.projetocontrolecontatos.controllers;


import java.util.Optional;

import com.javaproject.projetocontrolecontatos.dto.PessoaMalaDiretaDTO;
import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import com.javaproject.projetocontrolecontatos.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Pessoa/")
public class PessoaController {

    private PessoaService pessoaService;
    private ContatoService contatoService;

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
    
    @GetMapping("{id}/contatos")
        public ResponseEntity<Optional<List<Contato>>> getContatosPessoa(@PathVariable UUID id){
            Optional<List<Contato>> contatos = contatoService.encontrarContatos(id);
        if (contatos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contatos);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

