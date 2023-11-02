package com.javaproject.projetocontrolecontatos.services;

import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaproject.projetocontrolecontatos.services.interfaces.PessoaServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService implements PessoaServiceInterface {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> getById(UUID id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa update(UUID id, Pessoa pessoa) {
        Optional<Pessoa> pessoaAtualizar = pessoaRepository.findById(id);

        if(pessoaAtualizar.isPresent()) {
            Pessoa pessoaAtualizada = pessoaAtualizar.get();
            pessoaAtualizada.setNome(pessoa.getNome());
            pessoaAtualizada.setCidade(pessoa.getCidade());
            pessoaAtualizada.setEndereco(pessoa.getEndereco());
            pessoaAtualizada.setUf(pessoa.getUf());
            pessoaAtualizada.setCep(pessoa.getCep());
            return pessoaRepository.save(pessoaAtualizada);
        }
        return pessoa;
    }
}
