package com.antony.projetos.projetolivraria.config;

import com.antony.projetos.projetolivraria.services.Services;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
@Profile("test")
public class TestConfig {

    private Services services;

    @Bean
    public void instanciaBaseDeDados(){
        this.services.instanciaBaseDeDados();
    }


}
