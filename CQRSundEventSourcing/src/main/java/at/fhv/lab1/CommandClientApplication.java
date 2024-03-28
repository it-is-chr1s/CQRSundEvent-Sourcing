package at.fhv.lab1;

import at.fhv.lab1.commandclient.CommandHandler;
import at.fhv.lab1.eventbus.events.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import at.fhv.lab1.commandclient.EventPublisher;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.commandclient")
public class CommandClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandClientApplication.class, args);
    }

}
