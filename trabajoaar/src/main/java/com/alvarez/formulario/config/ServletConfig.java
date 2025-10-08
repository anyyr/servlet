package com.alvarez.formulario.config;

import com.alvarez.formulario.servlet.GeneradorClaveServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<GeneradorClaveServlet> servletRegistro() {
        return new ServletRegistrationBean<>(new GeneradorClaveServlet(), "/generarClave");
    }
}