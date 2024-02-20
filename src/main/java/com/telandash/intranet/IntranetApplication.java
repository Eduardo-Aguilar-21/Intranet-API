package com.telandash.intranet;

import com.telandash.intranet.models.InstitutionsModel;
import com.telandash.intranet.models.RoleModel;
import com.telandash.intranet.models.UsersModel;
import com.telandash.intranet.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class IntranetApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(IntranetApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsersRepository usersRepository;
/*
	@Bean
	CommandLineRunner init(){
		return args -> {
			InstitutionsModel empresa = new InstitutionsModel();
			empresa.setId(1L);

			RoleModel rol = new RoleModel();
			rol.setId(1L);

			UsersModel usersModel = UsersModel.builder()
					.name("Eduardo")
					.lastname("Aguilar")
					.dni("78547689")
					.status(true)
					.email("es123y123@gmail.com")
					.username("cond")
					.password(passwordEncoder.encode("1234"))
					.role(rol)
					.build();

			usersRepository.save(usersModel);

		};
	}
*/
}
