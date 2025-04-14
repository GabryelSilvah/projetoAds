package com.projeto.ads.services;

import com.projeto.ads.dto.UsuarioDto;
import com.projeto.ads.model.UsuarioModel;
import com.projeto.ads.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositoryUser;

    public UsuarioDto save(UsuarioDto usuarioDto) {

        UsuarioModel modelUser = new UsuarioModel(usuarioDto);
        UsuarioModel userSave = repositoryUser.save(modelUser);

        return new UsuarioDto(userSave.getUserName(), userSave.getSenha());
    }


}
