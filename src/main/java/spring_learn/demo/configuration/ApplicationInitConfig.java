package spring_learn.demo.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring_learn.demo.constant.PredefinedRole;
import spring_learn.demo.entity.User;
import spring_learn.demo.entity.Role;
import spring_learn.demo.repository.RoleRepository;
import spring_learn.demo.repository.UserRepository;

import java.util.HashSet;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {



    private final PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository){
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()){
                roleRepository.save(Role.builder()
                        .name(PredefinedRole.USER_ROLE)
                        .description("User role")
                        .build());

                Role adminRole = roleRepository.save(Role.builder()
                        .name(PredefinedRole.ADMIN_ROLE)
                        .description("Admin role")
                        .build());
                var roles = new HashSet<Role>();
                roles.add(adminRole);
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
