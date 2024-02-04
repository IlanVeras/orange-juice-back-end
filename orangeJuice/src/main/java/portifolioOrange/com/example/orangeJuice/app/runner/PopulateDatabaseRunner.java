package portifolioOrange.com.example.orangeJuice.app.runner;



import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import portifolioOrange.com.example.orangeJuice.domain.entity.*;
import portifolioOrange.com.example.orangeJuice.domain.repository.ImageRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.ProjectRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.TagRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.UserRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ImageService;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class PopulateDatabaseRunner implements CommandLineRunner {
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final   ImageRepository imageRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public PopulateDatabaseRunner(TagRepository tagRepository, ProjectRepository projectRepository, UserRepository userRepository, ImageRepository storageService, ImageRepository imageRepository, ImageService imageService) {
        this.tagRepository = tagRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;

    }


    @Override
    public void run(String... args) throws Exception {




        Tag ui = new Tag();
        Tag ux = new Tag();
        Tag js = new Tag();
        Tag python = new Tag();
        Tag java = new Tag();
        Tag c = new Tag();
        Tag assembly = new Tag();
        Tag php = new Tag();
        Tag ruby = new Tag();
        Tag kotlin = new Tag();
        Tag cMais = new Tag();
        Tag objectiveC = new Tag();
        Tag r = new Tag();
        Tag typeScript = new Tag();
        Tag reactJS = new Tag();
        Tag reactNative = new Tag();
        Tag nodeJS = new Tag();
        Tag mongoDB = new Tag();
        Tag firebase = new Tag();
        Tag mySQL = new Tag();
        Tag sql = new Tag();
        Tag html = new Tag();
        Tag css = new Tag();
        Tag pascal = new Tag();
        Tag portugol = new Tag();
        Tag django = new Tag();
        ui.setName("UI");
        ux.setName("UX");
        js.setName("JS");
        css.setName("CSS");
        python.setName("Python");
        java.setName("Java");
        c.setName("C#");
        assembly.setName("Assembly");
        php.setName("PHP");
        ruby.setName("Ruby");
        kotlin.setName("Kotlin");
        cMais.setName("C++");
        objectiveC.setName("Objective C");
        r.setName("R");
        typeScript.setName("TypeScript");
        reactJS.setName("React.JS");
        reactNative.setName("React Native");
        nodeJS.setName("Node.JS");
        mongoDB.setName("Mongo DB");
        firebase.setName("Firebase");
        sql.setName("SQL");
        html.setName("HTML");
        mySQL.setName("MySQL");
        pascal.setName("Pascal");
        portugol.setName("Portugol");
        django.setName("Django");
        tagRepository.saveAll(List.of(
                ui, ux, js, python, java, c, assembly, php, ruby, kotlin,
                cMais, objectiveC, r, typeScript, reactJS, reactNative, nodeJS,
                mongoDB, firebase, mySQL, sql, html, css, pascal, portugol, django
        ));

        List<User> userList = Arrays.asList(
                new User("Carlos", "silva", "Brazil", "carlosSilva@gmail.com", "789012", EnumRole.USER),
                new User("Ana", "pereira", "Argentina", "anaPereira@gmail.com", "qwerty", EnumRole.USER),
                new User("Rafael", "oliveira", "Mexico", "rafaelOliveira@gmail.com", "abc123", EnumRole.USER),
                new User("Juliana", "santos", "EUA", "julianaSantos@gmail.com", "456789", EnumRole.USER),
                new User("Felipe", "rodrigues", "Canada", "felipeRodrigues@gmail.com", "xyz456", EnumRole.USER)
        );

        for (User user : userList) {
            String rawPassword = user.getPassword();
            String encodedPassword = passwordEncoder.encode(rawPassword);
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }


        List<Project> projectList = Arrays.asList(
                new Project("Projeto 1", "https://projeto1.com", "Descrição do Projeto 1", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui,ux)),
                new Project("Projeto 2", "https://projeto2.com", "Descrição do Projeto 2", LocalDateTime.of(2022, 11, 20, 14, 30), userList.get(1), List.of(ui,css, js)),
                new Project("Projeto 3", "https://projeto3.com", "Descrição do Projeto 3", LocalDateTime.of(2022, 10, 5, 8, 45), userList.get(2), List.of(python,django,firebase)),
                new Project("Projeto 4", "https://projeto4.com", "Descrição do Projeto 4", LocalDateTime.of(2022, 9, 1, 12, 15), userList.get(3), List.of(python, mongoDB, kotlin)),
                new Project("Projeto 5", "https://projeto5.com", "Descrição do Projeto 5", LocalDateTime.of(2022, 8, 3, 16, 0), userList.get(4), List.of(firebase,kotlin,ruby)),
                new Project("Projeto 6", "https://projeto6.com", "Descrição do Projeto 6", LocalDateTime.of(2022, 7, 10, 9, 30), userList.get(0), List.of(ui,ux, python,django,css,reactNative)),
                new Project("Projeto 7", "https://projeto7.com", "Descrição do Projeto 7", LocalDateTime.of(2022, 6, 25, 11, 45), userList.get(1), List.of(mongoDB,typeScript,css)),
                new Project("Projeto 8", "https://projeto8.com", "Descrição do Projeto 8", LocalDateTime.of(2022, 5, 12, 14, 0), userList.get(2), List.of(pascal,cMais)),
                new Project("Projeto 9", "https://projeto9.com", "Descrição do Projeto 9", LocalDateTime.of(2022, 4, 7, 17, 30), userList.get(3), List.of(php,html,css)),
                new Project("Projeto 10", "https://projeto10.com", "Descrição do Projeto 10", LocalDateTime.of(2022, 3, 22, 10, 0), userList.get(4), List.of(ui,ux)),
                new Project("Projeto 11", "https://projeto11.com", "Descrição do Projeto 11", LocalDateTime.of(2022, 2, 15, 14, 30), userList.get(0), List.of(ui,ux)),
                new Project("Projeto 12", "https://projeto12.com", "Descrição do Projeto 12", LocalDateTime.of(2022, 1, 20, 8, 45), userList.get(1), List.of(ui,ux)),
                new Project("Projeto 13", "https://projeto13.com", "Descrição do Projeto 13", LocalDateTime.of(2021, 12, 5, 12, 15), userList.get(2), List.of(ui,ux)),
                new Project("Projeto 14", "https://projeto14.com", "Descrição do Projeto 14", LocalDateTime.of(2021, 11, 1, 16, 0), userList.get(3), List.of(ui,ux)),
                new Project("Projeto 15", "https://projeto15.com", "Descrição do Projeto 15", LocalDateTime.of(2021, 10, 3, 9, 30), userList.get(4), List.of(ui,ux)),
                new Project("Projeto 16", "https://projeto16.com", "Descrição do Projeto 16", LocalDateTime.of(2021, 9, 10, 11, 45), userList.get(0), List.of(ui,ux)),
                new Project("Projeto 17", "https://projeto17.com", "Descrição do Projeto 17", LocalDateTime.of(2021, 8, 25, 14, 0), userList.get(1), List.of(ui,ux)),
                new Project("Projeto 18", "https://projeto18.com", "Descrição do Projeto 18", LocalDateTime.of(2021, 7, 12, 17, 30), userList.get(2), List.of(ui,ux)),
                new Project("Projeto 19", "https://projeto19.com", "Descrição do Projeto 19", LocalDateTime.of(2021, 6, 7, 10, 0), userList.get(3), List.of(ui,ux)),
                new Project("Projeto 20", "https://projeto20.com", "Descrição do Projeto 20", LocalDateTime.of(2021, 5, 22, 14, 30), userList.get(4), List.of(ui,ux))
        );

        projectRepository.saveAll(projectList);


    }
}