
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.CompteRestJaxRSAPI;

@Configuration
public class MyConfig {
    @Bean
    ResourceConfig resourceConfig(){

        ResourceConfig resourceConfig =new ResourceConfig();
        resourceConfig.register(CompteRestJaxRSAPI.class);
        return  resourceConfig;
    }
}

