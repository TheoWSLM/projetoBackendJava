package com.javaproject.projetocontrolecontatos.services;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.repositories.ContatoRepository;
import com.javaproject.projetocontrolecontatos.services.interfaces.PessoaServiceInterface;
import org.springframework.stereotype.Service;
import com.javaproject.projetocontrolecontatos.services.interfaces.ContatoServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;
@Override
   public Optional<List<Contato>> encontrarContatos(UUID id){
    return Optional.ofNullable(contatoRepository.encontrarContatosComPessoaId(id));
   }
   public void delete(UUID id){
    contatoRepository.deleteById(id);
   }

}
