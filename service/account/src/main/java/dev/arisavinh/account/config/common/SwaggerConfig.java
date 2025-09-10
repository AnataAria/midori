package dev.arisavinh.account.config.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${server.port}")
    private String port;
    @Bean
    public OpenAPI openAPI() {
        List<Server> serverList = getServerList();

        Contact contact = new Contact()
                .name("ReTrade Development Team")
                .email("contact@arisavinh.dev");

        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("Account API")
                .version("1.0.0")
                .contact(contact)
                .license(license);

        Components components = new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("JWT Bearer Token Authentication\n\n" +
                                "Enter your JWT token in the format: `your-jwt-token`\n" +
                                "You can get this token from the `/auth/login` endpoint."))
                .addSecuritySchemes("cookieAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.COOKIE)
                        .name("ACCESS_TOKEN")
                        .description("Cookie-based Authentication\n\n" +
                                "The ACCESS_TOKEN cookie is automatically set after successful login."));

        List<SecurityRequirement> securityRequirements = new ArrayList<>();
        securityRequirements.add(new SecurityRequirement().addList("bearerAuth"));
        securityRequirements.add(new SecurityRequirement().addList("cookieAuth"));

        return new OpenAPI()
                .info(info)
                .servers(serverList)
                .components(components)
                .security(securityRequirements);
    }

    private List<Server> getServerList() {
        List<Server> serverList = new ArrayList<>();
        var localServer = new Server();
        localServer.setUrl(String.format("http://localhost:%s%s", port, contextPath));
        localServer.setDescription("Local Development Server");
        serverList.add(localServer);
        return serverList;
    }
}
