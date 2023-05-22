package br.com.temperature.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TemperatureFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureFinderApplication.class, args);
    }

}
