package cl.proyecto.edutech;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Edutech-Project")
                        .version("1.0.0")
                        .description("Documentación del proyecto Edutech.  \n"
                                      +"Integrantes:  \n"  
                                      +"Victor Espindola  \n"
                                      +"Roberto Gonzalez  \n"
                                      +"Francisco Rodriguez"));
    }
}