package com.projeto.ads.services;

import com.projeto.ads.model.UsuarioModel;
import com.projeto.ads.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Pegabdo usuário
        UsuarioModel usuario = usuarioRepository.findByUserName(username);


        if (usuario == null) {
            return null;
        }

        return null;
    }
}
