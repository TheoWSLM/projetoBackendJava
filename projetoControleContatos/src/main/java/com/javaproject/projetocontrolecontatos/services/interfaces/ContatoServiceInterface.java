package com.javaproject.projetocontrolecontatos.services.interfaces;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContatoServiceInterface {

    Optional<List<Contato>> encontrarContatos(UUID id);

    void delete(UUID id);

    Optional<Contato> getById(UUID id);

    Contato save(Contato contato);

    Contato update(Contato contato);
}
