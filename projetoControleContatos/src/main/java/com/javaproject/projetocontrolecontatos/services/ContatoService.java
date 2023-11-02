package com.javaproject.projetocontrolecontatos.services;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaproject.projetocontrolecontatos.services.interfaces.ContatoServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

@Override
   public Optional<List<Contato>> encontrarContatos(UUID id){
    return Optional.ofNullable(contatoRepository.encontrarContatosComPessoaId(id));
   }
   @Override
   public void delete(UUID id){
    contatoRepository.deleteById(id);
   }
@Override
    public Optional<Contato> getById(UUID id) {
    return contatoRepository.findById(id);
    }

    @Override
    public Contato save(Contato contato) {
    return contatoRepository.save(contato);
    }

    @Override
    public Contato update(UUID id, Contato contato) {
        Optional<Contato> contatoAtualizar = contatoRepository.findById(id);

        if(contatoAtualizar.isPresent()) {
            Contato contatoAtualizado = contatoAtualizar.get();
            contatoAtualizado.setContato(contato.getContato());
            contatoAtualizado.setTipoContato(contato.getTipoContato());
            contatoAtualizado.setPessoa(contato.getPessoa());
            return contatoRepository.save(contatoAtualizado);
        }
        return contato;
    }
}
