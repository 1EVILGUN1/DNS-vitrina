package dns.vitrina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VitrinaApplication {
    public static void main(String[] args) {
        SpringApplication.run(VitrinaApplication.class, args);
    }
}