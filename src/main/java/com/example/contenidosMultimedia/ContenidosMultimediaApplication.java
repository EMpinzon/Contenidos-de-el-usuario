package com.example.contenidosMultimedia;

import com.example.contenidosMultimedia.domain.repository.UserRepository;
import com.example.contenidosMultimedia.persistence.entity.*;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ContenidosMultimediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContenidosMultimediaApplication.class, args);
	}




	@Bean
	CommandLineRunner init 	(UserRepository userRepository){

		return args -> {
			Permission createPermission = Permission.builder()
					.name("CREATE")
					.build();

			Permission readPermission = Permission.builder()
					.name("READ")
					.build();



			Role roleAdmin = Role.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission))
					.build();

			Role roleUser = Role.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of( readPermission))
					.build();


			ContenidoAudioVisual contenidoAudioVisual = ContenidoAudioVisual.builder().tipoDeContenido("Serie").genero("Aventuras")
					.estadoDeVisualizacion("Viendo")
					.plataforma("HBO").calificacion(null).comentario(null).build();

			ContenidoAudioVisual contenidoAudioVisual2 = ContenidoAudioVisual.builder().tipoDeContenido("Pelicula").genero("Deportes")
					.estadoDeVisualizacion("Abandonado")
					.plataforma("Netflix").calificacion("6").comentario("epico").build();


			ContenidoAudioVisual contenidoAudioVisual3 = ContenidoAudioVisual.builder().tipoDeContenido("VideoJuego").genero("Shooter")
					.estadoDeVisualizacion("Terminado")
					.plataforma("Netflix").calificacion("3").comentario("super").build();


			UserEntity userElias = UserEntity.builder()
					.username("elias")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser)).listaContenido(List.of(contenidoAudioVisual,contenidoAudioVisual3))
					.build();

			UserEntity userPaco = UserEntity.builder()
					.username("paco")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin)).listaContenido(List.of(contenidoAudioVisual2))
					.build();

			userRepository.saveAll(List.of(userElias, userPaco));

		};

	}

}
