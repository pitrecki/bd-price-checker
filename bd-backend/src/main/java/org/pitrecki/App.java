package org.pitrecki;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@PropertySource("classpath:xpath.properties")
public class App {

    public static void main(String[] args) {
        run(App.class, args);
    }
}
