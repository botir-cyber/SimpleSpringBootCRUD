package ai.ecma.lastlesson;

import ai.ecma.lastlesson.entity.Role;
import ai.ecma.lastlesson.entity.enums.RoleName;
import ai.ecma.lastlesson.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    RoleRepository roleRepository;

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
           roleRepository.save(new Role(RoleName.ROLE_USER,"role user"));
           roleRepository.save(new Role(RoleName.ROLE_ADMIN,"role admin"));
        }


    }
}
