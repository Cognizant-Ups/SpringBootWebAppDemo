package com.cts.devops.demo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The type Repository configuration.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.cts.devops.demo.domain"})
@EnableJpaRepositories(basePackages = {"com.cts.devops.demo.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
