package com.guesthouse;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GuestHouseApplication {

    final static Logger logger = LoggerFactory.getLogger(
            GuestHouseApplication.class );


    public static void main( String[] args ) {

        Locale.setDefault( Locale.ENGLISH );
        SpringApplication.run( GuestHouseApplication.class, args );
    }


    @Bean
    public CommandLineRunner loadData() {

        return args -> {

        };
    }

}
