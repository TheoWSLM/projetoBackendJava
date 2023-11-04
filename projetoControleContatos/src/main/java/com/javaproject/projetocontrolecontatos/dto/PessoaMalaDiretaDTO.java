package com.javaproject.projetocontrolecontatos.dto;

import com.javaproject.projetocontrolecontatos.models.Pessoa;

import java.util.Optional;
import java.util.UUID;

public record PessoaMalaDiretaDTO(UUID ID, String Nome, String MalaDireta) {
    public static PessoaMalaDiretaDTO fromPessoa(Optional<Pessoa> pessoa) {

        if(pessoa.isPresent()) {
            Pessoa pessoaObj = pessoa.get();

            StringBuilder malaDiretaBuilder = new StringBuilder();


            String endereco = pessoaObj.getEndereco();
            String cidade = pessoaObj.getCidade();
            String cep = pessoaObj.getCep();
            String uf = pessoaObj.getUf();

            if (endereco != null) {
                malaDiretaBuilder.append(endereco);
            }

            if (cidade != null) {
                if (!malaDiretaBuilder.isEmpty()) {
                    malaDiretaBuilder.append(", ");
                }
                malaDiretaBuilder.append(cidade);
            }

            if (cep != null) {
                if (!malaDiretaBuilder.isEmpty()) {
                    malaDiretaBuilder.append(" - CEP: ");
                }
                malaDiretaBuilder.append(cep);
            }

            if (uf != null) {
                if (!malaDiretaBuilder.isEmpty()) {
                    malaDiretaBuilder.append("/");
                }
                malaDiretaBuilder.append(uf);
            }

            String malaDireta = malaDiretaBuilder.toString();

            return new PessoaMalaDiretaDTO(pessoaObj.getId(), pessoaObj.getNome(), malaDireta);
        }

        return new PessoaMalaDiretaDTO(null, "","");
    }
}
