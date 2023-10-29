package com.javaproject.projetocontrolecontatos.repositories;

import com.javaproject.projetocontrolecontatos.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {

}

