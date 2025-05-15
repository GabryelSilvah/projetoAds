package com.projeto.ads.model;

import com.projeto.ads.dto.UsuarioDto;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "senha")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="role_id")
    private Role role;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "ativo")
    private boolean ativo;

    public UsuarioModel() {

    }

    public UsuarioModel(String userName, String password) {

    }

    public UsuarioModel(UsuarioDto usuarioDto) {
        this.userName = usuarioDto.userName();
        this.password = usuarioDto.senha();
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
        return password;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }

    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }
}
