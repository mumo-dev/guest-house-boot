package com.guesthouse.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ResourceBundleConfig {

    @Bean
    public MessageSource resourceBundleMessageSource() {

        ResourceBundleMessageSource resourceBundleMessageSource =
                new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename( "email" );
        return resourceBundleMessageSource;
    }
}
