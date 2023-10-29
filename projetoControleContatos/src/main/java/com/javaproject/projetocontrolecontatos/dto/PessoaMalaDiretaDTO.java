package com.javaproject.projetocontrolecontatos.dto;

import com.javaproject.projetocontrolecontatos.models.Pessoa;

import java.util.Optional;
import java.util.UUID;

public record PessoaMalaDiretaDTO(UUID ID, String Nome, String MalaDireta) {
    public static PessoaMalaDiretaDTO fromPessoa(Optional<Pessoa> pessoa) {
        if (pessoa.isPresent() && pessoa.get() instanceof Pessoa) {
            Pessoa pessoaObj = pessoa.get();
            String malaDireta = String.format(" %s, %s - CEP: %s - %s/%s",
                    pessoaObj.getEndereco(), pessoaObj.getCidade(), pessoaObj.getCep(), pessoaObj.getCidade(), pessoaObj.getUf());
            return new PessoaMalaDiretaDTO(pessoaObj.getId(), pessoaObj.getNome(), malaDireta);
        } else {
            throw new IllegalArgumentException("O objeto passado não é do tipo Pessoa");
        }
    }
}
