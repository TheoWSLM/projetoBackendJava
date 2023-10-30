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
    public Pessoa update(Pessoa pessoa) {
        Optional<Pessoa> pessoaAtualizar = pessoaRepository.findById(pessoa.getId());

        if(pessoaAtualizar.isPresent()) {
            Pessoa novaPessoa = pessoaAtualizar.get();
            novaPessoa.setNome(pessoa.getNome());
            novaPessoa.setCidade(pessoa.getCidade());
            novaPessoa.setEndereco(pessoa.getEndereco());
            novaPessoa.setUf(pessoa.getUf());
            novaPessoa.setCep(pessoa.getCep());
            return pessoaRepository.save(novaPessoa);
        }
        return pessoa;
    }
}
