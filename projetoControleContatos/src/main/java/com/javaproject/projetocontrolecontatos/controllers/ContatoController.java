package com.javaproject.projetocontrolecontatos.controllers;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    private ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService){

        this.contatoService = contatoService;
    }
    @Operation(summary = "Retorna as informações do contato que possui o ID passado como parâmetro")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> getContatoPorId(@PathVariable UUID id){
        Optional<Contato> contato = contatoService.getById(id);
        if(contato.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato);
    }
    @Operation(summary = "Atualiza as informações do contato que possui o ID passado como parâmetro")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable UUID id, @RequestBody Contato contato){
        Optional<Contato> verificarContato = contatoService.getById(id);
        if(verificarContato.isPresent()) {
            Contato contatoAtualizado = contatoService.update(id, contato);
            if(contatoAtualizado == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(contatoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deleta o contato que possui o ID passado como parâmetro")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
