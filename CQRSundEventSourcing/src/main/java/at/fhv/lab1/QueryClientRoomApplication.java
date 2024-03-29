package at.fhv.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.query_client.room")
public class QueryClientRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryClientRoomApplication.class, args);
    }

}