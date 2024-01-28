package portifolioOrange.com.example.orangeJuice.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.repository.TagRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class TagDataLoader implements CommandLineRunner {

    private final TagRepository tagRepository;

    @Autowired
    public TagDataLoader(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<String> tagNames = Arrays.asList(
                "JavaScript", "HTML", "CSS", "Java", "Python", "Ruby", "Swift", "TypeScript", "C#",
                "ReactJS", "Angular", "VueJS", "NodeJS", "Django", "RubyonRails", "SpringFramework",
                "UIUX","UI", "UX", "ResponsiveDesign", "FrontEnd", "WebDesign", "CSSFrameworks", "DesignPatterns",
                "MobileDev", "iOSDev", "AndroidDev", "ReactNative",
                "VSCode", "Atom", "SublimeText", "Eclipse", "IntelliJ",
                "AWS", "Azure", "Docker", "Kubernetes", "ContinuousIntegration", "ContinuousDelivery",
                "MLearning", "DataScience", "TensorFlow", "PyTorch", "AI",
                "WebAssembly", "PWA", "GraphQL", "WebRTC",
                "TechMeetup", "Hackathon", "TechCommunity", "Conference",
                "CareerAdvice", "RemoteWork", "Freelancing", "TechJobs", "TechLeadership"
        );


        for (String tagName : tagNames) {
            Tag tag = new Tag();
            tag.setName(tagName.substring(0, Math.min(tagName.length(), 20)));
            tagRepository.save(tag);
        }

    }
}