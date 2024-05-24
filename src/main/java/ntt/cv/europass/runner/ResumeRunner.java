package ntt.cv.europass.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import ntt.cv.europass.dto.ResumeDTO;
import ntt.cv.europass.mapper.ResumeMapper;
import ntt.cv.europass.service.ResumeService;

@Component
public class ResumeRunner implements CommandLineRunner {

    private final ResumeService resumeService;

    public ResumeRunner(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Object pointing to the europass_cv.json file
        ClassPathResource resource = new ClassPathResource("europass_cv.json");

        // Convert URI to a Path object
        Path path = Paths.get(resource.getURI());

        // Read the JSON file into a String
        String json = new String(Files.readAllBytes(path));


        // Save the resume along with its associated data
        resumeService.saveResume(json);
    }
}
