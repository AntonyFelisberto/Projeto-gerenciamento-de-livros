package com.antony.projetos.projetolivraria.config;

import com.antony.projetos.projetolivraria.services.Services;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@AllArgsConstructor
@Profile("dev")
public class DevConfig {

    private Services services;

    @Bean
    public boolean instanciaBaseDeDados(){
        this.services.instanciaBaseDeDados();
        return false;
    }
}
