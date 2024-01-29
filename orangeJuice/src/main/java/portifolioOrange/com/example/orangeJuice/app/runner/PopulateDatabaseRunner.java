package portifolioOrange.com.example.orangeJuice.app.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import portifolioOrange.com.example.orangeJuice.domain.entity.EnumRole;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.repository.ProjectRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.TagRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.UserRepository;

import java.util.List;

@Component
public class PopulateDatabaseRunner implements CommandLineRunner {

    private final TagRepository tagRepository;

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public PopulateDatabaseRunner(TagRepository tagRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Tag ui = new Tag();
        Tag ux = new Tag();
        Tag js = new Tag();
        Tag css = new Tag();

        ui.setName("UI");
        ux.setName("UX");
        js.setName("JS");
        css.setName("CSS");

        tagRepository.saveAll(List.of(ui,ux,js,css));



        User user = new User("Suzana", "forte", "suzanaForte@gmail.com", "123456", EnumRole.USER);


        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);

    }
}