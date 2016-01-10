package lv.proq.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by Artyom on 1/10/2016.
 */
@Configuration
public class ResourceConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setCacheSeconds(3600); //refresh cache once per hour
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
