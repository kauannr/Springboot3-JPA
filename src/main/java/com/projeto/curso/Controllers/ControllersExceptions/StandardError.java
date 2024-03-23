package com.projeto.curso.Controllers.ControllersExceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private Instant timestap;
    private Integer status;
    private String Erro;
    private String message;
    private String path;

    public StandardError(Instant timestap, Integer status, String erro, String message, String path) {
        this.timestap = timestap;
        this.status = status;
        Erro = erro;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestap() {
        return timestap;
    }

    public void setTimestap(Instant timestap) {
        this.timestap = timestap;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return Erro;
    }

    public void setErro(String erro) {
        Erro = erro;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
