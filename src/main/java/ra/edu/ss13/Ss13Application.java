package ra.edu.ss13;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ra.edu.ss13.model.User;
import ra.edu.ss13.repository.UserRepository;

@SpringBootApplication
public class Ss13Application {

    public static void main(String[] args) {
        SpringApplication.run(Ss13Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("123456"))
                        .role("ADMIN")
                        .enabled(true)
                        .build();
                userRepository.save(user);
            }
        };
    }
}
