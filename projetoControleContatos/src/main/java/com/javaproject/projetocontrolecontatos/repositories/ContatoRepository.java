package com.javaproject.projetocontrolecontatos.repositories;

import com.javaproject.projetocontrolecontatos.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {
    @Query("SELECT contato FROM Contato contato WHERE contato.pessoa.id = :pessoaId")
    List<Contato> encontrarContatosComPessoaId(@Param("pessoaId") UUID pessoaId);

    void delete(UUID id);
}

