package com.javaproject.projetocontrolecontatos.services;

import com.javaproject.projetocontrolecontatos.models.Contato;
import com.javaproject.projetocontrolecontatos.repositories.ContatoRepository;
import org.springframework.stereotype.Service;
import com.javaproject.projetocontrolecontatos.services.interfaces.ContatoServiceInterface;

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
    public Contato update(Contato contato) {
        Optional<Contato> contatoAtualizar = contatoRepository.findById(contato.getId());

        if(contatoAtualizar.isPresent()) {
            Contato novoContato = contatoAtualizar.get();
            novoContato.setContato(contato.getContato());
            novoContato.setTipoContato(contato.getTipoContato());
            novoContato.setPessoa(contato.getPessoa());
            return contatoRepository.save(novoContato);
        }
        return contato;
    }
}
