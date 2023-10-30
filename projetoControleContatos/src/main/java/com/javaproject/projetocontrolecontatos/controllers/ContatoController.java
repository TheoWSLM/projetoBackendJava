package com.javaproject.projetocontrolecontatos.controllers;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService){

        this.contatoService = contatoService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Contato>> getContatoPorId(UUID id){
        Optional<Contato> contato = contatoService.getById(id);
        if(contato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato);
    }

    @PutMapping("{id}")
    public ResponseEntity<Contato> atualizarContato(@RequestBody Contato contato){
        Contato contatoAtualizado = contatoService.update(contato);

        if(contatoAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contatoAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
