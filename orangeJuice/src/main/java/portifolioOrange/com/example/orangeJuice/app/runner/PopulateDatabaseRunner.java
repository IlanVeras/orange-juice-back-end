package portifolioOrange.com.example.orangeJuice.app.runner;



import jakarta.transaction.Transactional;
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


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Transactional
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
    @Transactional
    public void run(String... args) throws Exception {

        List<User> userList = null;


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

        userList = Arrays.asList(
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


        String imagePath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\crypto.png";

        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            String base64EncodedImage = Base64.getEncoder().encodeToString(imageBytes);


            Image image1 = new Image();
            image1.setImage(base64EncodedImage);

            imageRepository.save(image1);


            Project project1 = new Project("Gezz Crypto", "https://projeto1.com", "O projeto de UX/UI para um site de criptomoedas é uma iniciativa que visa proporcionar aos usuários uma experiência envolvente, intuitiva e segura ao explorar e interagir com informações relacionadas a criptomoedas. O principal objetivo é atender às necessidades dos usuários interessados em entender, investir ou negociar ativos digitais, ao mesmo tempo em que proporciona uma sensação de confiança e clareza nas interações.", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image1));

            projectRepository.save(project1);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}