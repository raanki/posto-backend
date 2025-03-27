package fr.posto.project.Posto.command;

import org.springframework.boot.CommandLineRunner;

public class GeneratePostWithAICommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0 && !args[0].equals("generate-post")) {
            return;
        }
    }
}
