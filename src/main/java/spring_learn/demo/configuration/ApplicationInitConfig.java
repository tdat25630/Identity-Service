package spring_learn.demo.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring_learn.demo.entity.User;
import spring_learn.demo.enums.Role;
import spring_learn.demo.repository.UserRepository;

import java.util.HashSet;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {



    private final PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()){
                var roles = new HashSet<String>();
                roles.add(Role.ADMIN.name());
                User user = User

                        .builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(roles)
                        .build();


                userRepository.save(user);
                log.warn("admin user has been created with default password: admin, please change password");
            }

        };
    }
}
