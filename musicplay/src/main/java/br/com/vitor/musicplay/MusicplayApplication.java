package br.com.vitor.musicplay;

import br.com.vitor.musicplay.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicplayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MusicplayApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}
