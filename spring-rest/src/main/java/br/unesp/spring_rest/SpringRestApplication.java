package br.unesp.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import br.unesp.spring_rest.entity.Fisica;
// import br.unesp.spring_rest.utils.InstanceGenerator;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	Fisica entity = InstanceGenerator.getPessoaFisica("111.222.333-44", "user1");
	// 	System.out.println("\n" + entity + "\n");
	// }

}
