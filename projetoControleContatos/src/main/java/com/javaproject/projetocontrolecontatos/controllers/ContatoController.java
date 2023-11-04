package com.javaproject.projetocontrolecontatos.controllers;

import com.javaproject.projetocontrolecontatos.dto.AtualizarContatoDTO;
import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ContatoController(ContatoService contatoService){

        this.contatoService = contatoService;
    }
    @Operation(summary = "Retorna as informações do contato que possui o ID passado como parâmetro")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> getContatoPorId(@PathVariable @Valid UUID id){
        Optional<Contato> contato = contatoService.getById(id);
        if(contato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(contato);
        }
        return ResponseEntity.ok(contato);
    }
    @Operation(summary = "Atualiza as informações do contato que possui o ID passado como parâmetro")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable @Valid UUID id, @RequestBody @Valid AtualizarContatoDTO contatoDTO){

        Optional<Contato> verificarContato = contatoService.getById(id);




        if(verificarContato.isPresent()) {
            Contato contato = new Contato();
            contato.setTipoContato(contatoDTO.getTipoContato());
            contato.setContato(contatoDTO.getContato());
            contato.setPessoa(verificarContato.get().getPessoa());

            Contato contatoAtualizado = contatoService.update(id, contato);
            if(contatoAtualizado == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(contatoAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Deleta o contato que possui o ID passado como parâmetro")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid UUID id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
