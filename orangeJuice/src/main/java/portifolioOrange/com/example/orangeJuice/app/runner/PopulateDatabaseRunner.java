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
        String digital_art = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\digital-art.png";

            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            String base64EncodedImage = Base64.getEncoder().encodeToString(imageBytes);

            Image image1 = new Image();
            image1.setImage(base64EncodedImage);
            imageRepository.save(image1);

            Project project1 = new Project("Gezz Crypto", "https://projeto1.com", "O projeto de UX/UI para um site de criptomoedas é uma iniciativa que visa proporcionar aos usuários uma experiência envolvente, intuitiva e segura ao explorar e interagir com informações relacionadas a criptomoedas. O principal objetivo é atender às necessidades dos usuários interessados em entender, investir ou negociar ativos digitais, ao mesmo tempo em que proporciona uma sensação de confiança e clareza nas interações.", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image1));
        projectRepository.save(project1);


            byte[] imageBytes1 = Files.readAllBytes(Paths.get(digital_art));
             String base64EncodedImage1 = Base64.getEncoder().encodeToString(imageBytes1);
             Image image2 = new Image();
             image2.setImage(base64EncodedImage1);
             imageRepository.save(image2);



        Project project2 = new Project("Digital art", "https://projeto2.com", "projeto teste irmao .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image2));
        projectRepository.save(project2);


        String hatEcommercePath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\hat-ecormece.jpg";
        byte[] hatEcommerceBytes = Files.readAllBytes(Paths.get(hatEcommercePath));
        String base64HatEcommerce = Base64.getEncoder().encodeToString(hatEcommerceBytes);
        Image image3 = new Image();
        image3.setImage(base64HatEcommerce);
        imageRepository.save(image3);
        Project project3 = new Project("Hat E-commerce", "https://projeto3.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image3));
        projectRepository.save(project3);


        String droidPodPath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\droid-pod.png";
        byte[] droidPodBytes = Files.readAllBytes(Paths.get(droidPodPath));
        String base64DroidPod = Base64.getEncoder().encodeToString(droidPodBytes);
        Image image4 = new Image();
        image4.setImage(base64DroidPod);
        imageRepository.save(image4);
        Project project4 = new Project("Droid Pod", "https://projeto4.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image4));
        projectRepository.save(project4);

        String hostReservePath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\host-reserve.png";
        byte[] hostReserveBytes = Files.readAllBytes(Paths.get(hostReservePath));
        String base64HostReserve = Base64.getEncoder().encodeToString(hostReserveBytes);
        Image image5 = new Image();
        image5.setImage(base64HostReserve);
        imageRepository.save(image5);
        Project project5 = new Project("Host Reserve", "https://projeto5.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image5));
        projectRepository.save(project5);



        String kingsmanPath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\kingsman.jpg";
        byte[] kingsmanBytes = Files.readAllBytes(Paths.get(kingsmanPath));
        String base64Kingsman = Base64.getEncoder().encodeToString(kingsmanBytes);
        Image image6 = new Image();
        image6.setImage(base64Kingsman);
        imageRepository.save(image6);
        Project project6 = new Project("Kingsman", "https://projeto6.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image6));
        projectRepository.save(project6);

        String naturalSkinPath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\natural-skin.jpg";
        byte[] naturalSkinBytes = Files.readAllBytes(Paths.get(naturalSkinPath));
        String base64NaturalSkin = Base64.getEncoder().encodeToString(naturalSkinBytes);
        Image image7 = new Image();
        image7.setImage(base64NaturalSkin);
        imageRepository.save(image7);
        Project project7 = new Project("Natural Skin", "https://projeto7.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image7));
        projectRepository.save(project7);

        String nikePath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\nike.png";
        byte[] nikeBytes = Files.readAllBytes(Paths.get(nikePath));
        String base64Nike = Base64.getEncoder().encodeToString(nikeBytes);
        Image image8 = new Image();
        image8.setImage(base64Nike);
        imageRepository.save(image8);
        Project project8 = new Project("Nike", "https://projeto8.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image8));
        projectRepository.save(project8);


        String stormStorePath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\stormtrooper-store.png";
        byte[] stormStoreBytes = Files.readAllBytes(Paths.get(stormStorePath));
        String base64StormStore = Base64.getEncoder().encodeToString(stormStoreBytes);
        Image image9 = new Image();
        image9.setImage(base64StormStore);
        imageRepository.save(image9);
        Project project9 = new Project("Stormtrooper Store", "https://projeto9.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image9));
        projectRepository.save(project9);

        String witcherPath = "C:\\Users\\User\\Documents\\BAKCEND\\orange-juice-back-end\\orangeJuice\\src\\main\\java\\portifolioOrange\\com\\example\\orangeJuice\\app\\runner\\imageRunner\\the-witcher.jpg";
        byte[] witcherBytes = Files.readAllBytes(Paths.get(witcherPath));
        String base64Witcher = Base64.getEncoder().encodeToString(witcherBytes);
        Image image10 = new Image();
        image10.setImage(base64Witcher);
        imageRepository.save(image10);
        Project project10 = new Project("The Witcher", "https://projeto10.com", "projeto teste irmão .", LocalDateTime.of(2022, 12, 15, 10, 0), userList.get(0), List.of(ui, ux), List.of(image10));
        projectRepository.save(project10);
    }
}