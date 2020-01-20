package com.guesthouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurationFactoryBean
            freeMarkerConfigurationFactoryBean() {

        FreeMarkerConfigurationFactoryBean bean =
                new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath( "classpath:/templates/email/" );
        return bean;
    }

}
