package com.projeto.ads.model;

import com.projeto.ads.dto.UsuarioDto;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "senha")
    private String senha;

    public UsuarioModel() {

    }

    public UsuarioModel(UsuarioDto usuarioDto) {
        this.userName = usuarioDto.userName();
        this.senha = usuarioDto.senha();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
