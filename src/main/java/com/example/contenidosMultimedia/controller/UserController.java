package com.example.contenidosMultimedia.controller;


import com.example.contenidosMultimedia.domain.service.impl.UserServiceImpl;
import com.example.contenidosMultimedia.persistence.entity.ContenidoAudioVisual;
import com.example.contenidosMultimedia.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @PostMapping("guardarUsuario")

    public ResponseEntity<?> guardarUsuario(@RequestParam UserEntity usuario){

        userServiceImpl.guardarUsuario((usuario));

        return ResponseEntity.ok().build();

    }


    @DeleteMapping("borrarUsuario/{id}")
    public ResponseEntity<?> eliminarUsuario( @PathVariable Long id ){
        userServiceImpl.eliminarUsuario(id);

        return ResponseEntity.ok().build();
    }


    @PutMapping("actualizarUsuario/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id , @RequestParam UserEntity user) {
        userServiceImpl.actualizarUsuario(id,user);
        return ResponseEntity.ok().build();
    }

}
