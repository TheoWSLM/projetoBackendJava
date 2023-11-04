package com.javaproject.projetocontrolecontatos.dto;

import com.javaproject.projetocontrolecontatos.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AtualizarContatoDTO {
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
