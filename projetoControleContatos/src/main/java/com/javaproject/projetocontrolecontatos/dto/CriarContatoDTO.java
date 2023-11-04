package com.javaproject.projetocontrolecontatos.dto;

import com.javaproject.projetocontrolecontatos.enums.TipoContato;
import com.javaproject.projetocontrolecontatos.models.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class CriarContatoDTO {


    @NotNull
    private TipoContato tipoContato;

    @NotBlank
    private String contato;


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

}
