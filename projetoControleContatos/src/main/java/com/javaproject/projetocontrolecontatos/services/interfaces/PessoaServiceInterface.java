package com.javaproject.projetocontrolecontatos.services.interfaces;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaServiceInterface {

    List<Pessoa> getAll();
    Optional<Pessoa> getById(UUID id);
    void delete(UUID id);
}
