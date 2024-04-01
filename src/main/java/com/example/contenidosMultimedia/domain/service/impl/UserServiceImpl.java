package com.example.contenidosMultimedia.domain.service.impl;


import com.example.contenidosMultimedia.domain.repository.UserRepository;
import com.example.contenidosMultimedia.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {



    @Autowired
    private UserRepository userRepository;



    public void guardarUsuario(UserEntity usuario){

        userRepository.save(usuario);

    }


    public void eliminarUsuario (Long id){

        userRepository.deleteById(id);
    }


    public void actualizarUsuario ( Long id, UserEntity usuario ) {

        userRepository.findById(id).map(x->{
            x.setUsername(usuario.getUsername());
            x.setPassword(usuario.getPassword());
            x.setEnabled(usuario.isEnabled());
            x.setAccountNoExpired(usuario.isAccountNoExpired());
            x.setAccountNoLocked(usuario.isAccountNoLocked());
            x.setCredentialNoExpired(usuario.isCredentialNoExpired());
            x.setListaContenido(usuario.getListaContenido());
            x.setRoles(usuario.getRoles());
            return userRepository.save(x);

        }).orElseGet(()->{

            usuario.setId(id);
            return userRepository.save(usuario);
        });


    }

}
