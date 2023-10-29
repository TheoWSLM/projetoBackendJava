package com.javaproject.projetocontrolecontatos.models;

import com.javaproject.projetocontrolecontatos.enums.TipoContato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private TipoContato tipoContato;

    @Column(nullable = false)
    private String contato;
    @Column(nullable = false)
    private UUID pessoaId;
    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public UUID getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(UUID pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
