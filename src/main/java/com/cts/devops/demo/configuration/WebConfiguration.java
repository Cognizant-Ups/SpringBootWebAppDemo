package com.cts.devops.demo.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Web configuration.
 */
@Configuration
public class WebConfiguration {
    /**
     * H 2 servlet registration servlet registration bean.
     *
     * @return the servlet registration bean
     */
    @SuppressWarnings("unchecked")
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
