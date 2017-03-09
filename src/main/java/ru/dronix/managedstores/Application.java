package ru.dronix.managedstores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Controller
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
