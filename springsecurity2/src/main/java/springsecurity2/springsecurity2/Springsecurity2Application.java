package springsecurity2.springsecurity2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Springsecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecurity2Application.class, args);
	
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	
	}

}
