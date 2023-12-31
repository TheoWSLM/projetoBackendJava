package com.javaproject.projetocontrolecontatos.controllers;


import com.javaproject.projetocontrolecontatos.dto.AtualizarPessoaDTO;
import com.javaproject.projetocontrolecontatos.dto.CriarContatoDTO;
import com.javaproject.projetocontrolecontatos.dto.CriarPessoaDTO;
import com.javaproject.projetocontrolecontatos.dto.PessoaMalaDiretaDTO;
import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.services.ContatoService;
import com.javaproject.projetocontrolecontatos.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private PessoaService pessoaService;
    private ContatoService contatoService;
@Autowired
    public PessoaController(ContatoService contatoService, PessoaService pessoaService) {
        this.pessoaService = pessoaService;
     this.contatoService = contatoService;

    }

    @Operation(summary = "Retorna uma lista de todas as pessoas.")
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoas = pessoaService.getAll();
        if (pessoas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pessoas);
        }
        return ResponseEntity.ok(pessoas);
    }

    @Operation(summary = "Retorna a pessoa que possui o ID que esta sendo passado como parametro")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable @Valid UUID id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if(pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pessoa);
        }
        return ResponseEntity.ok(pessoa);
    }

    @Operation(summary = "Retorna a pessoa que possui o ID passado com parametro e suas informações de endereço como mala direta")
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> getPessoaMalaDireta(@Valid @PathVariable UUID id) {
        Optional<Pessoa> pessoa = pessoaService.getById(id);

        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else{
            PessoaMalaDiretaDTO pessoaDTO = PessoaMalaDiretaDTO.fromPessoa(pessoa);
            return ResponseEntity.ok(pessoaDTO);
        }

    }
    @Operation(summary = "Retorna os contatos que pertencem a pessoa que possui o ID passado como parâmetro")
    @GetMapping("/{idPessoa}/contatos")
        public ResponseEntity<Optional<List<Contato>>> getContatosPessoa(@PathVariable @Valid UUID idPessoa){

     Optional<Pessoa> pessoa = pessoaService.getById(idPessoa);
     if(pessoa.isPresent()) {
         Optional<List<Contato>> contatos = contatoService.encontrarContatos(idPessoa);
         if (contatos.isEmpty()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(contatos);
         }
         return ResponseEntity.ok(contatos);
     }
     else
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    @Operation(summary = "Criação de um novo contato para a pessoa que possua o ID passado como parâmetro")
    @PostMapping("/{id}/contatos")
    public ResponseEntity<Contato> novoContato(@Valid @RequestBody CriarContatoDTO contatoDTO, @Valid @PathVariable UUID id) {

    Contato contato = new Contato();
    contato.setTipoContato(contatoDTO.getTipoContato());
    contato.setContato(contatoDTO.getContato());

        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if (pessoa.isPresent()){//esta postando só quando o id da pessoa do objeto pessoa dentro de contatos esta com o id correto da pessoa, deve ser colocado para ser a pessoa do id da url
            Pessoa pessoaValidada = pessoa.get();
            contato.setPessoa(pessoaValidada);
            Contato novoContato = contatoService.save(contato);

            if (novoContato == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(novoContato);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Operation(summary = "Atualiza os dados da pessoa que possui o ID passado com parâmetro")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable @Valid UUID id, @RequestBody @Valid AtualizarPessoaDTO pessoaDTO){

    Pessoa pessoa = new Pessoa();
        pessoa.setCidade(pessoaDTO.getCidade());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCep(pessoaDTO.getCep());
        pessoa.setUf(pessoaDTO.getUf());
        pessoa.setCep(pessoaDTO.getCep());
        pessoa.setEndereco(pessoaDTO.getEndereco());



        Optional<Pessoa> verificarPessoa = pessoaService.getById(id);

     if(verificarPessoa.isPresent()) {
         Pessoa pessoaAtualizada = pessoaService.update(id, pessoa);

         if(pessoaAtualizada == null){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }

         return ResponseEntity.ok(pessoaAtualizada);
     }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Operation(summary = "Deleta a pessoa que possui o ID passado com parâmetro")
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid UUID id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Criação de uma nova pessoa e a adiciona ao banco de dados")
    @PostMapping()
    public ResponseEntity<Pessoa> novaPessoa(@Valid @RequestBody CriarPessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCidade(pessoaDTO.getCidade());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCep(pessoaDTO.getCep());
        pessoa.setUf(pessoaDTO.getUf());
        pessoa.setCep(pessoaDTO.getCep());
        pessoa.setEndereco(pessoaDTO.getEndereco());

        Pessoa novaPessoa = pessoaService.save(pessoa);

        if (novaPessoa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(novaPessoa);
    }

}

