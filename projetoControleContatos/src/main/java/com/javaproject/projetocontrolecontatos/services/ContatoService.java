package com.javaproject.projetocontrolecontatos.services;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.repositories.ContatoRepository;
import com.javaproject.projetocontrolecontatos.services.interfaces.ContatoServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;
    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll();
    }
}
