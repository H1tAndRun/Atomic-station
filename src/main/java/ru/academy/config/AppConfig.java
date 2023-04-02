package ru.academy.config;


import org.springframework.context.annotation.*;
import ru.academy.entity.CountryInfo;

@Configuration
@ComponentScan("ru.academy")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Profile("morocco")
    CountryInfo moroccoCountryInfo() {
        return new CountryInfo("Морокоо", "Дирхам");
    }

    @Bean
    @Profile("france")
    CountryInfo franceCountryInfo(){
        return new CountryInfo("Франция","Евро");
    }


}
