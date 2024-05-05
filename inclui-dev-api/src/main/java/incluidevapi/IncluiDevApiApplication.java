package incluidevapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@OpenAPIDefinition(
        info = @Info(
                title = "IncluiDev - API",
                version = "1.0.0",
                description = "",

                contact = @Contact(
                        name = "Kaique Souza Santos",
                        email = "kaiquesouzasantos905@gmail.com"
                ),

                license = @License(
                        name = "license",
                        url = ""
                )
        )
)
@SpringBootApplication
@EnableRetry
public class IncluiDevApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(IncluiDevApiApplication.class, args);
    }
}