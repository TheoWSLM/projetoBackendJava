package com.javaproject.projetocontrolecontatos.services;

import com.javaproject.projetocontrolecontatos.models.Pessoa;
import com.javaproject.projetocontrolecontatos.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import com.javaproject.projetocontrolecontatos.services.interfaces.PessoaServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService implements PessoaServiceInterface {
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> getById(UUID id) {
        return pessoaRepository.findById(id);
    }
}
